package br.com.jackson.backend.service;

import br.com.jackson.backend.models.Pessoa;
import br.com.jackson.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa) {
        pessoa.setDataCriacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public Pessoa atualizar(Pessoa  pessoa) {
        pessoa.setDataCriacao(new Date());
        Pessoa newPessoa = pessoaRepository.saveAndFlush(pessoa);
        return newPessoa;
    }

    public void excluir(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }
}
