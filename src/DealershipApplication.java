import cars.*;
import java.time.Year;

public class DealershipApplication {
    private CarTypeEnum carType;
    private CarMarksEnum mark;
    private Year year;
    private EngineDisplacementEnum engineSize;
    private CarColorsEnum color;
    private WheelSizeEnum wheelSize;
    private CarOptionsEnum[] carOptions;
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
            CarOptionsEnum[] carOptions,
            CarryingCapacityEnum carryingCapacity) {
        carType = CarTypeEnum.TRUCK_CAR;
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = carOptions;
        this.carryingCapacity = carryingCapacity;
    }

    public DealershipApplication(
            CarMarksEnum mark,
            Year year,
            EngineDisplacementEnum engineSize,
            CarColorsEnum color,
            WheelSizeEnum wheelSize,
            CarOptionsEnum[] carOptions,
            SpecialCarTypeEnum specialCarType) {
        carType = CarTypeEnum.SPECIAL_CAR;
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = carOptions;
        this.specialCarType = specialCarType;
    }

    public DealershipApplication(
            CarMarksEnum mark,
            Year year,
            EngineDisplacementEnum engineSize,
            CarColorsEnum color,
            WheelSizeEnum wheelSize,
            CarOptionsEnum[] carOptions,
            PassengerCarBodyEnum passengerCarBody) {
        carType = CarTypeEnum.PASSENGER_CAR;
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = carOptions;
        this.passengerCarBody = passengerCarBody;
    }

    public DealershipApplication(
            CarMarksEnum mark,
            Year year,
            EngineDisplacementEnum engineSize,
            CarColorsEnum color,
            WheelSizeEnum wheelSize,
            CarOptionsEnum[] carOptions,
            OverallDimensionsEnum overallDimensions,
            BusAppointmentEnum busAppointment) {
        carType = CarTypeEnum.BUS_CAR;
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = carOptions;
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

    public CarOptionsEnum[] getCarOptions() {
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


