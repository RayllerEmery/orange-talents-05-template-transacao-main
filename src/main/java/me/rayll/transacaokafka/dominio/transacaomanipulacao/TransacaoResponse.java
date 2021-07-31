package me.rayll.transacaokafka.dominio.transacaomanipulacao;

import me.rayll.transacaokafka.dominio.Cartao;
import me.rayll.transacaokafka.dominio.Estabelecimento;
import me.rayll.transacaokafka.dominio.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private BigDecimal valor;

    private Estabelecimento estabelecimento;

    private LocalDateTime efetivadaEm;

    @Deprecated
    private TransacaoResponse() {
    }

    public TransacaoResponse(BigDecimal valor, Estabelecimento estabelecimento, LocalDateTime efetivadaEm) {
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.efetivadaEm = efetivadaEm;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }
}
