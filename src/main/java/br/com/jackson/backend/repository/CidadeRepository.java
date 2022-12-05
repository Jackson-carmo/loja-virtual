package br.com.jackson.backend.repository;

import br.com.jackson.backend.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
