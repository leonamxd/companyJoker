package br.ucsal.loja.to;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class FornecedorTO {
	
	@JsonInclude(Include.NON_NULL)
	private BigInteger idFornecedor;
	
	@JsonInclude(Include.NON_NULL)
	private Integer estoque;
	
	@JsonInclude(Include.NON_NULL)
	private List<ProdutoTO> produtos;
	
	private String nome;
	
	private String cnpj;
	
	private String email;
	
	private String telefone;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
