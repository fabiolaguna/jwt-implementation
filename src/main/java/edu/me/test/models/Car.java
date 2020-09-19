package edu.me.test.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.me.test.models.dtos.requests.PostCarDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "cars")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @Column(name = "id_car")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @JsonBackReference
    private User user;

    @Column(name = "patent")
    private String patent;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    public static Car fromPostDto(PostCarDto carDto) {

        return Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .patent(carDto.getPatent())
                .build();
    }
}
