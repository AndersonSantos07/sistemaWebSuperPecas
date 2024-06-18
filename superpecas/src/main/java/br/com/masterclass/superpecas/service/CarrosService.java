package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.CarroAtualizarDTO;
import br.com.masterclass.superpecas.dto.CarroCriarDTO;
import br.com.masterclass.superpecas.exceptions.AtributosNulosException;
import br.com.masterclass.superpecas.exceptions.EntidadeNaoEncontradaBaseDadosException;
import br.com.masterclass.superpecas.exceptions.PecasAssociadasException;
import br.com.masterclass.superpecas.model.CarrosModel;
import br.com.masterclass.superpecas.model.PecasModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.masterclass.superpecas.repository.CarrosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarrosService {

    @Autowired
    private CarrosRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public void criarNovoCarro(CarroCriarDTO carroDTO) {

        this.validarCarroCriarDTO(carroDTO);
        this.validarModeloOuCodigoUnicoExisteBaseDados(carroDTO.getModelo(), carroDTO.getCodigoUnico());

        repository.save(this.criarModelCarro(carroDTO));
    }

    public void atualizarCarro(CarroAtualizarDTO carroDTO){

        this.validarCarroAtualizarDTO(carroDTO);
        this.validarModeloOuCodigoUnicoExisteBaseDados(carroDTO.getModelo(), carroDTO.getCodigoUnico());
        this.verificarCarroExisteBaseDados(carroDTO.getId());

        this.repository.save(this.criarModelCarro(carroDTO));
    }

    public void excluirCarro(int id) {

        this.verificarCarroExisteBaseDados(id);

        Optional<CarrosModel> carro = this.repository.findById(id);

        this.verificarPecasAssociadas(carro.get().getCarroID());

        this.repository.deleteById(id);
    }


    public void validarCarroCriarDTO(CarroCriarDTO carroDTO){

        if(carroDTO == null){
            throw new AtributosNulosException();
        }

        if(carroDTO.getFabricante() == null || carroDTO.getModelo() == null || carroDTO.getCodigoUnico() == null){
            throw new AtributosNulosException();
        }
    }

    public void validarCarroAtualizarDTO(CarroAtualizarDTO carroDTO){

        if(carroDTO == null){
            throw new AtributosNulosException();
        }

        if(carroDTO.getId() == 0 || carroDTO.getCodigoUnico() == null || carroDTO.getFabricante() == null || carroDTO.getModelo() == null){
            throw new AtributosNulosException();
        }
    }

    public void validarModeloOuCodigoUnicoExisteBaseDados(String modelo, String codigoUnico){

        List<CarrosModel> carroBaseDados = repository.findByNomeModeloOrCodigoUnico(modelo, codigoUnico);

        if(!carroBaseDados.isEmpty()) {
            throw new EntidadeNaoEncontradaBaseDadosException("Carro já existe na base de dados!");
        }
    }

    public void verificarCarroExisteBaseDados(int id){

        Optional<CarrosModel> carroBaseDados = this.repository.findById(id);

        if(carroBaseDados.isEmpty()){
            throw new EntidadeNaoEncontradaBaseDadosException("Carro não encontrado na base de dados! ");
        }

    }

    public void verificarPecasAssociadas(int id){

        List<PecasModel> pecasAssociadas = this.repository.pecasAssociadas(id);

        if(!pecasAssociadas.isEmpty()){
            throw new PecasAssociadasException();
        }
    }

    public <T> CarrosModel criarModelCarro(T carroDTO){
         CarrosModel carro = modelMapper.map(carroDTO, CarrosModel.class);
         return carro;
    }

}