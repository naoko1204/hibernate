package entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    private int id;

    private String model;

    private String color;

    @Column(name = "prod_year")
    private LocalDate prodYear;

    private float mileage;

}
