package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Integer> {
    List<Dependente>findByCpf(List<Dependente> cpf);
    List<Dependente>findByEscolaridade(String escolaridade);
    List<Dependente>findByFuncionario(Funcionario funcionario);
    List<Dependente> findByNome(String nome);

    @Query(value = "SELECT * FROM dependente WHERE data_nascimento BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Dependente> buscarEntreDatas(LocalDate data1, LocalDate data2);



}
