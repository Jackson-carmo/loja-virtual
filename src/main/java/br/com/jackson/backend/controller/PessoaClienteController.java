package br.com.jackson.backend.controller;

import br.com.jackson.backend.dto.PessoaClienteRequestDTO;
import br.com.jackson.backend.models.Pessoa;
import br.com.jackson.backend.service.PessoaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {

    @Autowired
    private PessoaClienteService pessoaClienteService;

    @PostMapping
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        return pessoaClienteService.registar(pessoaClienteRequestDTO);
    }
}
