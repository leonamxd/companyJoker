package br.ucsal.loja.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.loja.exception.BusinessException;
import br.ucsal.loja.service.ProdutoService;
import br.ucsal.loja.to.CadastraProdutoRequest;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	private final String MSG_SERVER_ERRO = "Falha no servidor, tente novamente mais tarde!";
	
	@GetMapping(value = "/obter/todos", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> obterTodosProdutos(){ 
		ResponseEntity<Object> response;
		try {
			response = ResponseEntity.ok(produtoService.obterTodosProdutos());
		} catch (BusinessException e) {
			response = new ResponseEntity<Object>(e.getMessage(), e.getStatus());
		} catch (RuntimeException e) {
			response = new ResponseEntity<Object>(MSG_SERVER_ERRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@GetMapping(value = "/obter/{id}", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> obterProdutoPeloId(@PathVariable BigInteger id){
		ResponseEntity<Object> response;
		try {
			response = ResponseEntity.ok(produtoService.obterProdutoPeloId(id));
		} catch (BusinessException e) {
			response = new ResponseEntity<Object>(e.getMessage(), e.getStatus());
		} catch (RuntimeException e) {
			e.printStackTrace();
			response = new ResponseEntity<Object>(MSG_SERVER_ERRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@PostMapping(value = "/cadastrar",
				 produces = MediaType.APPLICATION_JSON_VALUE,
				 consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> cadastrarProduto(@RequestBody CadastraProdutoRequest request){
		ResponseEntity<Object> response;
		try {
			produtoService.cadastrarProduto(request);
			response = ResponseEntity.ok("Produto cadastrado com sucesso!");
		} catch (BusinessException e) {
			response = new ResponseEntity<Object>(e.getMessage(), e.getStatus());
		} catch (RuntimeException e) {
			response = new ResponseEntity<Object>(MSG_SERVER_ERRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
}
