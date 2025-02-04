package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class CargoController {

    @GetMapping("/oi")
    public String dizOla() {
        return "Olá, tudo bem?"; // resposta da requisição
    }

    @GetMapping("/batata")
    public Integer valor() {
        return 1000; // resposta da requisição
    }

    @Autowired
    private CargoService cargoService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_FUNCIONARIO')") // Admin e funcionario podem acessar
    @GetMapping("/cargos")
    public List<Cargo> listar() {

        return this.cargoService.listar();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_FUNCIONARIO')")
    @GetMapping("/cargos/{idCargo}")
    public Cargo getCargo(@PathVariable Integer idCargo) {

        return this.cargoService.getCargo(idCargo);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/cargos")
    public Cargo salvar(@Valid @RequestBody CargoDTO cargo) {
        Cargo salvo = this.cargoService.salvar(cargo);
        return salvo;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/cargos/{idCargo}") // /cargos/5
    public Cargo atualizar(@PathVariable Integer idCargo, @Valid @RequestBody CargoDTO cargo) {
       Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
       return atualizado;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/cargos/{idCargo}")
    public void deletar(@PathVariable Integer idCargo) {
        this.cargoService.deletar(idCargo);
    }
}
