package br.com.jackson.backend.service;

import br.com.jackson.backend.dto.PessoaClienteRequestDTO;
import br.com.jackson.backend.models.Pessoa;
import br.com.jackson.backend.repository.PessoaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;

    public Pessoa registar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa newPessoa = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(newPessoa);
        emailService.EnviarEmailTexto(newPessoa.getEmail(), "Cadastra da Loja Jackss", "O registro na loja foi realizado com sucesso. Em breve você receberá a senha de acesso por e-mail.");
        return newPessoa;
    }
}
