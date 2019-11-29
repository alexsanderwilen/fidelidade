package br.com.sancode.fidelidade.service;

import br.com.sancode.fidelidade.model.Cliente;
import br.com.sancode.fidelidade.model.enums.Perfil;
import br.com.sancode.fidelidade.repository.ClienteRepository;
import br.com.sancode.fidelidade.resource.exception.NoContentException;
import br.com.sancode.fidelidade.resource.exception.ObjectNotFoundException;
import br.com.sancode.fidelidade.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmailService emailService;


    @Override
    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public Cliente bucaCliente(Long id) {

        UserSS userSS = UserService.authenticated();

        if (userSS == null || !userSS.hasRole(Perfil.ADMIN) && !id.equals(userSS.getId())) {
            throw new AuthorizationException("Acesso Negado");
        }

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (!cliente.isPresent()) {
            throw new NoContentException("Cliente não encontrado! Id: " + id + Cliente.class.getName());
        }
        return cliente.get();
    }

    @Override
    public Cliente buscarClienteEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public void salvarCliente(Cliente cliente) {
        cliente.setSenha(bCryptPasswordEncoder.encode(cliente.getSenha()));
        clienteRepository.save(cliente);
        emailService.sendOrderConfimationEmail(cliente);
    }

    @Override
    public void atualizaCliente(Cliente cliente) {

        Cliente cli = clienteRepository.getOne(cliente.getId());
        if (!cli.getSenha().equals(cliente.getSenha())) {
            cliente.setSenha(bCryptPasswordEncoder.encode(cliente.getSenha()));
        }
        clienteRepository.save(cliente);
    }

    @Override
    public void apagaCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}