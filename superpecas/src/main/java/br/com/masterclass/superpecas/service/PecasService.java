package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.PecaAtualizarDTO;
import br.com.masterclass.superpecas.dto.PecaCriarDTO;
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

    public String criarPeca(PecaCriarDTO pecaDTO) {

        List<PecasModel> pecaBaseDados = repository.findByNomeOrNumeroSerie(pecaDTO.getNome(), pecaDTO.getNumSerie());

        if(!pecaBaseDados.isEmpty()){
            return "Nome ou número de série já existe na base de dados! ";
        }

        PecasModel peca = modelMapper.map(pecaDTO, PecasModel.class);

        repository.save(peca);

        return "Peça gravada com sucesso!";
    }

    public String atualizarPeca(PecaAtualizarDTO pecaDTO) {

        Optional<PecasModel> pecaBaseDados = repository.findById(pecaDTO.getCarroID());

        if(pecaBaseDados == null){
            return "Peça não existe na base de dados!";
        }

       List<PecasModel> pecasBaseDados = repository.findByNomeOrNumeroSerie(pecaDTO.getNome(), pecaDTO.getNumSerie());

        if(!pecasBaseDados.isEmpty()){
            return "Peça já existe na base de dados!";
        }

        PecasModel peca = modelMapper.map(pecaDTO, PecasModel.class);

        repository.save(peca);

        return "Peça atualizada com sucesso! ";
    }

    public String excluirPeca(int id) {

        Optional<PecasModel> pecaBaseDados = repository.findById(id);

        if(pecaBaseDados.isEmpty()){
            return "Peça não existe na base de dados!";
        }

        repository.deleteById(id);

        return "Peça Excluída com sucesso!";
    }
}
