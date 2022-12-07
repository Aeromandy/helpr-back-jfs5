package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email); // WHERE email = email
    Optional<Usuario> findByCpf(String cpf); // WHERE cpf = cpf
    List<Usuario> findByNome(String nome); // WHERE nome = nome
    List<Usuario> findByNomeContaining(String busca); // Filtrar pelo nome
}

