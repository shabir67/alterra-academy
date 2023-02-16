package com.task.kube.rest;


import com.task.kube.dto.CarDto;
import com.task.kube.persistence.model.Car;
import com.task.kube.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/car")
public class CarController {
    private CarService carService;

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello Petrol Head", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity get(@RequestBody final CarDto carDto) {
        Car car = getCarToCreate(carDto);
        Car createdCar = carService.create(car);
        return ResponseEntity.ok(CarDto.builder()
                .carName(createdCar.getCarName())
                .category(createdCar.getCategory())
                .build());

    }

    private Car getCarToCreate(CarDto carDto) {
        return  Car.builder()
                .carName(carDto.getCarName())
                .category(carDto.getCategory())
                .build();
    }
}
