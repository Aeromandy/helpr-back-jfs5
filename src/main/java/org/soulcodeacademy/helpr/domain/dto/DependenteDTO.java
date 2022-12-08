package org.soulcodeacademy.helpr.domain.dto;


import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DependenteDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Column(nullable = false, length = 11)
    @CPF(message = "CPF é inválido")
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String escolaridade;


    @NotNull(message = "id funcionario obrigatorio")
    private Integer responsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Integer getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Integer responsavel) {
        this.responsavel = responsavel;
    }
}
