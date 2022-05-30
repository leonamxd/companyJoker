package br.ucsal.loja.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO_CLIENTE")
public class EnderecoCliente {
	
	@Id
	@Column(name = "COD_ENDERECO")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private BigInteger id;
	
	@Column(name = "COD_CLIENTE")
	private BigInteger idCliente;
	
	@Column(name = "COD_ESTADO")
	private BigInteger idEstado;
	
	@Column(name = "NOME_RUA")
	private String nomeRua;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "NUMERO")
	private Integer numero;
	
	@Column(name = "CEP")
	private String cep;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;

	public BigInteger getId() {
		return id;
	}

	public BigInteger getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(BigInteger idCliente) {
		this.idCliente = idCliente;
	}

	public BigInteger getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(BigInteger idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
