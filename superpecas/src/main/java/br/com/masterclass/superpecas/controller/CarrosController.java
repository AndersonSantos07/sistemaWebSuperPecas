package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.*;
import br.com.masterclass.superpecas.model.CarrosModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Api parte de Carros", description = "Api Carros" )
public class CarrosController {

    @Autowired
    CarrosService service;

    @GetMapping("/listaTop10Fabricantes")
    @Operation(summary = "Retorna uma lista json.", description = "Retorna uma lista json com top dez Fabricantes com mais carros.")
    public ResponseEntity<List<FabricanteTotalCarrosDTO>> getTop10Fabricantes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTopFabricantes());
    }

    @GetMapping("/listaTop10CarroComMaisPecas")
    @Operation(summary = "Retorna uma lista json.", description = "Retorna uma lista json com top dez Carros com mais peças.")
    public ResponseEntity<List<CarrosPecasDTO>> getTop10CarrosComMaisPecas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTop10CarrosComMaisPecas());
    }

    @GetMapping("/listaTodos")
    @Operation(summary = "Retorna uma lista json.", description = "Retorna uma lista json de todos os carros.")
    public ResponseEntity<List<CarrosModel>> getListarTodos(){

        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @GetMapping("/listaTodosPaginado")
    @Operation(summary = "Retorna uma lista json.", description = "Retorna uma lista json de Carros paginado, cada página contém dez Carros.")
    public ResponseEntity<Page<CarrosModel>> getListarTodosPaginado(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosPaginados(page, size));
    }

    @GetMapping("listaTodosPaginado/{termo}")
    @Operation(summary = "Retorna uma lista json.", description = "Retorna uma lista json paginado dependendo do termo(filtro) enviado pelo usuário, cada página contém dez Carros.")
    public ResponseEntity<Page<CarrosModel>> getListarTodosPaginadosPorTermo(@RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "10") int size,
                                                                          @PathVariable String termo){
        return ResponseEntity.status((HttpStatus.OK)).body(service.listarTodosPaginadosPorTermo(page,size, termo));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um item em json.", description = "Retorna um item Carro em json dependendo do id passado pelo usuário.")
    public ResponseEntity<CarrosModel> getPorId(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(service.procurarPorId(id));
    }

    @GetMapping("/listaTodosFabricantes")
    @Operation(summary = "Retorna uma lista json.", description = "Retorna uma lista json com todos os fabricantes.")
    public ResponseEntity<List<FabricanteDTO>> getTodosFabricantes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosFabricantes());
    }

    @PostMapping
    @Operation(summary = "Criar novo carro.", description = "Método para criar um novo Carro.")
    public ResponseEntity<String> postNovoCarro(@RequestBody CarroCriarDTO carroDTO){
        this.service.criarNovoCarro(carroDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Carro gravado com sucesso!");
    }

    @PutMapping
    @Operation(summary = "Atualizar o Carro.", description = "Método para atualizar um carro especifíco.")
    public ResponseEntity<String> putAtualizarCarro(@RequestBody CarroAtualizarDTO carroDTO){
        this.service.atualizarCarro(carroDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Carro Atualizado com Sucesso!");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um carro pelo identificador.", description = "Método para deletar o carro por id.")
    public ResponseEntity<String> deleteCarro(@PathVariable int id){
        this.service.excluirCarro(id);
        return ResponseEntity.status(HttpStatus.OK).body("Carro Excluído com Sucesso! ");
    }

}
