package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class FuturoCandidatoController {

    @Autowired
    private FuturoCandidatoService futuroCandidatoService;

    //candidatos (GET): Listar

    @GetMapping("/candidatos")
    public List<FuturoCandidato> listar() {
        return this.futuroCandidatoService.listar();
    }

    //candidatos/{setor} (GET): Filtrar por setor, usar

    @GetMapping("/candidatos/{setor}")
    public List<FuturoCandidato> listarPorSetor(@RequestParam String setor) {
        return this.futuroCandidatoService.findBySetor(setor);
    }


    //candidatos/email (GET): Filtrar por email, usar RequestParam
    @GetMapping("/candidatos/{email}")
    public List<FuturoCandidato> findByEmail(@RequestParam String email) {
        return this.futuroCandidatoService.findByEmail(email);
    }


    //ccandidatos/nome (GET): Filtrar por nome, usar
    @GetMapping("/candidatos/{nome}")
    public List<FuturoCandidato> findByNome(@RequestParam String nome) {
        return this.futuroCandidatoService.findByNome(nome);
    }


    //candidatos (POST): Adicionar colaborador
    @PostMapping("/candidatos")
    public FuturoCandidato salvar(@Valid @RequestBody FuturoCandidatoDTO dto) {
        FuturoCandidato futuroCandidato = this.futuroCandidatoService.salvar(dto);
        return futuroCandidato;
    }


    //candidatos (DELETE): Deletar colaborador

    @DeleteMapping("/candidatos/{idFtcandidato}")
    public void deletar(@PathVariable Integer idFtcandidato) {
        this.futuroCandidatoService.deletar(idFtcandidato);
    }

}
