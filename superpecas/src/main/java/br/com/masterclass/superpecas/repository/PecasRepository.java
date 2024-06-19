package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.PecasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PecasRepository extends JpaRepository<PecasModel, Integer>, PagingAndSortingRepository<PecasModel, Integer> {

    List<PecasModel> findByNomeOrNumeroSerie(String nome, String numSerie);

    @Query("select p from PecasModel as p where p.nome like %:termo% or p.descricao like %:termo% or p.numeroSerie like %:termo% or p.fabricante like %:termo% or p.modeloCarro like %:termo%")
    Page<PecasModel> listarTodosPaginadoPorTermo(String termo, Pageable pageable);
}
