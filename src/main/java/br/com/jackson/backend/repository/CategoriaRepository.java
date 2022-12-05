package br.com.jackson.backend.repository;

import br.com.jackson.backend.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
