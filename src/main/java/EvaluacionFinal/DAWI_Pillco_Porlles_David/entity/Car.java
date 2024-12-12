package EvaluacionFinal.DAWI_Pillco_Porlles_David.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer idCar;
    private String make;
    private String model;
    private Integer year;
    private String vin;
    private String licensePlate;
    private String ownerName;
    private String ownerContact;
    private Date purchaseDate;
    private Integer mileage;
    private String engineType;
    private String color;
    private String insuranceCompany;
    private String insurancePolicyNumber;
    private Date registrationExpirationDate;
    private Date serviceDueDate;
}
