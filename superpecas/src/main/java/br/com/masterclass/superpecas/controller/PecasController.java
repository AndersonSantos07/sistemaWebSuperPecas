package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.PecaAtualizarDTO;
import br.com.masterclass.superpecas.dto.PecaCriarDTO;
import br.com.masterclass.superpecas.model.PecasModel;
import br.com.masterclass.superpecas.service.PecasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/peca")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PecasController {

    @Autowired
    private PecasService service;

    @GetMapping("/{id}")
    public ResponseEntity<PecasModel> getPorId(@PathVariable int id){

        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @GetMapping("/listaTodosPaginado")
    public ResponseEntity<Page<PecasModel>> listarTodosPaginado(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size){

        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosPaginado(page, size));
    }

    @GetMapping("listaTodosPaginado/{termo}")
    public ResponseEntity<Page<PecasModel>> listarTodosPaginadoPorTermo(@RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "10") int size,
                                                                        @PathVariable String termo){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosPaginadoPorTermo(page,size,termo));
    }


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
