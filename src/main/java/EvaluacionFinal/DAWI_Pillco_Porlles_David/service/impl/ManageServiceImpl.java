package EvaluacionFinal.DAWI_Pillco_Porlles_David.service.impl;

import EvaluacionFinal.DAWI_Pillco_Porlles_David.dto.CarDetailDto;
import EvaluacionFinal.DAWI_Pillco_Porlles_David.dto.CarDto;
import EvaluacionFinal.DAWI_Pillco_Porlles_David.entity.Car;
import EvaluacionFinal.DAWI_Pillco_Porlles_David.repository.CarRepository;
import EvaluacionFinal.DAWI_Pillco_Porlles_David.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;


    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> cars.add(new CarDto(car.getIdCar(),
                car.getMake(),
                car.getModel(),
                car.getEngineType(),
                car.getColor())));

        return cars;
    }

    @Override
    public Optional<CarDto> getAllCarsById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDto(car.getIdCar(),
                car.getMake(),
                car.getModel(),
                car.getEngineType(),
                car.getColor()));

    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDto(car.getIdCar(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(), car.getRegistrationExpirationDate(), car.getServiceDueDate()));

    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.idCar());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setEngineType(carDto.engineType());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.idCar());
        if (optional.isPresent()) {
            return false;
        } else {
            Car car = new Car();
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setEngineType(carDto.engineType());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;
        }
    }
}




