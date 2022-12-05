package br.com.jackson.backend.controller;

import br.com.jackson.backend.models.ProdutoImagens;
import br.com.jackson.backend.service.ProdutoImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/produtoImagens")
public class ProdutoImagensController {

    @Autowired
    private ProdutoImagensService  produtoImagensService;

    @GetMapping
    public List<ProdutoImagens> buscarTodos() {
        return produtoImagensService.buscarTodos();
    }

    @PostMapping
    public ProdutoImagens inserir(@RequestParam("idProduto") Long idProduto ,@RequestParam("file") MultipartFile file) {
        return produtoImagensService.inserir(idProduto, file);
    }

    @PutMapping
    public ProdutoImagens atualizar(ProdutoImagens produtoImagens) {
        return produtoImagensService.atualizar(produtoImagens);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        produtoImagensService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
