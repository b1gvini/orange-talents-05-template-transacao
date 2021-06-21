package br.com.zupacademy.transacao.cartao;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartaoRequest {

	@NotBlank
	@JsonProperty
	private String id;
	@NotBlank
	@JsonProperty
	private String email;
	
	@Deprecated
	public CartaoRequest() {
		
	}

	public CartaoRequest(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public Cartao toModel() {
		return new Cartao(id, email);
	}

}
