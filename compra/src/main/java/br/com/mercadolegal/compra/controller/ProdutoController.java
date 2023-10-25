package br.com.mercadolegal.compra.controller;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolegal.compra.entidade.Produto;
import br.com.mercadolegal.compra.pojo.ProdutoPojo;
import br.com.mercadolegal.compra.repository.ProdutoRepository;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoRepository produtoRepository;
	
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	//Cria um novo produto no banco de dados (Metodo POST)
	@PostMapping
	public ProdutoPojo create(@RequestBody ProdutoPojo produtoPojo) {
		return new ProdutoPojo(produtoRepository.save(produtoPojo.toEntity()));
	}

	//Retorna TODOS os registros (Metodo GET)
	@GetMapping	
	public List<ProdutoPojo> getAll() {
		List<Produto> listProduto = produtoRepository.findAll();
		List<ProdutoPojo> listProdutoPojo = new ArrayList<>();
		for (Produto produto: listProduto) {
			listProdutoPojo.add(new ProdutoPojo(produto));
		}
		return listProdutoPojo;
	}
	
	//Retorna através do ID (Metodo GET)
	@GetMapping(path = "/{idProduto}")
	public ProdutoPojo get(@PathVariable Long idProduto) {
		Optional<Produto> produtoOptional = produtoRepository.findById(idProduto);
		if(produtoOptional.isPresent()) {
			return new ProdutoPojo(produtoOptional.get());
		}
		return new ProdutoPojo();
	}
	
	//Atualiza o registro pelo id (Meotodo PUT)
	@PutMapping
	public ProdutoPojo update(@RequestBody ProdutoPojo produtoPojo) {
		return new ProdutoPojo(produtoRepository.save(produtoPojo.toEntity()));
	}
	
	//Deleta o registro pelo id (Metodo DELETE)
	@DeleteMapping(path = "/{idProduto}")
	public void delete(@PathVariable Long idProduto) {
		produtoRepository.deleteById(idProduto);
	}
	
}
