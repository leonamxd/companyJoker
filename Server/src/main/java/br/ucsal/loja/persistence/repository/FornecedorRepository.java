package br.ucsal.loja.persistence.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.loja.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, BigInteger>{
	
}
