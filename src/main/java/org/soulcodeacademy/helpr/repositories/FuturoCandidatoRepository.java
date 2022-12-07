package org.soulcodeacademy.helpr.repositories;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.Usuario;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface FuturoCandidatoRepository extends JpaRepository<FuturoCandidato, Integer> {

    Optional<FuturoCandidato>findByEmail(String email);

    Optional<FuturoCandidato>findByNome(String nome);

    //List<FuturoCandidato> findByNome(String busca); // Filtrar pelo nome

    List<FuturoCandidato>findBySetor(Setor setor);
}
