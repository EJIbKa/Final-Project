package Dealership;

import cars.*;
import factories.Factories;
import services.Services;
import java.time.Year;

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

    public Car clientOrder(CarMarksEnum mark,
                           Year year,
                           EngineDisplacementEnum engineSize,
                           CarColorsEnum color,
                           WheelSizeEnum wheelSize,
                           CarryingCapacityEnum carryingCapacity,
                           CarOptionsEnum...carOptions) {
        return factories.dealershipRequest( new DealershipApplication(
                mark, year, engineSize, color, wheelSize, carryingCapacity, carOptions
        ));
    }

    public Car clientOrder(CarMarksEnum mark,
                           Year year,
                           EngineDisplacementEnum engineSize,
                           CarColorsEnum color,
                           WheelSizeEnum wheelSize,
                           SpecialCarTypeEnum specialCarType,
                           CarOptionsEnum...carOptions) {
        return factories.dealershipRequest( new DealershipApplication(
                mark, year, engineSize, color, wheelSize, specialCarType, carOptions
        ));
    }

    public Car clientOrder(CarMarksEnum mark,
                           Year year,
                           EngineDisplacementEnum engineSize,
                           CarColorsEnum color,
                           WheelSizeEnum wheelSize,
                           PassengerCarBodyEnum passengerCarBody,
                           CarOptionsEnum...carOptions) {
        return factories.dealershipRequest( new DealershipApplication(
                mark, year, engineSize, color, wheelSize, passengerCarBody, carOptions
        ));
    }

    public Car clientOrder(CarMarksEnum mark,
                           Year year,
                           EngineDisplacementEnum engineSize,
                           CarColorsEnum color,
                           WheelSizeEnum wheelSize,
                           OverallDimensionsEnum overallDimensions,
                           BusAppointmentEnum busAppointment,
                           CarOptionsEnum...carOptions) {
        return factories.dealershipRequest( new DealershipApplication(
                mark, year, engineSize, color, wheelSize, overallDimensions, busAppointment, carOptions
        ));
    }
}
