package EvaluacionFinal.DAWI_Pillco_Porlles_David.response;

import EvaluacionFinal.DAWI_Pillco_Porlles_David.dto.CarDetailDto;

public record FindCarsByIdResponse(String code, String error, CarDetailDto car) {
}
