package mz.cm.api.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mz.cm.api.produtos.model.ProdutoModel;
import mz.cm.api.produtos.service.ProdutoService;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody ProdutoModel pm){
		return produtoService.validacao(pm, "cadastrar");
		
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@RequestBody ProdutoModel pm){
		return produtoService.validacao(pm, "editar");
		
	}
	
	@GetMapping("/listar")
	public Iterable<ProdutoModel> listar(){
		return produtoService.listar();
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		return produtoService.remover(id);
		
	}
	
	@GetMapping("/")
	public String rota() {
		return "API funcionando";
	}

}
