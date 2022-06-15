package br.ucsal.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.loja.exception.BusinessException;
import br.ucsal.loja.service.FornecedorService;
import br.ucsal.loja.to.CadastraFornecedorRquest;
import br.ucsal.loja.util.Constantes;

@RestController
@RequestMapping("/api/v1/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping(value = "/obter/todos", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> obterTodosFornecedores(){ 
		ResponseEntity<Object> response;
		try {
			response = ResponseEntity.ok(fornecedorService.obterListaTodosFornecedores());
		} catch (BusinessException e) {
			response = new ResponseEntity<Object>(e.getMessage(), e.getStatus());
		} catch (RuntimeException e) {
			e.printStackTrace();
			response = new ResponseEntity<Object>(Constantes.MSG_SERVER_ERRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@GetMapping(value = "/obter", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> obterFonecedoresPelonome(@RequestParam String nome){ 
		ResponseEntity<Object> response;
		try {
			response = ResponseEntity.ok(fornecedorService.obterFornecedoresPeloNome(nome));
		} catch (BusinessException e) {
			response = new ResponseEntity<Object>(e.getMessage(), e.getStatus());
		} catch (RuntimeException e) {
			response = new ResponseEntity<Object>(Constantes.MSG_SERVER_ERRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@PostMapping(value = "/cadastrar",
			 produces = MediaType.APPLICATION_JSON_VALUE,
			 consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> cadastrarProduto(@RequestBody CadastraFornecedorRquest request){
	ResponseEntity<Object> response;
		try {
			fornecedorService.cadastrarFornecedor(request);
			response = ResponseEntity.ok("Produto cadastrado com sucesso!");
		} catch (BusinessException e) {
			response = new ResponseEntity<Object>(e.getMessage(), e.getStatus());
		} catch (RuntimeException e) {
			e.printStackTrace();
			response = new ResponseEntity<Object>(Constantes.MSG_SERVER_ERRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
