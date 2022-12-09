package org.soulcodeacademy.helpr.services;


import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.DependenteDTO;
import org.soulcodeacademy.helpr.repositories.DependenteRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
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

    public Dependente listarPorCpf(String cpf) {
        List<Dependente> dependente = this.dependenteRepository.findByCpf(cpf);
        if (cpf.isEmpty()) {
            throw new RecursoNaoEncontradoError("O CPF não foi encontrado!");
        } else {
            return listarPorCpf(cpf);
        }
    }

    public Dependente buscarEntreDatas(LocalDate data1, LocalDate data2) {
        List<Dependente> dependente = this.dependenteRepository.buscarEntreDatas(data1, data2);
        if (data1 == null) {
            throw new RecursoNaoEncontradoError("As primeira data não foram foi encontradas!");
        } else if (data2 == null){
            throw new RecursoNaoEncontradoError("As segunda data não foram foi encontradas!");
        }else {
            return buscarEntreDatas(data1, data2);
        }
    }

    public Dependente findByDependentesPorFuncionario(Integer idFuncionario) {
        List<Dependente> dependentes = this.dependenteRepository.findByDependentesPorFuncionario(getDependente(idFuncionario));

        return dependentes.get(idFuncionario);
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
        dependenteAtual.setDataNascimento(dto.getDataNascimento());
        dependenteAtual.setEscolaridade(dto.getEscolaridade());


        return this.dependenteRepository.save(dependenteAtual);
    }

    public void deletar(Integer idDependente) {
        Dependente dependente = this.getDependente(idDependente);
        this.dependenteRepository.delete(dependente);
    }
}
