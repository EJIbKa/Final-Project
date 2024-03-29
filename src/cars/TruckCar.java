package cars;

import java.time.Year;
import java.util.Arrays;

public class TruckCar extends Car {
    private final CarryingCapacityEnum carryingCapacity;

    public TruckCar(CarMarksEnum mark,
                    Year year,
                    EngineDisplacementEnum engineSize,
                    CarColorsEnum color,
                    WheelSizeEnum wheelSize,
                    CarryingCapacityEnum carryingCapacity) {
        super(mark, year, engineSize, color, wheelSize);
        this.carryingCapacity = carryingCapacity;
    }

    public TruckCar(CarMarksEnum mark,
                    Year year,
                    EngineDisplacementEnum engineSize,
                    CarColorsEnum color,
                    WheelSizeEnum wheelSize,
                    CarryingCapacityEnum carryingCapacity,
                    CarOptionsEnum... carOptions) {
        super(mark, year, engineSize, color, wheelSize, carOptions);
        this.carryingCapacity = carryingCapacity;
    }

    public CarryingCapacityEnum getCarryingCapacity() {
        return carryingCapacity;
    }

    @Override
    public String toString() {
        return super.getMark() + ", " + super.getYear() + " year, engine size " + super.getEngineSize()
                + ", color " + super.getColor() + ", wheel size " + super.getWheelSize()
                + ", carrying capacity " + carryingCapacity
                + (super.getCarOptions().size() == 0
                ? '.' : ", options: " + Arrays.toString(super.getCarOptions().toArray()) + '.');
    }

}
