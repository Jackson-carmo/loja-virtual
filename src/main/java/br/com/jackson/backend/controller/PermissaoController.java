package br.com.jackson.backend.controller;

import br.com.jackson.backend.models.Permissao;
import br.com.jackson.backend.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    public List<Permissao> buscarTodos() {
        return permissaoService.buscarTodos();
    }

    @PostMapping
    public Permissao inserir(@RequestBody Permissao permissao) {
        return permissaoService.inserir(permissao);
    }

    @PutMapping
    public Permissao atualziar(@RequestBody Permissao permissao) {
        return permissaoService.atualizar(permissao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
