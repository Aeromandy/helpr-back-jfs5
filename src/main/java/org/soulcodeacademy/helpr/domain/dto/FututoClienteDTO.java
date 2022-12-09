package org.soulcodeacademy.helpr.domain.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FututoClienteDTO {

    @Column(nullable = false, length = 250)
    @NotNull(message = "Campo nome é obrigatório")
    private String nome;

    @NotNull(message = "Campo telefone é obrigatório")
    private String telefone;

    @Email
    @NotBlank(message = "Campo email é obrigatório")
    private String email;

    @CPF
    @NotBlank(message = "Campo CPF é obrigatório")
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
