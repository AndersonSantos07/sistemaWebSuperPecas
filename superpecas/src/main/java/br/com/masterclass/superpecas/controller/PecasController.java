package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.PecaAtualizarDTO;
import br.com.masterclass.superpecas.dto.PecaCriarDTO;
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
        this.service.criarPeca(pecaDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Peça gravada com sucesso! ");
    }

    @PutMapping
    public ResponseEntity<String> atualizarPeca(@RequestBody PecaAtualizarDTO pecaDTO){
        service.atualizarPeca(pecaDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Peça atualizada com sucesso! ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPeca(@PathVariable int id){
        service.excluirPeca(id);
        return ResponseEntity.status(HttpStatus.OK).body("Peça excluída com sucesso! ");
    }
}
