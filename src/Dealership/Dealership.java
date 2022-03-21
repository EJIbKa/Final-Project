package Dealership;

import cars.*;
import factories.CarFactory;
import services.Services;

public class Dealership {
    private final Services services;
    private final CarFactory factory;

    public Dealership(Services services,
                      CarFactory factory) {
        this.services = services;
        this.factory = factory;
    }

    public Car changeSomethingInCar(Car car, CarColorsEnum carColors) {
        services.changeCarColor(car, carColors);
        return car;
    }

    public Car changeSomethingInCar(Car car, WheelSizeEnum wheelSize) {
        services.changeWheelSize(car, wheelSize);
        return car;
    }

    public Car changeSomethingInCar(Car car, CarColorsEnum carColors, WheelSizeEnum wheelSize) {
        services.changeCarColor(car, carColors);
        services.changeWheelSize(car, wheelSize);
        return car;
    }

    public Car addOptionsInCar(Car car, CarOptionsEnum...carOptions) {
        if (carOptions.length > 0) {
            services.addCarOptions(car, carOptions);
        }
        return car;
    }

    public Car removeOptionsInCar(Car car, CarOptionsEnum... carOptions) {
        if (carOptions.length > 0) {
            services.removeCarOptions(car, carOptions);
        }
        return car;
    }

    public Car clientOrder(DealershipApplication dealershipApplication) {
        return factory.dealershipRequest(dealershipApplication);
    }
}
