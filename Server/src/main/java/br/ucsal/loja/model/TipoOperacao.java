package br.ucsal.loja.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_OPERACAO")
public class TipoOperacao {
	
	@Id
	@Column(name = "COD_OPERACAO")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private BigInteger id;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	public BigInteger getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
