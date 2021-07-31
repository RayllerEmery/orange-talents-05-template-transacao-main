package me.rayll.transacaokafka.transacaorequest;

import me.rayll.transacaokafka.dominio.transacaomanipulacao.TransacaoResponse;
import me.rayll.transacaokafka.repositorio.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;
    @GetMapping("/{id}")
    public ResponseEntity<List<TransacaoResponse>> pedidoTransacao(
            @PathVariable String id,
            @PageableDefault(size = 10, sort = "efetivadaEm", direction = Sort.Direction.DESC)
            Pageable pageable, Principal principal) {

        var listaTransacoes = transacaoRepository.findByCartao(id, pageable);
        var listaRetorno = listaTransacoes.stream().map(it -> it.toResponse()).collect(Collectors.toList());

        return ResponseEntity.ok(listaRetorno);
    }
}
