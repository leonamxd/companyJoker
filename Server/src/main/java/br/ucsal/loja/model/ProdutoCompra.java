package br.ucsal.loja.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO_COMPRA")
public class ProdutoCompra {
	
	@Id
	@Column(name = "COD_PRODUTO_COMPRA")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private BigInteger id;
	
	@Column(name = "COD_PRODUTO")
	private BigInteger idProduto;
	
	@Column(name = "COD_COMPRA")
	private BigInteger idCompra;
	
	@Column(name = "qt_produto")
	private Integer qtProduto;
	
	public BigInteger getId() {
		return id;
	}

	public BigInteger getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(BigInteger idProduto) {
		this.idProduto = idProduto;
	}

	public BigInteger getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(BigInteger idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getQtProduto() {
		return qtProduto;
	}

	public void setQtProduto(Integer qtProduto) {
		this.qtProduto = qtProduto;
	}

}
