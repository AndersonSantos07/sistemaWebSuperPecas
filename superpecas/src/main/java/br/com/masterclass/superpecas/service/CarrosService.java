package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.CarrosDto;
import br.com.masterclass.superpecas.model.CarrosModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.masterclass.superpecas.repository.CarrosRepository;

@Service
public class CarrosService {

    @Autowired
    private CarrosRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public CarrosModel criarNovoCarro(CarrosDto carroDTO) {
        CarrosModel carro = new CarrosModel();
        modelMapper.map(carro, carroDTO.getClass());
        return  repository.save(carro);
    }
}