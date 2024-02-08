package mz.cm.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mz.cm.api.produtos.model.ProdutoModel;
import mz.cm.api.produtos.model.RespostaModel;
import mz.cm.api.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private RespostaModel respostaModelo;
	
	//Metodo para listar os dados 
	public Iterable<ProdutoModel> listar(){
		return produtoRepository.findAll();
	}
	
	//Validacao dos dados
	
	public ResponseEntity<?> validacao(ProdutoModel  produtoModel, String accao){
		if(produtoModel.getNome().equals("")) {
			respostaModelo.setMensagem("Profavor, digite o nome do produto");
			
			return new ResponseEntity<RespostaModel>(respostaModelo, HttpStatus.BAD_REQUEST);
			
		}else if(produtoModel.getMarca().equals("")) {
			respostaModelo.setMensagem("Profavor, digite a marca do produto");
			
			return new ResponseEntity<RespostaModel>(respostaModelo, HttpStatus.BAD_REQUEST);
			
		}else {
			if(accao.equals("cadastrar")) {
				return new ResponseEntity<ProdutoModel>(produtoRepository.save(produtoModel), HttpStatus.CREATED);
				
			}else {
				return new ResponseEntity<ProdutoModel>(produtoRepository.save(produtoModel), HttpStatus.OK);
			}
			
		}
	}
	
	public ResponseEntity<RespostaModel> remover(Long id){
		
		produtoRepository.deleteById(id);
		
		respostaModelo.setMensagem("Produto removido com sucesso");
		return new ResponseEntity<RespostaModel>(respostaModelo, HttpStatus.OK);

	}

}
