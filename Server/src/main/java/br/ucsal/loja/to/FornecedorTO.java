package br.ucsal.loja.to;

import java.math.BigInteger;

public class FornecedorTO {
	
	private BigInteger idFornecedor;
	
	private Integer estoque;

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
