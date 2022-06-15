package br.ucsal.loja.persistence.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.ucsal.loja.exception.BusinessException;
import br.ucsal.loja.to.CadastraProdutoRequest;
import br.ucsal.loja.to.ConsultaProdutoResponse;
import br.ucsal.loja.to.FornecedorTO;

@Component
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ConsultaProdutoResponse> obterProdutoPeloId(BigInteger idProduto) throws BusinessException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SUM(PR_FO.ESTOQUE) estoque, ");
		sql.append("nome, preco, descricao, DATA_CADASTRO cadastro, PR.COD_PRODUTO id ");
		sql.append("FROM PRODUTO_FORNECEDOR PR_FO ");
		sql.append("INNER JOIN PRODUTO PR ON PR.COD_PRODUTO = PR_FO.COD_PRODUTO ");
		sql.append("WHERE 1=1 ");
		if(Objects.nonNull(idProduto)) {
			sql.append("AND PR.COD_PRODUTO = ?1 ");
		}
		sql.append("GROUP BY PR.COD_PRODUTO");
		
		List<ConsultaProdutoResponse> retorno = null;
		
		if(Objects.isNull(idProduto)) {
			retorno = entityManager.createNativeQuery(sql.toString())
					   .unwrap(NativeQuery.class)
					   .setResultTransformer(Transformers.aliasToBean(ConsultaProdutoResponse.class))
					   .getResultList();
		} else {
			retorno = entityManager.createNativeQuery(sql.toString())
					   .setParameter(1, idProduto)
					   .unwrap(NativeQuery.class)
					   .setResultTransformer(Transformers.aliasToBean(ConsultaProdutoResponse.class))
					   .getResultList();
		}
		
		
		if(Objects.nonNull(retorno) && !retorno.isEmpty()) {
			return retorno;
		}
		
		throw new BusinessException("Produto não encontrado!", HttpStatus.NOT_FOUND);
		
	}
	
	@Transactional
	public BigInteger cadastrarProduto(CadastraProdutoRequest request) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, DATA_CADASTRO) ");
		sql.append("VALUES (?1, ?2, ?3, ?4)");
		
		entityManager.createNativeQuery(sql.toString())
					 .setParameter(1, request.getNome())
					 .setParameter(2, request.getDescricao())
					 .setParameter(3, request.getPreco())
					 .setParameter(4, new Date())
					 .executeUpdate();
		
		final String CURRVAL = "SELECT CURRVAL('produto_cod_produto_seq')";
		
		return (BigInteger) entityManager.createNativeQuery(CURRVAL).getSingleResult();
		
	}
	
	@Transactional
	public void relacionarProdutoFornecedor(BigInteger idProduto, FornecedorTO fornecedorTO) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO PRODUTO_FORNECEDOR (COD_PRODUTO, COD_FORNECEDOR, ESTOQUE) ");
		sql.append("VALUES (?1, ?2, ?3)");
		
		entityManager.createNativeQuery(sql.toString())
					 .setParameter(1, idProduto)
					 .setParameter(2, fornecedorTO.getIdFornecedor())
					 .setParameter(3, fornecedorTO.getEstoque())
					 .executeUpdate();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ConsultaProdutoResponse> obterProdutosVendidos() throws BusinessException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PR.COD_PRODUTO id, nome, preco, descricao, SUM(qt_produto) vendas FROM PRODUTO_COMPRA PR_CO ");
		sql.append("INNER JOIN PRODUTO PR ON PR.COD_PRODUTO = PR_CO.COD_PRODUTO ");
		sql.append("GROUP BY PR.COD_PRODUTO ");
		
		List<ConsultaProdutoResponse> retorno = entityManager.createNativeQuery(sql.toString())
															 .unwrap(NativeQuery.class)
															 .setResultTransformer(Transformers.aliasToBean(ConsultaProdutoResponse.class))
															 .getResultList();
		
		if(Objects.nonNull(retorno) && !retorno.isEmpty()) {
			return retorno;
		}
		
		throw new BusinessException("Nenhuma venda registrada!", HttpStatus.NOT_FOUND);
		
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ConsultaProdutoResponse> obterProdutosVendidosPeloCpfCnpjCliente(String cpfCnpj) throws BusinessException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PR.COD_PRODUTO id, PR.nome, preco, descricao, SUM(qt_produto) vendas FROM PRODUTO_COMPRA PR_CO ");
		sql.append("INNER JOIN PRODUTO PR ON PR.COD_PRODUTO = PR_CO.COD_PRODUTO ");
		sql.append("INNER JOIN COMPRA CO ON CO.COD_COMPRA = PR_CO.COD_COMPRA ");
		sql.append("INNER JOIN CLIENTE CL ON CL.COD_CLIENTE = CO.COD_CLIENTE ");
		sql.append("WHERE CPF_CNPJ = ?1 ");
		sql.append("GROUP BY PR.COD_PRODUTO ");
		
		List<ConsultaProdutoResponse> retorno = entityManager.createNativeQuery(sql.toString())
															 .setParameter(1, cpfCnpj)
															 .unwrap(NativeQuery.class)
															 .setResultTransformer(Transformers.aliasToBean(ConsultaProdutoResponse.class))
															 .getResultList();

		if(Objects.nonNull(retorno) && !retorno.isEmpty()) {
			return retorno;
		}

		throw new BusinessException("Nenhuma venda registrada para o CPF/CNPJ informado!", HttpStatus.NOT_FOUND);
	}
	
	

}
