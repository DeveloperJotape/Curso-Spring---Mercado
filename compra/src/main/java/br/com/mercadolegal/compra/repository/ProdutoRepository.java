package br.com.mercadolegal.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadolegal.compra.entidade.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
