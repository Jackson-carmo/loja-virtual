package br.com.jackson.backend.repository;

import br.com.jackson.backend.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
