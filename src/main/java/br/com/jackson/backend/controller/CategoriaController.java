package br.com.jackson.backend.controller;

import br.com.jackson.backend.models.Categoria;
import br.com.jackson.backend.service.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService  categoriaService;

    @GetMapping
    public List<Categoria> listarTodos() {
        return categoriaService.listarTodos();
    }

    @PostMapping
    public Categoria inserir(@RequestBody Categoria  categoria) {

        categoria.setDataCriacao(new Date());
        return categoriaService.inserir(categoria);
    }

    @PutMapping
    public Categoria atulizar(@RequestBody Categoria categoria) {

        categoria.setDataAtualizacao(new Date());
        return  categoriaService.alterar(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        categoriaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
