package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.CarroAtualizarDTO;
import br.com.masterclass.superpecas.dto.CarroCriarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.masterclass.superpecas.service.CarrosService;

@RestController
@RequestMapping("/carro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarrosController {

    @Autowired
    CarrosService service;

    @PostMapping
    public ResponseEntity<String> criarNovoCarro(@RequestBody CarroCriarDTO carroDTO){
        this.service.criarNovoCarro(carroDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Carro gravado com sucesso!");
    }

    @PutMapping
    public ResponseEntity<String> atualizarCarro(@RequestBody CarroAtualizarDTO carroDTO){
        this.service.atualizarCarro(carroDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Carro Atualizado com Sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCarro(@PathVariable int id){
        this.service.excluirCarro(id);
        return ResponseEntity.status(HttpStatus.OK).body("Carro Excluído com Sucesso! ");
    }

}
