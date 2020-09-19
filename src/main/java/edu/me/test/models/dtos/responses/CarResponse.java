package edu.me.test.models.dtos.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import edu.me.test.models.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CarResponse {

    private Integer id;

    private Integer idUser;

    private String patent;

    private String brand;

    private String model;

    public static CarResponse fromCar(Car car){

        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .idUser(car.getUser().getId())
                .patent(car.getPatent())
                .model(car.getModel())
                .build();
    }
}
