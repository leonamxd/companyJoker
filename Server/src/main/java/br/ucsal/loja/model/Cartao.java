package br.ucsal.loja.model;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARTAO")
public class Cartao {
	
	@Id
	@Column(name = "COD_CARTAO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Column(name = "COD_CLIENTE")
	private BigInteger idCliente;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CODIGO_SEG")
	private String codigoSeguranca;
	
	@Column(name = "VALIDADE")
	private Timestamp validade;
	
	@Column(name = "COD_OPERACAO")
	private Integer codigoOperacao;

	public BigInteger getId() {
		return id;
	}

	public BigInteger getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(BigInteger idCliente) {
		this.idCliente = idCliente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public Timestamp getValidade() {
		return validade;
	}

	public void setValidade(Timestamp validade) {
		this.validade = validade;
	}

	public Integer getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(Integer codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}
	
}
