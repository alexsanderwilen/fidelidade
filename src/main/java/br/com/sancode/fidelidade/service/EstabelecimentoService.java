package br.com.sancode.fidelidade.service;

import br.com.sancode.fidelidade.dto.EstabelecimentoDTO;
import br.com.sancode.fidelidade.model.Estabelecimento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstabelecimentoService {
    List<EstabelecimentoDTO> buscarEstabelecimentos();

    EstabelecimentoDTO buscarEstabelecimento(Long id);

    void salvarEstabelecimento(Estabelecimento estabelecimento);

    void atualizaEstabelecimento(Estabelecimento estabelecimento);

    void apagarEstabelecimento(Long id);
}
