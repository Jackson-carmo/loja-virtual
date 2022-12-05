package br.com.jackson.backend.repository;

import br.com.jackson.backend.models.ProdutoImagens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long> {
}
