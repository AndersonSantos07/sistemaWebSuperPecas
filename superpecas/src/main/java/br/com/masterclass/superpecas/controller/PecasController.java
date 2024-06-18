package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.PecaAtualizarDTO;
import br.com.masterclass.superpecas.dto.PecaCriarDTO;
import br.com.masterclass.superpecas.repository.PecasRepository;
import br.com.masterclass.superpecas.service.PecasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peca")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PecasController {

    @Autowired
    private PecasService service;

    @PostMapping
    public ResponseEntity<String> criarPeca(@RequestBody PecaCriarDTO pecaDTO){

        return ResponseEntity.status(HttpStatus.OK).body(service.criarPeca(pecaDTO));
    }

    @PutMapping
    public ResponseEntity<String> atualizarPeca(@RequestBody PecaAtualizarDTO pecaDTO){

        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarPeca(pecaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPeca(@PathVariable int id){

        return ResponseEntity.status(HttpStatus.OK).body(service.excluirPeca(id));

    }
}
