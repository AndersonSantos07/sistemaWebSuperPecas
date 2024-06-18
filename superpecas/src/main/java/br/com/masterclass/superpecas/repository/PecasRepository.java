package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.PecasModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PecasRepository extends JpaRepository<PecasModel, Integer> {

    List<PecasModel> findByNomeOrNumeroSerie(String nome, String numSerie);

}
