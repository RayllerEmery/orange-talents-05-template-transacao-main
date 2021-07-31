package me.rayll.transacaokafka.repositorio;

import me.rayll.transacaokafka.dominio.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    @Query("select t from Transacao t where t.cartao.id=:id")
    public Page<Transacao> findByCartao(@Param("id") String id, Pageable pageable);
}
