package br.com.jackson.backend.service;

import br.com.jackson.backend.models.Pessoa;
import br.com.jackson.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PessoaGerenciamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    public String solicitarCodigo(String email) {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());
        pessoaRepository.saveAndFlush(pessoa);
        emailService.EnviarEmailTexto(pessoa.getEmail(), "Código de recuperação de senha", "Ola, seu codigo para recuperação de senha "+ pessoa.getCodigoRecuperacaoSenha());

        return "Código enviado!";
    }

    public String altearSenha(Pessoa pessoa) {

        Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());
        if (pessoaBanco!=null) {
        Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());

        if (diferenca.getTime()/1000 < 900) {
                pessoaBanco.setSenha(pessoa.getSenha());
                pessoaBanco.setCodigoRecuperacaoSenha(null);
                pessoaRepository.saveAndFlush(pessoaBanco);
                return "Senha alterada com sucesso!";
        }else {
            return "Tempo expirado, solicite um novo código.";
        }
    }else {
            return "Email ou código invalido!";
        }
    }

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHssmm");
        return format.format(new Date())+id;
    }
}
