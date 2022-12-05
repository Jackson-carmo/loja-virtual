package br.com.jackson.backend.repository;

import br.com.jackson.backend.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {
}
