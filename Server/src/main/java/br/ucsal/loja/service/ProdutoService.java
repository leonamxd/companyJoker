package br.ucsal.loja.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ucsal.loja.exception.BusinessException;
import br.ucsal.loja.model.Fornecedor;
import br.ucsal.loja.model.Produto;
import br.ucsal.loja.persistence.dao.ProdutoDAO;
import br.ucsal.loja.persistence.repository.FornecedorRepository;
import br.ucsal.loja.persistence.repository.ProdutoRepository;
import br.ucsal.loja.to.CadastraProdutoRequest;
import br.ucsal.loja.to.ConsultaProdutoResponse;
import br.ucsal.loja.to.FornecedorTO;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	public List<ConsultaProdutoResponse> obterTodosProdutos() throws BusinessException {
		return produtoDAO.obterProdutoPeloId(null); 
	}
	
	public ConsultaProdutoResponse obterProdutoPeloId(BigInteger id) throws BusinessException {
		List<ConsultaProdutoResponse> resultados = produtoDAO.obterProdutoPeloId(id);
		return resultados.get(0);
	}
	
	private void verificarFornecedor(List<FornecedorTO> fornecedores) throws BusinessException {
		for(FornecedorTO fornecedor : fornecedores) {
			Optional<Fornecedor> optional = fornecedorRepository.findById(fornecedor.getIdFornecedor());
			if(optional.isEmpty()) {
				throw new BusinessException("Fornecedor informado não existe!", HttpStatus.BAD_REQUEST);
			}
		}
	}
	
	@Transactional
	public void cadastrarProduto(CadastraProdutoRequest request) throws BusinessException {
		verificarFornecedor(request.getFornecedores());
		BigInteger idProduto = produtoDAO.cadastrarProduto(request);
		for(FornecedorTO fornecedor : request.getFornecedores()) {
			produtoDAO.relacionarProdutoFornecedor(idProduto, fornecedor);
		}
	}

}
