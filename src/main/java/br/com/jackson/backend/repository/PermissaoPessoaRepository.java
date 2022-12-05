package br.com.jackson.backend.repository;

import br.com.jackson.backend.models.PermissaoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoPessoaRepository extends JpaRepository<PermissaoPessoa, Long> {
}
