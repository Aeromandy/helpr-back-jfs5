package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.repositories.FuturoCandidatoRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuturoCandidatoService {

    @Autowired
    private FuturoCandidatoRepository futuroCandidatoRepository;

    public List<FuturoCandidato>listar() {
        return this.futuroCandidatoRepository.findAll();
    }

    public List<FuturoCandidato>findBySetor( Setor setor) {
        return this.futuroCandidatoRepository.findBySetor(setor);
    }

    public List<FuturoCandidato>findByEmail(String email) {
        return this.futuroCandidatoRepository.findByEmail(email);
    }

    public List<FuturoCandidato>findByNome(String nome) {
        return this.futuroCandidatoRepository.findByNome(nome);
    }

    public FuturoCandidato getFuturoCandidato(Integer idFtcandidato) {
        Optional<FuturoCandidato> futuroCandidato = this.futuroCandidatoRepository.findById(idFtcandidato);
        if(futuroCandidato.isEmpty()) {
            throw new RecursoNaoEncontradoError("O candidato não foi encontrado!");
        } else {
            return futuroCandidato.get();
        }
    }

    public FuturoCandidato salvar(FuturoCandidatoDTO dto) {
        FuturoCandidato futuroCandidato = new FuturoCandidato(null, dto.getNome(), dto.getEmail(), dto.getDescricao(), dto.getSetor());
        FuturoCandidato salvo = this.futuroCandidatoRepository.save(futuroCandidato);
        return salvo;
    }

    public void deletar(Integer idFtcandidato) {
        FuturoCandidato futuroCandidato = this.getFuturoCandidato(idFtcandidato);
        this.futuroCandidatoRepository.delete(futuroCandidato);
    }



}
