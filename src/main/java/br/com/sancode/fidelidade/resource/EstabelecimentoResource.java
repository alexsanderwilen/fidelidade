package br.com.sancode.fidelidade.resource;


import br.com.sancode.fidelidade.dto.EstabelecimentoDTO;
import br.com.sancode.fidelidade.model.Estabelecimento;
import br.com.sancode.fidelidade.service.EstabelecimentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoResource {

    @Autowired
    EstabelecimentoServiceImpl estabelecimentoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EstabelecimentoDTO> buscarEstabelecimentos() {
        return estabelecimentoService.buscarEstabelecimentos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstabelecimentoDTO buscarEstabelecimento(@PathVariable("id") Long id) {
        return estabelecimentoService.buscarEstabelecimento(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
        estabelecimentoService.salvarEstabelecimento(estabelecimento);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizarEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
        estabelecimentoService.atualizaEstabelecimento(estabelecimento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void apagarEstabelecimento(@PathVariable("id") Long id) {
        estabelecimentoService.apagarEstabelecimento(id);
    }
}
