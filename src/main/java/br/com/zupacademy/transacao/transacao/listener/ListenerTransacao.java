package br.com.zupacademy.transacao.transacao.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

import br.com.zupacademy.transacao.transacao.EventoTransacaoRequest;
import br.com.zupacademy.transacao.transacao.Transacao;
import br.com.zupacademy.transacao.transacao.TransacaoRepository;

@Component
public class ListenerTransacao {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void listen(EventoTransacaoRequest eventoTransacaoRequest) {
		Transacao transacao = eventoTransacaoRequest.toModel();
		transacaoRepository.save(transacao);
	}
	
	@Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }
}
