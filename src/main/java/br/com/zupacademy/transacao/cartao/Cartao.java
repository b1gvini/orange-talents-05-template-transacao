package br.com.zupacademy.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Cartao {

	@Id
	private String id;
	
	private String email;
	
	@Deprecated
	public Cartao() {
		
	}

	public Cartao(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
}
