package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.DependenteDTO;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.services.DependenteService;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class DependenteController {

    @Autowired
    public DependenteService dependenteService;

    @Autowired
    public FuncionarioService funcionarioService;

    @GetMapping("/dependentes")
    public List<Dependente> listar() {  return this.dependenteService.listar(); }

    @GetMapping("/dependentes/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente) {
        return this.dependenteService.getDependente(idDependente);
    }

    @GetMapping("/dependente/cpf")
    public List<Dependente> listarPorCpf(@RequestParam String cpf) {
            return this.dependenteService.listarPorCpf(cpf);
    }


    @GetMapping("/dependentes/funcionarios/{idFuncionario}")
    public List<Dependente> findByDependentesPorFuncionario(@PathVariable Integer idFuncionario) {
         return this.dependenteService.findDependentesByIdFuncionario(idFuncionario);
    }


    @GetMapping("/dependente/listarDatas")
    private List<Dependente> buscarEntreDatas(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate data1, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data2) {
        return this.dependenteService.buscarEntreDatas(data1, data2);
    }


    @PostMapping("/dependentes")
    public Dependente salvar(@Valid @RequestBody DependenteDTO dependente) {
        Dependente salvo = this.dependenteService.salvar(dependente);
        return salvo;
    }

    @PutMapping("/dependentes/{idDependente}")
    public Dependente atualizar(@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dependente) {
        Dependente atualizado = this.dependenteService.atualizar(idDependente, dependente);
        return atualizado;
    }

    @DeleteMapping("/dependentes/{idDependente}")
    public void deletar(@PathVariable Integer idDependente) {
        this.dependenteService.deletar(idDependente);
    }
}
