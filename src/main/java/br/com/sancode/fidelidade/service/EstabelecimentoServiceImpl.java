package br.com.sancode.fidelidade.service;

import br.com.sancode.fidelidade.dto.EstabelecimentoDTO;
import br.com.sancode.fidelidade.model.Estabelecimento;
import br.com.sancode.fidelidade.repository.EstabelecimentoRepository;
import br.com.sancode.fidelidade.resource.exception.NoContentException;
import br.com.sancode.fidelidade.resource.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    @Autowired
    EstabelecimentoRepository estabelecimentoRepository;

    @Override
    public List<EstabelecimentoDTO> buscarEstabelecimentos() {
        List<Estabelecimento> estabelecimentos = estabelecimentoRepository.findAll();

        if (!estabelecimentos.isEmpty()) {
            List<EstabelecimentoDTO> estabelecimentoDTOS = new ArrayList<>();
            for (Estabelecimento estabelecimento : estabelecimentos) {
                estabelecimentoDTOS.add(EstabelecimentoDTO.builder()
                        .id(estabelecimento.getId())
                        .razaoSocial(estabelecimento.getRazaoSocial())
                        .cnpj(estabelecimento.getCnpj())
                        .endereco(estabelecimento.getEndereco())
                        .numero(estabelecimento.getNumero())
                        .bairro(estabelecimento.getBairro())
                        .cidade(estabelecimento.getCidade())
                        .uf(estabelecimento.getUf())
                        .email(estabelecimento.getEmail()).build());
            }
            return estabelecimentoDTOS;
        } else throw new NoContentException("Não há Estabelecimentos");
    }

    @Override
    public EstabelecimentoDTO buscarEstabelecimento(Long id) {
        Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(id);

        if (estabelecimento.isPresent()) {
            return EstabelecimentoDTO.builder()
                    .id(estabelecimento.get().getId())
                    .razaoSocial(estabelecimento.get().getRazaoSocial())
                    .cnpj(estabelecimento.get().getCnpj())
                    .endereco(estabelecimento.get().getEndereco())
                    .numero(estabelecimento.get().getNumero())
                    .bairro(estabelecimento.get().getBairro())
                    .cidade(estabelecimento.get().getCidade())
                    .uf(estabelecimento.get().getUf())
                    .email(estabelecimento.get().getEmail()).build();
        } else
            throw new NoContentException("Estabelecimento não encontrado. Código: " + id + Estabelecimento.class.getName());
    }

    @Override
    public void salvarEstabelecimento(Estabelecimento estabelecimento) {
        estabelecimentoRepository.save(estabelecimento);
    }

    @Override
    public void atualizaEstabelecimento(Estabelecimento estabelecimento) {
        estabelecimentoRepository.save(estabelecimento);
    }

    @Override
    public void apagarEstabelecimento(Long id) {
        estabelecimentoRepository.deleteById(id);
    }
}
