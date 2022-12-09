package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.soulcodeacademy.helpr.domain.dto.FututoClienteDTO;
import org.soulcodeacademy.helpr.repositories.FuturoClienteRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuturoClienteService {

    @Autowired
    private FuturoClienteRepository futuroClienteRepository;

    public List<FuturoCliente>listarTodos() {
        return this.futuroClienteRepository.findAll();
    }

    public FuturoCliente getFuturoCliente(Integer idFtCliente) {
        Optional<FuturoCliente> futuroCliente = this.futuroClienteRepository.findById(idFtCliente);
        if(futuroCliente.isEmpty()) {
            throw new RecursoNaoEncontradoError("O cliente não foi encontrado");
        } else {
            return futuroCliente.get();
        }
    }

    public Optional<FuturoCliente> findByCpf(String cpf) {
        return this.futuroClienteRepository.findByCpf(cpf);
    }

    public Optional<FuturoCliente> findByEmail(String email) {
        return this.futuroClienteRepository.findByEmail(email);
    }

    public FuturoCliente salvar(FututoClienteDTO dto) {
        FuturoCliente futuroCliente = new FuturoCliente(null, dto.getNome(), dto.getEmail(), dto.getCpf());
        FuturoCliente salvo = this.futuroClienteRepository.save(futuroCliente);
        return salvo;
    }

    public void deletar(Integer idFtCliente) {
        FuturoCliente futuroCliente = this.getFuturoCliente(idFtCliente);
        this.futuroClienteRepository.delete(futuroCliente);
    }

}
