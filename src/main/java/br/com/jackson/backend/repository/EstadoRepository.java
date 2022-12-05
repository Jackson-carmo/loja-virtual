package br.com.jackson.backend.repository;

import br.com.jackson.backend.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
