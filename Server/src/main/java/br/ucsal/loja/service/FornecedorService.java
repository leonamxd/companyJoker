package br.ucsal.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.loja.exception.BusinessException;
import br.ucsal.loja.persistence.dao.FornecedorDAO;
import br.ucsal.loja.to.CadastraFornecedorRquest;
import br.ucsal.loja.to.FornecedorTO;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorDAO fornecedorDAO;
	
	public List<FornecedorTO> obterListaTodosFornecedores() throws BusinessException{
		return fornecedorDAO.obterFornecedores("");
	}
	
	public List<FornecedorTO> obterFornecedoresPeloNome(String nome) throws BusinessException{
		return fornecedorDAO.obterFornecedores(nome);
	}
	
	public void cadastrarFornecedor(CadastraFornecedorRquest request) throws BusinessException {
		fornecedorDAO.cadastrarFornecedor(request);
	}

}
