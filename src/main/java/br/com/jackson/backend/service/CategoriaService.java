package br.com.jackson.backend.service;

import br.com.jackson.backend.models.Categoria;
import br.com.jackson.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria) {
        return categoriaRepository.saveAndFlush(categoria);
    }

    public Categoria alterar(Categoria categoria) {
        return categoriaRepository.saveAndFlush(categoria);
    }

    public void excluir(Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }
}
