package br.com.jackson.backend.service;

import br.com.jackson.backend.models.Produto;
import br.com.jackson.backend.models.ProdutoImagens;
import br.com.jackson.backend.repository.ProdutoImagensRepository;
import br.com.jackson.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos() {
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens produtoImagens = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagens = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("c:/imagens/" + nomeImagens);
                Files.write(caminho,bytes);
                produtoImagens.setImagem(nomeImagens);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        produtoImagens.setProduto(produto);
        produtoImagens.setDataCriacao(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }

    public ProdutoImagens atualizar(ProdutoImagens produtoImagens) {
        produtoImagens.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }

    public void excluir(Long id ) {
        ProdutoImagens produtoImagens = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(produtoImagens);
    }
}
