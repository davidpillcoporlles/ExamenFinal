package EvaluacionFinal.DAWI_Pillco_Porlles_David.response;

import EvaluacionFinal.DAWI_Pillco_Porlles_David.dto.CarDto;

public record FindCarsResponse(String code, String error, Iterable<CarDto> cars) {
}
