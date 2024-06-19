package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.*;
import br.com.masterclass.superpecas.model.CarrosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.masterclass.superpecas.service.CarrosService;

import java.util.List;

@RestController
@RequestMapping("/carro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarrosController {

    @Autowired
    CarrosService service;

    @GetMapping("/listaTop10Fabricantes")
    public ResponseEntity<List<FabricanteTotalCarrosDTO>> getTop10Fabricantes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTopFabricantes());
    }

    @GetMapping("/listaTop10CarroComMaisPecas")
    public ResponseEntity<List<CarrosPecasDTO>> getTop10CarrosComMaisPecas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTop10CarrosComMaisPecas());
    }

    @GetMapping("/listaTodos")
    public ResponseEntity<List<CarrosModel>> getListarTodos(){

        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @GetMapping("/listaTodosPaginado")
    public ResponseEntity<Page<CarrosModel>> getListarTodosPaginado(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosPaginados(page, size));
    }

    @GetMapping("listaTodosPaginado/{termo}")
    public ResponseEntity<Page<CarrosModel>> getListarTodosPaginadosPorTermo(@RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "10") int size,
                                                                          @PathVariable String termo){
        return ResponseEntity.status((HttpStatus.OK)).body(service.listarTodosPaginadosPorTermo(page,size, termo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrosModel> getPorId(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(service.procurarPorId(id));
    }

    @GetMapping("/listaTodosFabricantes")
    public ResponseEntity<List<FabricanteDTO>> getTodosFabricantes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosFabricantes());
    }

    @PostMapping
    public ResponseEntity<String> postNovoCarro(@RequestBody CarroCriarDTO carroDTO){
        this.service.criarNovoCarro(carroDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Carro gravado com sucesso!");
    }

    @PutMapping
    public ResponseEntity<String> putAtualizarCarro(@RequestBody CarroAtualizarDTO carroDTO){
        this.service.atualizarCarro(carroDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Carro Atualizado com Sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarro(@PathVariable int id){
        this.service.excluirCarro(id);
        return ResponseEntity.status(HttpStatus.OK).body("Carro Excluído com Sucesso! ");
    }

}
