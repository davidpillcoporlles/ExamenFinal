package EvaluacionFinal.DAWI_Pillco_Porlles_David.api;

import EvaluacionFinal.DAWI_Pillco_Porlles_David.dto.CarDetailDto;
import EvaluacionFinal.DAWI_Pillco_Porlles_David.dto.CarDto;
import EvaluacionFinal.DAWI_Pillco_Porlles_David.response.*;
import EvaluacionFinal.DAWI_Pillco_Porlles_David.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDto> optional = manageService.getAllCarsById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDto carDto = optional.get();
                    return new FindCarsResponse("01", "", List.of(carDto));
                } else {
                    return new FindCarsResponse("02", "User not found", null);
                }

            } else {
                List<CarDto> cars = manageService.getAllCars();
                if (!cars.isEmpty())
                    return new FindCarsResponse("01", "", cars);
                else
                    return new FindCarsResponse("03", "User list not found", cars);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "Service not found", null);

        }

    }
    @GetMapping("/detail")
    public FindCarsByIdResponse findCarById(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDetailDto> optional = manageService.getCarById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDetailDto carDetailDto = optional.get();
                    return new FindCarsByIdResponse("01", "", carDetailDto);
                } else {
                    return new FindCarsByIdResponse("02", "User not found", null);
                }

            } else
                return new FindCarsByIdResponse("03", "Parameter not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsByIdResponse("99", "Service not found", null);

        }

    }

    @PostMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto) {

        try {
            if (manageService.updateCar(carDto)) {
                return new UpdateCarResponse("01", "");
            } else {
                return new UpdateCarResponse("02", "User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "Service not found");

        }

    }
    @DeleteMapping("/delete")
    public DeleteCarResponse deleteCar(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {
                boolean isDeleted = manageService.deleteCarById(Integer.parseInt(id));
                if (isDeleted) {
                    return new DeleteCarResponse("01", "Car deleted successfully");
                } else {
                    return new DeleteCarResponse("02", "Car not found");
                }
            } else {
                return new DeleteCarResponse("03", "Invalid parameter");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "Service error");
        }
    }
    @PostMapping("/create")
    public ResponseEntity<CreateCarResponse> createCar(@RequestBody CarDto carDto) {
        try {
            boolean isCreated = manageService.addCar(carDto);
            if (isCreated) {
                return ResponseEntity.ok(new CreateCarResponse("01", "Car created successfully"));
            } else {
                return ResponseEntity.ok(new CreateCarResponse("02", "Car creation failed"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CreateCarResponse("99", "Service error"));
        }
    }



}