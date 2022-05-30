package br.ucsal.loja.to;

import java.math.BigDecimal;
import java.util.List;

public class CadastraProdutoRequest {
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal preco;
	
	List<FornecedorTO> fornecedores;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public List<FornecedorTO> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorTO> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
