package repository;

import model.PecasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecasRepository extends JpaRepository<PecasModel, Integer> {
}
