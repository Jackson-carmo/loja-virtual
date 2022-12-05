package br.com.jackson.backend.controller;

import br.com.jackson.backend.models.Pessoa;
import br.com.jackson.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> buscarTodos() {
        return pessoaService.buscarTodos();
    }

    @PostMapping
    public Pessoa inserir(@RequestBody Pessoa pessoa) {
        return pessoaService.inserir(pessoa);
    }

    @PutMapping
    public  Pessoa atualizar(@RequestBody Pessoa  pessoa) {
        return pessoaService.atualizar(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
