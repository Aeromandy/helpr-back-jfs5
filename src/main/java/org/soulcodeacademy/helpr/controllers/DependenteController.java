package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;


    // Listar todos os dependentes: /
    @GetMapping("/dependentes")
    public List<Dependente> listar() {
        return this.dependenteService.listar();
    }

    // Listar um dependente: /dependentes/{idDependente} (GET);
    @GetMapping("/dependente/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente) {
        return this.dependenteService.getDependente(idDependente);
    }


    // Filtrar por cpf: /dependentes/cpf/{cpf} (GET);
    @GetMapping("/dependente/cpf/{cpf}")
    public Dependente getDependente(@RequestParam String cpf) {
        return this.dependenteService.findbycpf(cpf);
    }


    // Filtrar por faixa de datas: /dependentes/faixa/{data1}/{data2} (GET);

    @GetMapping("/dependente/faixa/{data1}{data2}")
    public List<Dependente> ListarPordata(@RequestParam Date date1, @RequestParam Date date2) {
        return this.dependenteService.ListarPordata(date1, date2);
    }


    // Salvar dependente (deve ser menor de idade, checar isso): /dependentes (POST);
    @PostMapping("/dependentes")
    public Dependente salvar(@Valid @RequestBody DependenteDTO dto) {
        Dependente dependente = this.dependenteService.salvar(dto);
        return dependente;
    }



    // Atualizar dependente (não permitir mudar de responsável) /dependentes (PUT);
    @PutMapping("/dependentes/{idDependente}")
    public Dependente atualizar(@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dto) {
        Dependente dependente = this.dependenteService.atualizar(idDependente, dto);
        return dependente;
    }


    //  Deletar dependente: /dependentes (DELETE);
    @DeleteMapping("/dependentes/{idDependente}")
    public void deletar(@PathVariable Integer idDependente) {
        this.dependenteService.deletar(idDependente);
    }


    // Listar os dependentes de um funcionário por id: /dependentes/funcionarios/{idFuncionario}.

    @GetMapping("/dependentes/funcionarios/{idFuncionario}")
    public List<Dependente> listarDependentesFun(@PathVariable Integer idFuncionario) {
        return this.dependenteService.listarDependentesFun();
    }
}
