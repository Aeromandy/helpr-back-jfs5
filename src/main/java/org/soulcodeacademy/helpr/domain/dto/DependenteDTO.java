package org.soulcodeacademy.helpr.domain.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DependenteDTO {

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;

    @CPF(message = "Campo CPF inválido")
    private String cpf;

    @NotNull(message = "Campo data de nascimento é obrigatório")
    private LocalDate dataNascimento;

    @NotBlank(message = "Campo escolaridade é obrigatório.")
    private String escolaridade;

    @NotNull(message = "Campo idFuncionario é obrigatório")
    private Integer idFuncionario;

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

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
