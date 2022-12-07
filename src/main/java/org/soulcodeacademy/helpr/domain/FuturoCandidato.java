package org.soulcodeacademy.helpr.domain;
import org.soulcodeacademy.helpr.domain.enums.Setor;
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


    @Enumerated(EnumType.STRING)
    private Setor setor = Setor.Manutenção;


    public FuturoCandidato() {}

    public FuturoCandidato(Integer idFtcandidato, String nome, String email, String descricao, Setor setor) {
        this.idFtcandidato = idFtcandidato;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.setor= setor;

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

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
