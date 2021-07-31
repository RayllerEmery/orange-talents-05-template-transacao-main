package me.rayll.transacaokafka.dominio;

import me.rayll.transacaokafka.dominio.transacaomanipulacao.TransacaoRequest;
import me.rayll.transacaokafka.dominio.transacaomanipulacao.TransacaoResponse;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    private BigDecimal valor;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nome", column = @Column(name = "nomeEstabelecimento")),
            @AttributeOverride(name = "cidade", column = @Column(name = "cidadeEstabelecimento")),
            @AttributeOverride(name = "endereco", column = @Column(name = "enderecoEstabelecimento")),
    })
    private Estabelecimento estabelecimento;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "idCartao")),
            @AttributeOverride(name = "email", column = @Column(name = "emailCartao"))
    })
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransacaoResponse toResponse() {
        TransacaoResponse response = new TransacaoResponse(
                this.valor,
                this.estabelecimento,
                this.efetivadaEm
        );

        return response;
    }
}
