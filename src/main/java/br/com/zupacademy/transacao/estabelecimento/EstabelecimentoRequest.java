package br.com.zupacademy.transacao.estabelecimento;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstabelecimentoRequest {

	@NotBlank
	@JsonProperty
	private String nome;
	@NotBlank
	@JsonProperty
	private String cidade;
	@NotBlank
	@JsonProperty
	private String endereco;
	
	@Deprecated
	public EstabelecimentoRequest() {
		
	}
	
	public EstabelecimentoRequest(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}
	
	public Estabelecimento toModel() {
		return new Estabelecimento(nome, cidade, endereco);
	}
	
}
