package EvaluacionFinal.DAWI_Pillco_Porlles_David.repository;

import EvaluacionFinal.DAWI_Pillco_Porlles_David.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
