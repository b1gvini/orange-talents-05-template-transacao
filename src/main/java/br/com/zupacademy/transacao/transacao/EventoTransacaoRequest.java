package br.com.zupacademy.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.transacao.cartao.CartaoRequest;
import br.com.zupacademy.transacao.estabelecimento.EstabelecimentoRequest;

public class EventoTransacaoRequest {

	@NotBlank
	@JsonProperty
	private String id;
	@NotNull
	@JsonProperty
	private BigDecimal valor;
	@NotNull
	@JsonProperty
	private EstabelecimentoRequest estabelecimento;
	@NotNull
	@JsonProperty
	private CartaoRequest cartao;
	@NotNull
	@JsonProperty
	private LocalDateTime efetivadaEm;
	
	public EventoTransacaoRequest() {
		
	}

	public EventoTransacaoRequest(String id, BigDecimal valor, EstabelecimentoRequest estabelecimento, CartaoRequest cartao,
			LocalDateTime efetivadaEm) {
		super();
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public Transacao toModel() {
		return new Transacao(id, valor, estabelecimento.toModel(), cartao.toModel(), efetivadaEm);
	}

	@Override
	public String toString() {
		return "EventoTransacaoRequest [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento
				+ ", cartao=" + cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}
	
	

}
