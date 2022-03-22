import Dealership.Dealership;
import Dealership.DealershipApplication;
import cars.*;
import factories.*;
import services.Services;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        var passengerCarFactory = new PassengerCarFactory(
                new CarMarksEnum[]{CarMarksEnum.AUDI, CarMarksEnum.BMW},
                new EngineDisplacementEnum[]{EngineDisplacementEnum.SMALL_CAPACITY, EngineDisplacementEnum.LARGE_CAPACITY},
                new CarColorsEnum[]{CarColorsEnum.BLACK, CarColorsEnum.GREEN},
                new WheelSizeEnum[]{WheelSizeEnum.INCH_18, WheelSizeEnum.INCH_20},
                new Services(),
                new PassengerCarBodyEnum[]{PassengerCarBodyEnum.SEDAN, PassengerCarBodyEnum.CONVERTIBLE}
        );
        var busCarFactory = new BusCarFactory(
                new CarMarksEnum[]{CarMarksEnum.AUDI, CarMarksEnum.BMW},
                new EngineDisplacementEnum[]{EngineDisplacementEnum.SMALL_CAPACITY, EngineDisplacementEnum.LARGE_CAPACITY},
                new CarColorsEnum[]{CarColorsEnum.BLACK, CarColorsEnum.GREEN},
                new WheelSizeEnum[]{WheelSizeEnum.INCH_18, WheelSizeEnum.INCH_20},
                new Services(),
                new OverallDimensionsEnum[]{OverallDimensionsEnum.ESPECIALLY_SMALL, OverallDimensionsEnum.MEDIUM},
                new BusAppointmentEnum[]{BusAppointmentEnum.URBAN, BusAppointmentEnum.TOURIST}
        );
        var truckCarFactory = new TruckCarFactory(
                new CarMarksEnum[]{CarMarksEnum.AUDI, CarMarksEnum.BMW},
                new EngineDisplacementEnum[]{EngineDisplacementEnum.SMALL_CAPACITY, EngineDisplacementEnum.LARGE_CAPACITY},
                new CarColorsEnum[]{CarColorsEnum.BLACK, CarColorsEnum.GREEN},
                new WheelSizeEnum[]{WheelSizeEnum.INCH_18, WheelSizeEnum.INCH_20},
                new Services(),
                new CarryingCapacityEnum[]{CarryingCapacityEnum.MEDIUM, CarryingCapacityEnum.LARGE}
        );
        var specialCarFactory = new SpecialCarFactory(
                new CarMarksEnum[]{CarMarksEnum.AUDI, CarMarksEnum.BMW},
                new EngineDisplacementEnum[]{EngineDisplacementEnum.SMALL_CAPACITY, EngineDisplacementEnum.LARGE_CAPACITY},
                new CarColorsEnum[]{CarColorsEnum.BLACK, CarColorsEnum.GREEN},
                new WheelSizeEnum[]{WheelSizeEnum.INCH_18, WheelSizeEnum.INCH_20},
                new Services(),
                new SpecialCarTypeEnum[]{SpecialCarTypeEnum.CAR_SHOP, SpecialCarTypeEnum.AMBULANCE}
        );
        var factories = new Factories(busCarFactory, passengerCarFactory, specialCarFactory, truckCarFactory);
        var dealership = new Dealership(new Services(), factories);
        var car = dealership.clientOrder(
                CarMarksEnum.AUDI,
                Year.now(),
                EngineDisplacementEnum.LARGE_CAPACITY,
                CarColorsEnum.BLACK,
                WheelSizeEnum.INCH_20,
                PassengerCarBodyEnum.SEDAN,
                CarOptionsEnum.NAVIGATION_SYSTEM
        );
        System.out.println(car);
        System.out.println();
        dealership.changeSomethingInCar(car, CarColorsEnum.WHITE);
        System.out.println(car);
        System.out.println();
        dealership.addOptionsInCar(car, CarOptionsEnum.LEATHER_SEATS, CarOptionsEnum.CLIMATE_CONTROL);
        System.out.println(car);
    }
}
