package br.com.sancode.fidelidade.service;

import br.com.sancode.fidelidade.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    List<Cliente> buscarClientes();

    Cliente bucaCliente(Long id);

    Cliente buscarClienteEmail(String email);

    void salvarCliente(Cliente cliente);

    void atualizaCliente(Cliente cliente);

    void apagaCliente(Long id);
}
