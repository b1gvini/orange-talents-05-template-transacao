package br.com.zupacademy.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.transacao.cartao.CartaoResponse;
import br.com.zupacademy.transacao.estabelecimento.EstabelecimentoResponse;

public class EventoTransacaoResponse {	

	private BigDecimal valor;

	private EstabelecimentoResponse estabelecimento;

	private CartaoResponse cartao;

	private LocalDateTime efetivadaEm;
	
	public EventoTransacaoResponse(Transacao transacao) {
		this.valor = transacao.getValor();
		this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
		this.cartao = new CartaoResponse(transacao.getCartao());
		this.efetivadaEm = transacao.getEfetivadaEm();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
}
