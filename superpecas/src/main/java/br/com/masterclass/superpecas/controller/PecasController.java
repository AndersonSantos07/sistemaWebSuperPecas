package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.PecaAtualizarDTO;
import br.com.masterclass.superpecas.dto.PecaCriarDTO;
import br.com.masterclass.superpecas.model.PecasModel;
import br.com.masterclass.superpecas.service.PecasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/peca")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Api parte de Peças", description = "Api de Peças")
public class PecasController {

    @Autowired
    private PecasService service;

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um objeto json.", description = "Retorna um objeto json, dependendo do ID que é enviado.")
    public ResponseEntity<PecasModel> getPorId(@PathVariable int id){

        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @GetMapping("/listaTodosPaginado")
    @Operation(summary = "Retorna uma lista json de objetos paginados.", description = "Retorna uma lista de objetos paginados, cada página contém dez itens.")
    public ResponseEntity<Page<PecasModel>> listarTodosPaginado(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size){

        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosPaginado(page, size));
    }

    @GetMapping("listaTodosPaginado/{termo}")
    @Operation(summary = "Retorna uma lista json de objetos paginados.", description = "Retorna uma lista json de objetos paginados dependendo do termo que é enviado como filtro, cada página contém dez itens.")
    public ResponseEntity<Page<PecasModel>> listarTodosPaginadoPorTermo(@RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "10") int size,
                                                                        @PathVariable String termo){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosPaginadoPorTermo(page,size,termo));
    }


    @PostMapping
    @Operation(summary = "Criar peça.", description = "Método para criar a peça.")
    public ResponseEntity<String> criarPeca(@RequestBody PecaCriarDTO pecaDTO){
        this.service.criarPeca(pecaDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Peça gravada com sucesso! ");
    }

    @PutMapping
    @Operation(summary = "Atualizar a peça", description = "Método para atualizar uma peça específica.")
    public ResponseEntity<String> atualizarPeca(@RequestBody PecaAtualizarDTO pecaDTO){
        service.atualizarPeca(pecaDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Peça atualizada com sucesso! ");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir Peça", description = "Método para excluir a peça, dependendo do ID que é passado.")
    public ResponseEntity<String> excluirPeca(@PathVariable int id){
        service.excluirPeca(id);
        return ResponseEntity.status(HttpStatus.OK).body("Peça excluída com sucesso! ");
    }
}
