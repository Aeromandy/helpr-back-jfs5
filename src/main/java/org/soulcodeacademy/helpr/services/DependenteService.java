package org.soulcodeacademy.helpr.services;


import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.DependenteDTO;
import org.soulcodeacademy.helpr.repositories.DependenteRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private FuncionarioService funcionarioService;


    public List<Dependente> listar() { return this.dependenteRepository.findAll(); }

    public List<Dependente> listarPorCpf(String cpf) {

            return this.dependenteRepository.findByCpf(cpf);
        }

    public List<Dependente> buscarEntreDatas(LocalDate data1, LocalDate data2) {
        return this.dependenteRepository.buscarEntreDatas(data1, data2);
    }

    public List<Dependente> findDependentesByIdFuncionario(Integer idFuncionario) {
        return this.dependenteRepository.findDependentesByIdFuncionario(idFuncionario);
    }

    public Dependente getDependente(Integer idDependente) {
        Optional<Dependente> dependente = this.dependenteRepository.findById(idDependente);
        if(dependente.isEmpty()) {
            throw new RecursoNaoEncontradoError("O dependente não foi encontrado!");
        } else {
            return dependente.get();
        }
    }

    public Dependente salvar(DependenteDTO dto) {
        Funcionario funcionario = this.funcionarioService.getFuncionario(dto.getIdFuncionario());
        Dependente dependente = new Dependente(null, dto.getNome(), dto.getCpf(), dto.getDataNascimento(), dto.getEscolaridade(), funcionario);
        dependente.setFuncionario(funcionario);

        // Cria um Objeto LocalDate com a data atual.
        LocalDate hoje = LocalDate.now();

        // Cria um Objeto LocalDate com a data 01/01/2004.
        LocalDate dataNascimento = LocalDate.of(2004, Month.JANUARY, 01);

        long diferencaEmAnos = ChronoUnit.YEARS.between(hoje, dataNascimento);

        if (diferencaEmAnos > 18 ) {
            throw new RecursoNaoEncontradoError("Você não é mais dependente!");
        } else {
            Dependente dependenteSalvo = this.dependenteRepository.save(dependente);
            return dependenteSalvo;
        }
    }

    public Dependente atualizar(Integer idDependente, DependenteDTO dto) {
        Dependente dependenteAtual = getDependente(idDependente);
        Funcionario responsavel = this.funcionarioService.getFuncionario(dto.getIdFuncionario());
        dependenteAtual.setNome(dto.getNome());
        dependenteAtual.setCpf(dto.getCpf());
        dependenteAtual.setData_nascimento(dto.getDataNascimento());
        dependenteAtual.setEscolaridade(dto.getEscolaridade());


        return this.dependenteRepository.save(dependenteAtual);
    }

    public void deletar(Integer idDependente) {
        Dependente dependente = this.getDependente(idDependente);
        this.dependenteRepository.delete(dependente);
    }
}
