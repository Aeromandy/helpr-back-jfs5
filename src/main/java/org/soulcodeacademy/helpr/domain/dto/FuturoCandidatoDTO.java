package org.soulcodeacademy.helpr.domain.dto;

import org.soulcodeacademy.helpr.domain.enums.Setor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
public class FuturoCandidatoDTO {

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;

    @NotNull(message = "Campo email é obrigatório.")
    @Email(message = "Email inválido")
    private String email;

    @Column(nullable = false, length = 250)
    @NotNull(message = "Campo descrição é obrigatório")
    private String descricao;

    @NotNull(message = "Campo setor é obrigatório")
    private Setor setor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
