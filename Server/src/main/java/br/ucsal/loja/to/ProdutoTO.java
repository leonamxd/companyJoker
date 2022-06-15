package br.ucsal.loja.to;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ProdutoTO {
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal preco;
	
	private Timestamp DataCadastro;

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

	public Timestamp getDataCadastro() {
		return DataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		DataCadastro = dataCadastro;
	}
	
}
