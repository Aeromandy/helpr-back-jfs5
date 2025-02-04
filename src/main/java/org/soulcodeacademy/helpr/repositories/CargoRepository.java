package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> { // <Entidade, PK>
    List<Cargo> findByNome(String valor); // WHERE nome = valor
    List<Cargo> findBySalario(Double valor); // WHERE salario = valor
    List<Cargo> findBySalarioGreaterThan(Double valor); // WHERE salario > valor
    List<Cargo> findBySalarioGreaterThanEqual(Double valor); // WHERE salario >= valor
    List<Cargo> findBySalarioLessThan(Double valor); // WHERE salario < valor
    List<Cargo> findBySalarioLessThanEqual(Double valor); // WHERE salario <= valor
    List<Cargo> findBySalarioBetween(Double valor1, Double valor2); // WHERE salario BETWEEN valor1 AND valor2
}

