package org.soulcodeacademy.helpr.domain;

import javax.persistence.*;

@Entity
public class FuturoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idFtCliente;

    @Column(nullable = false, length = 150)
    protected String nome;

    @Column(nullable = false, unique = true, length = 120)
    protected String email;

    @Column(nullable = false, unique = true, length = 11)
    protected String cpf;

    public FuturoCliente() {}

    public FuturoCliente(Integer idFtCliente, String nome, String email, String cpf) {
        this.idFtCliente = idFtCliente;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Integer getIdFtCliente() {
        return idFtCliente;
    }

    public void setIdFtCliente(Integer idFtCliente) {
        this.idFtCliente = idFtCliente;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
