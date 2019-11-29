package br.com.sancode.fidelidade.resource;

import br.com.sancode.fidelidade.model.Cliente;
import br.com.sancode.fidelidade.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    // @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> buscarClientes() {
        return clienteService.buscarClientes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarCliente(@PathVariable("id") Long id) {
        return clienteService.bucaCliente(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarCliente(@RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizarCliente(@RequestBody Cliente cliente) {
        clienteService.atualizaCliente(cliente);
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void apagarCliente(@PathParam("id") Long id) {
        clienteService.apagaCliente(id);
    }
}