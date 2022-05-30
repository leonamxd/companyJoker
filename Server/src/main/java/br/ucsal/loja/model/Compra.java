package br.ucsal.loja.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPRA")
public class Compra {
	
	@Id
	@Column(name = "COD_COMPRA")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private BigInteger id;
	
	@Column(name = "COD_CLIENTE")
	private BigInteger idCliente;
	
	@Column(name = "DATA_COMPRA")
	private Timestamp dataCompra;
	
	@Column(name = "VALOR_COMPRA")
	private BigDecimal valorCompra;

	public BigInteger getId() {
		return id;
	}

	public BigInteger getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(BigInteger idCliente) {
		this.idCliente = idCliente;
	}

	public Timestamp getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Timestamp dataCompra) {
		this.dataCompra = dataCompra;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}
	
}
