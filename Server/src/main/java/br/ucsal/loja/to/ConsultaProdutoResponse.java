package br.ucsal.loja.to;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class ConsultaProdutoResponse {
	
	private String nome;
	
	private BigDecimal preco;
	
	private String descricao;
	
	private Timestamp cadastro;
	
	private BigInteger estoque;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getCadastro() {
		return cadastro;
	}

	public void setCadastro(Timestamp cadastro) {
		this.cadastro = cadastro;
	}

	public BigInteger getEstoque() {
		return estoque;
	}

	public void setEstoque(BigInteger estoque) {
		this.estoque = estoque;
	}

}
