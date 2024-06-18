package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.CarroAtualizarDTO;
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
    public ResponseEntity<String> criarNovoCarro(@RequestBody CarroAtualizarDTO carroDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.atualizarCarro(carroDTO));
    }

    @PutMapping
    public ResponseEntity<String> atualizarCarro(@RequestBody CarroAtualizarDTO carroDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarCarro(carroDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCarro(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(service.excluirCarro(id));
    }

}
