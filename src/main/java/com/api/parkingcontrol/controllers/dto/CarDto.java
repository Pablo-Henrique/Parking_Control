package com.api.parkingcontrol.controllers.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CarDto {

    @NotBlank
    private String licensePlateCar;

    @NotBlank
    private String brandCar;

    @NotBlank
    private String modelCar;

    @NotBlank
    private String colorCar;
}
