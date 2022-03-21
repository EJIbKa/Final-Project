package Dealership;

import cars.*;
import factories.Factories;
import services.Services;

public class Dealership {
    private final Services services;
    private final Factories factories;

    public Dealership(Services services,
                      Factories factories) {
        this.services = services;
        this.factories = factories;
    }

    public void changeSomethingInCar(Car car, CarColorsEnum carColors) {
        services.changeCarColor(car, carColors);
    }

    public void changeSomethingInCar(Car car, WheelSizeEnum wheelSize) {
        services.changeWheelSize(car, wheelSize);
    }

    public void changeSomethingInCar(Car car, CarColorsEnum carColors, WheelSizeEnum wheelSize) {
        services.changeCarColor(car, carColors);
        services.changeWheelSize(car, wheelSize);
    }

    public void addOptionsInCar(Car car, CarOptionsEnum...carOptions) {
        if (carOptions.length > 0) {
            services.addCarOptions(car, carOptions);
        }
    }

    public void removeOptionsInCar(Car car, CarOptionsEnum...carOptions) {
        if (carOptions.length > 0) {
            services.removeCarOptions(car, carOptions);
        }
    }

    public Car clientOrder(DealershipApplication dealershipApplication) {
        return factories.dealershipRequest(dealershipApplication);
    }
}
