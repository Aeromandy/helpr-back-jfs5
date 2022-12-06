package org.soulcodeacademy.helpr.domain;

import javax.persistence.*;

@Entity
public class FuturoCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFtcandidato;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 250)
    private String descricao;

    private String setor;

    public FuturoCandidato() {}

    public FuturoCandidato(Integer idFtcandidato, String nome, String email, String descricao, String setor) {
        this.idFtcandidato = idFtcandidato;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.setor = setor;
    }

    public Integer getIdFtcandidato() {
        return idFtcandidato;
    }

    public void setIdFtcandidato(Integer idFtcandidato) {
        this.idFtcandidato = idFtcandidato;
    }

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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
