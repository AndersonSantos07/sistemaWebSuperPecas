package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.CarroAtualizarDTO;
import br.com.masterclass.superpecas.dto.CarroCriarDTO;
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

    public String criarNovoCarro(CarroCriarDTO carroDTO) {

        List<CarrosModel> carroBaseDados = repository.findByNomeModeloOrCodigoUnico(carroDTO.getModelo(), carroDTO.getCodigoUnico());
        if(!carroBaseDados.isEmpty()){
            return "Carro já existe na base de dados! ";
        }

        CarrosModel carro = modelMapper.map(carroDTO, CarrosModel.class);
        repository.save(carro);
        return "Carro gravado com sucesso! ";
    }

    public String atualizarCarro(CarroAtualizarDTO carroDTO){

        List<CarrosModel> carroBaseDados = repository.findByNomeModeloOrCodigoUnico(carroDTO.getModelo(), carroDTO.getCodigoUnico());
        if (!carroBaseDados.isEmpty()) {
            return "Carro já existe na base de dados!";
        }

        Optional<CarrosModel> carro = repository.findById(carroDTO.getId());

        if(carro.isEmpty()){
            return "Carro não existe na base de dados!";
        }

        CarrosModel carroAtualizado = modelMapper.map(carroDTO, CarrosModel.class);
        repository.save(carroAtualizado);

        return "Carro atualizado com sucesso!";
    }

    public String excluirCarro(int id) {

        Optional<CarrosModel> carro = repository.findById(id);

        if(carro.isEmpty()){
            return "Carro não existe na base de dados!";
        }

        List<PecasModel> pecas = repository.pecasAssociadas(carro.get().getCarroID());

        if(!pecas.isEmpty()){
            return "Existem peças associadas ao carro!";
        }

        repository.deleteById(id);

        return "Carro Excluído com sucesso! ";
    }
}