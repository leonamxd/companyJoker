package br.ucsal.loja.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO")
public class Estado {
	
	@Id
	@Column(name = "COD_ESTADO")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private BigInteger id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "SIGLA")
	private String sigla;
	
	public BigInteger getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
