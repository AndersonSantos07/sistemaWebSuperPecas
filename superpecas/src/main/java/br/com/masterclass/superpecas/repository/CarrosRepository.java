package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.CarrosModel;
import br.com.masterclass.superpecas.model.PecasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrosRepository extends JpaRepository<CarrosModel, Integer> {

    List<CarrosModel> findByNomeModeloOrCodigoUnico(String modelo, String codigoUnico);

    @Query(value = "select p.* from carros as c inner join pecas as p on c.carroID = p.carroID where p.carroID = :id", nativeQuery = true)
    List<PecasModel> pecasAssociadas(@Param("id") int id);


}
