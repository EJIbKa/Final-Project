package Dealership;

import cars.*;
import java.time.Year;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DealershipApplication {
    private final CarTypeEnum carType;
    private final CarMarksEnum mark;
    private final Year year;
    private final EngineDisplacementEnum engineSize;
    private final CarColorsEnum color;
    private final WheelSizeEnum wheelSize;
    private final Set<CarOptionsEnum> carOptions;
    private OverallDimensionsEnum overallDimensions;
    private BusAppointmentEnum busAppointment;
    private PassengerCarBodyEnum passengerCarBody;
    private SpecialCarTypeEnum specialCarType;
    private CarryingCapacityEnum carryingCapacity;

    public DealershipApplication(
            CarMarksEnum mark,
            Year year,
            EngineDisplacementEnum engineSize,
            CarColorsEnum color,
            WheelSizeEnum wheelSize,
            CarryingCapacityEnum carryingCapacity,
            CarOptionsEnum...carOptions) {
        carType = CarTypeEnum.TRUCK_CAR;
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = Arrays.stream(carOptions).collect(Collectors.toSet());
        this.carryingCapacity = carryingCapacity;
    }

    public DealershipApplication(
            CarMarksEnum mark,
            Year year,
            EngineDisplacementEnum engineSize,
            CarColorsEnum color,
            WheelSizeEnum wheelSize,
            SpecialCarTypeEnum specialCarType,
            CarOptionsEnum...carOptions) {
        carType = CarTypeEnum.SPECIAL_CAR;
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = Arrays.stream(carOptions).collect(Collectors.toSet());
        this.specialCarType = specialCarType;
    }

    public DealershipApplication(
            CarMarksEnum mark,
            Year year,
            EngineDisplacementEnum engineSize,
            CarColorsEnum color,
            WheelSizeEnum wheelSize,
            PassengerCarBodyEnum passengerCarBody,
            CarOptionsEnum...carOptions) {
        carType = CarTypeEnum.PASSENGER_CAR;
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = Arrays.stream(carOptions).collect(Collectors.toSet());
        this.passengerCarBody = passengerCarBody;
    }

    public DealershipApplication(
            CarMarksEnum mark,
            Year year,
            EngineDisplacementEnum engineSize,
            CarColorsEnum color,
            WheelSizeEnum wheelSize,
            OverallDimensionsEnum overallDimensions,
            BusAppointmentEnum busAppointment,
            CarOptionsEnum...carOptions) {
        carType = CarTypeEnum.BUS_CAR;
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = Arrays.stream(carOptions).collect(Collectors.toSet());
        this.overallDimensions = overallDimensions;
        this.busAppointment = busAppointment;
    }

    public CarTypeEnum getCarType() {
        return carType;
    }

    public CarMarksEnum getMark() {
        return mark;
    }

    public Year getYear() {
        return year;
    }

    public EngineDisplacementEnum getEngineSize() {
        return engineSize;
    }

    public CarColorsEnum getColor() {
        return color;
    }

    public WheelSizeEnum getWheelSize() {
        return wheelSize;
    }

    public Set<CarOptionsEnum> getCarOptions() {
        return carOptions;
    }

    public OverallDimensionsEnum getOverallDimensions() {
        return overallDimensions;
    }

    public BusAppointmentEnum getBusAppointment() {
        return busAppointment;
    }

    public PassengerCarBodyEnum getPassengerCarBody() {
        return passengerCarBody;
    }

    public SpecialCarTypeEnum getSpecialCarType() {
        return specialCarType;
    }

    public CarryingCapacityEnum getCarryingCapacity() {
        return carryingCapacity;
    }
}


