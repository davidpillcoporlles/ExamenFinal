package EvaluacionFinal.DAWI_Pillco_Porlles_David.service;

import EvaluacionFinal.DAWI_Pillco_Porlles_David.dto.CarDetailDto;
import EvaluacionFinal.DAWI_Pillco_Porlles_David.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto>getAllCars() throws Exception;

    Optional<CarDto> getAllCarsById(int id) throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDto carDto) throws Exception;
}
