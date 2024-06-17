package repository;

import model.CarrosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository extends JpaRepository<CarrosModel, Integer> {

}
