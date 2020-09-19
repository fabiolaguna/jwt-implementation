package edu.me.test.services;

import edu.me.test.models.Car;
import edu.me.test.models.dtos.requests.PostCarDto;
import edu.me.test.repositories.CarRepository;
import edu.me.test.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    public Car save(PostCarDto carDto) {

        Car car = Car.fromPostDto(carDto);

        car.setUser(userRepository.findById(carDto.getIdUser()).get());

        return carRepository.save(car);
    }

    public List<Car> getAll() {

        return carRepository.findAll();
    }
}
