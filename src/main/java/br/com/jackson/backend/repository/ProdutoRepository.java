package br.com.jackson.backend.repository;

import br.com.jackson.backend.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
