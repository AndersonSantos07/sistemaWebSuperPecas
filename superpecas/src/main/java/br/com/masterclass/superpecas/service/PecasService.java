package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.PecaAtualizarDTO;
import br.com.masterclass.superpecas.dto.PecaCriarDTO;
import br.com.masterclass.superpecas.exceptions.AtributosNulosException;
import br.com.masterclass.superpecas.exceptions.EntidadeEncontradaBaseDadosException;
import br.com.masterclass.superpecas.exceptions.EntidadeNaoEncontradaBaseDadosException;
import br.com.masterclass.superpecas.model.PecasModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.masterclass.superpecas.repository.PecasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PecasService {

    @Autowired
    private PecasRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public void criarPeca(PecaCriarDTO pecaDTO) {

        this.validarAtributosPecaCriar(pecaDTO);
        this.verificarNomeOuNumeroSerie(pecaDTO.getNome(), pecaDTO.getNumSerie());

        PecasModel peca = modelMapper.map(pecaDTO, PecasModel.class);

        repository.save(peca);

    }

    public void atualizarPeca(PecaAtualizarDTO pecaDTO) {

        this.validarAtributosPecaAtualizar(pecaDTO);

        this.verificarPecaExisteBancoDados(pecaDTO.getId());

        this.verificarNomeOuNumeroSerie(pecaDTO.getNome(), pecaDTO.getNumSerie());

        repository.save(this.criarModeloPeca(pecaDTO));
    }

    public void excluirPeca(int id) {

        this.verificarPecaExisteBancoDados(id);

        repository.deleteById(id);
    }

    public void verificarNomeOuNumeroSerie(String nome, String numSerie){

       List<PecasModel> pecas = this.repository.findByNomeOrNumeroSerie(nome,numSerie);

        if(!pecas.isEmpty()){
            throw new EntidadeEncontradaBaseDadosException("Peça já existe na base de dados! ");
        }
    }

    public void verificarPecaExisteBancoDados(int id){
        Optional<PecasModel> pecaBaseDados = this.repository.findById(id);

        if(pecaBaseDados.isEmpty()){
            throw new EntidadeNaoEncontradaBaseDadosException("Peça não encontrada na base de dados! ");
        }
    }

    public <P> PecasModel criarModeloPeca(P pecaDTO){

        PecasModel peca = modelMapper.map(pecaDTO, PecasModel.class);

        return peca;
    }

    public void validarAtributosPecaAtualizar(PecaAtualizarDTO pecaDTO){

        if(pecaDTO == null){
            throw new AtributosNulosException();
        }

        if(pecaDTO.getNome() == null || pecaDTO.getDesc() == null || pecaDTO.getId() == 0
                || pecaDTO.getNumSerie() == null || pecaDTO.getFabricante() == null
                || pecaDTO.getModeloCarro() == null || pecaDTO.getCarroID() == 0){

            throw new AtributosNulosException();

        }

    }

    public void validarAtributosPecaCriar(PecaCriarDTO pecaDTO){
        if(pecaDTO == null){
            throw new AtributosNulosException();
        }

        if(pecaDTO.getNome() == null || pecaDTO.getDesc() == null || pecaDTO.getNumSerie() == null
                || pecaDTO.getFabricante() == null
                || pecaDTO.getModeloCarro() == null || pecaDTO.getCarroId() == 0){
            throw new AtributosNulosException();
        }


    }
}
