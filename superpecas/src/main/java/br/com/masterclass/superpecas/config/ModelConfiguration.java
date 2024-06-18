package br.com.masterclass.superpecas.config;

import br.com.masterclass.superpecas.dto.CarroAtualizarDTO;
import br.com.masterclass.superpecas.dto.CarroCriarDTO;
import br.com.masterclass.superpecas.dto.PecaAtualizarDTO;
import br.com.masterclass.superpecas.dto.PecaCriarDTO;
import br.com.masterclass.superpecas.model.CarrosModel;
import br.com.masterclass.superpecas.model.PecasModel;
import br.com.masterclass.superpecas.repository.CarrosRepository;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfiguration {

    @Autowired
    CarrosRepository carrosRepository;

    Converter<Integer, CarrosModel> carroConverter = new AbstractConverter<Integer, CarrosModel>() {
        @Override
        protected CarrosModel convert(Integer carroId) {
            return carrosRepository.findById(carroId).orElse(null);
        }
    };


    @Bean
    public ModelMapper getModel(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<CarroCriarDTO, CarrosModel>() {

            @Override
            protected void configure(){
                map().setNomeModelo(source.getModelo());
                map().setFabricante(source.getFabricante());
                map().setCodigoUnico(source.getCodigoUnico());
            }
        });

        modelMapper.addMappings(new PropertyMap<CarroAtualizarDTO, CarrosModel>() {

            @Override
            protected  void configure(){
                map().setCarroID(source.getId());
                map().setNomeModelo(source.getModelo());
                map().setFabricante(source.getFabricante());
                map().setCodigoUnico(source.getCodigoUnico());
            }
        });



        modelMapper.addMappings(new PropertyMap<PecaCriarDTO, PecasModel>() {

            @Override
            protected void configure() {
                map().setNome(source.getNome());
                map().setDescricao(source.getDesc());
                map().setNumeroSerie(source.getNumSerie());
                map().setFabricante(source.getFabricante());
                map().setModeloCarro(source.getModeloCarro());
                using(carroConverter).map(source.getCarroId()).setCarro(null);
            }
        });

        modelMapper.addMappings(new PropertyMap<PecaAtualizarDTO, PecasModel>() {

            @Override
            protected void configure() {
                map().setPecaId(source.getId());
                map().setNome(source.getNome());
                map().setDescricao(source.getDesc());
                map().setNumeroSerie(source.getNumSerie());
                map().setFabricante(source.getFabricante());
                map().setModeloCarro(source.getModeloCarro());
                using(carroConverter).map(source.getCarroID()).setCarro(null);
            }
        });

        return modelMapper;
    }


}
