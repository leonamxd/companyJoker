package br.ucsal.loja.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO_FORNECEDOR")
public class ProdutoFornecedor {
	
	@Id
	@Column(name = "COD_PRODUTO_FORNECEDOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private BigInteger id;
	
	@Column(name = "COD_PRODUTO")
	private BigInteger idProduto;
	
	@Column(name = "COD_FORNECEDOR")
	private BigInteger idFornecedor;
	
	@Column(name = "ESTOQUE")
	private Integer estoque;
	
	public BigInteger getId() {
		return id;
	}

	public BigInteger getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(BigInteger idProduto) {
		this.idProduto = idProduto;
	}

	public BigInteger getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(BigInteger idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

}
