package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.services.FuturoCandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class FuturoCandidatoController {

    @Autowired
    private FuturoCandidatoService futuroCandidatoService;

    //candidatos (GET): Listar

    @GetMapping("/candidatos")
    public List<FuturoCandidato> listar() {
        return this.futuroCandidatoService.listar();
    }



    @GetMapping("/candidatos/setor")
    public List<FuturoCandidato> listarPorSetor(@RequestParam Setor setor) {
        return this.futuroCandidatoService.findBySetor(setor);
    }



    @GetMapping("/candidatos/email")
    public Optional<FuturoCandidato> findByEmail(@RequestParam String email) {
        return this.futuroCandidatoService.findByEmail(email);
    }


    @GetMapping("/candidatos/nome")
    public Optional<FuturoCandidato> findByNome(@RequestParam String nome) {
        return this.futuroCandidatoService.findByNome(nome);
    }


    @PostMapping("/candidatos")
    public FuturoCandidato salvar(@Valid @RequestBody FuturoCandidatoDTO dto) {
        FuturoCandidato futuroCandidato = this.futuroCandidatoService.salvar(dto);
        return futuroCandidato;
    }



    @DeleteMapping("/candidatos/{idFtcandidato}")
    public void deletar(@PathVariable Integer idFtcandidato) {
        this.futuroCandidatoService.deletar(idFtcandidato);
    }

}
