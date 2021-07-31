package me.rayll.transacaokafka.consumerkafka;

import me.rayll.transacaokafka.dominio.transacaomanipulacao.TransacaoRequest;
import me.rayll.transacaokafka.repositorio.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(groupId = "api-transacoes",topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoRequest dto) {

        try{
            transacaoRepository.save(dto.toModel());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }
}
