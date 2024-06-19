package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.CarrosModel;
import br.com.masterclass.superpecas.model.PecasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrosRepository extends JpaRepository<CarrosModel, Integer>, PagingAndSortingRepository<CarrosModel, Integer> {

    List<CarrosModel> findByNomeModeloOrCodigoUnico(String modelo, String codigoUnico);


    @Query(value = "select p.* from carros as c inner join pecas as p on c.carroID = p.carroID where p.carroID = :id", nativeQuery = true)
    List<PecasModel> pecasAssociadas(@Param("id") int id);

    @Query(value= "select fabricante, count(*) as totalCarros from carros group by fabricante order by totalCarros desc limit 10", nativeQuery = true)
    List<Object[]> listarTop10Fabricantes();

    @Query(value="select c.nomeModelo, count(p.PecaID) as quantidadePecas from carros as c inner join pecas as p on c.CarroID = p.CarroID group by c.NomeModelo order by quantidadePecas desc limit 10", nativeQuery = true)
    List<Object[]> listarTop10CarrosComMaisPecas();

    @Query("select c from CarrosModel as c where c.nomeModelo like %:termo% or c.fabricante like %:termo% or c.codigoUnico like %:termo%")
    Page<CarrosModel> findAllByTermo(String termo, Pageable pageable);

    @Query("select distinct fabricante from CarrosModel")
    List<Object[]> listarTodosFabricantes();

}
