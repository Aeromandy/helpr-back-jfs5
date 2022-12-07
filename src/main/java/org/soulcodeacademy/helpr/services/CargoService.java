package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;


    public List<Cargo> listar() {
        // Retorna os dados da tabela em forma de lista
        // SELECT * FROM cargo;
        return this.cargoRepository.findAll();
    }


    public Cargo getCargo(Integer idCargo) {


        Optional<Cargo> cargo = this.cargoRepository.findById(idCargo);

        if(cargo.isEmpty()) {

            throw new RecursoNaoEncontradoError("O cargo não foi encontrado!"); // Causa um erro com a mensagem
        } else {
            return cargo.get();
        }
    }

    public Cargo salvar(CargoDTO dto) {

        Cargo cargo = new Cargo(null, dto.getNome(), dto.getDescricao(), dto.getSalario());
        Cargo cargoSalvo = this.cargoRepository.save(cargo);
        return cargoSalvo;
    }


    public Cargo atualizar(Integer idCargo, CargoDTO dto) {

        Cargo cargoAtual = this.getCargo(idCargo);

        cargoAtual.setNome(dto.getNome());
        cargoAtual.setDescricao(dto.getDescricao());
        cargoAtual.setSalario(dto.getSalario());


        Cargo atualizado = this.cargoRepository.save(cargoAtual);
        return atualizado;
    }

    public void deletar(Integer idCargo) {
        Cargo cargo = this.getCargo(idCargo);
        // DELETE FROM cargo WHERE idCargo = ?
        this.cargoRepository.delete(cargo);
    }
}
