package br.com.mercadolegal.compra.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.mercadolegal.compra.entidade.Produto;

public class ProdutoPojo {
	
	private Long idProduto;
	private String nomeProduto;
	private String categoriaProduto;
	private Double valorProduto;
	
	public ProdutoPojo() {}
	
	public ProdutoPojo(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nomeProduto = produto.getNomeProduto();
		this.categoriaProduto = produto.getCategoriaProduto();
		this.valorProduto = produto.getValorProduto();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	@JsonIgnore
	public Produto toEntity() {
		Produto produto = new Produto();
		produto.setIdProduto(idProduto);
		produto.setNomeProduto(nomeProduto);
		produto.setCategoriaProduto(categoriaProduto);
		produto.setValorProduto(valorProduto);
		return produto;
	}
	
}
