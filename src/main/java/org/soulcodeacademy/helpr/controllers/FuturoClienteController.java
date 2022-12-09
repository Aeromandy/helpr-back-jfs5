package org.soulcodeacademy.helpr.controllers;


import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.soulcodeacademy.helpr.domain.dto.FututoClienteDTO;
import org.soulcodeacademy.helpr.services.FuturoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class FuturoClienteController {

    @Autowired
    private FuturoClienteService futuroClienteService;

    @GetMapping("/futuros-clientes")
    public List<FuturoCliente> listarTodos() {
        return this.futuroClienteService.listarTodos();
    }

    @GetMapping("/futuros-clientes/email")
    public Optional<FuturoCliente> findByEmail(@RequestParam String email) {
        return this.futuroClienteService.findByEmail(email);
    }

    @GetMapping("/futuros-clientes/cpf")
    public Optional<FuturoCliente> findByCpf(@RequestParam String cpf) {
        return this.futuroClienteService.findByCpf(cpf);
    }

    @PostMapping("/futuros-clientes")
    public FuturoCliente salvar(@Valid @RequestBody FututoClienteDTO dto) {
        FuturoCliente futuroCliente = this.futuroClienteService.salvar(dto);
        return futuroCliente;
    }

    @DeleteMapping("/futuros-clientes/{idFtCliente}")
    public void deletar(@PathVariable Integer idFtCliente) {
        this.futuroClienteService.deletar(idFtCliente);
    }
}
