package edu.me.test.controllers;

import edu.me.test.models.dtos.requests.PostCarDto;
import edu.me.test.models.dtos.responses.CarResponse;
import edu.me.test.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarResponse> save(@RequestBody @Valid PostCarDto carDto){

        return ResponseEntity.created(getLocation(CarResponse.fromCar(carService.save(carDto)))).build();
    }

    private URI getLocation(CarResponse carResponse) {

        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id-car")
                .buildAndExpand(carResponse.getId())
                .toUri();
    }

    @GetMapping
    public ResponseEntity<List<CarResponse>> getAll(){

        List<CarResponse> cars = carService.getAll()
                .stream()
                .map(CarResponse::fromCar)
                .collect(Collectors.toList());

        return cars.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cars);
    }
}
