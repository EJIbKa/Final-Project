package cars;

import java.util.Arrays;

public class SpecialCar extends Car {
    private final SpecialCarTypeEnum specialCarType;

    public SpecialCar(CarMarksEnum mark,
                      Integer year,
                      EngineDisplacementEnum engineSize,
                      CarColorsEnum color,
                      WheelSizeEnum wheelSize,
                      SpecialCarTypeEnum specialCarType) {
        super(mark, year, engineSize, color, wheelSize);
        this.specialCarType = specialCarType;
    }

    public SpecialCar(CarMarksEnum mark,
                      Integer year,
                      EngineDisplacementEnum engineSize,
                      CarColorsEnum color,
                      WheelSizeEnum wheelSize,
                      SpecialCarTypeEnum specialCarType,
                      CarOptionsEnum... carOptions) {
        super(mark, year, engineSize, color, wheelSize, carOptions);
        this.specialCarType = specialCarType;
    }

    public SpecialCarTypeEnum getSpecialCarType() {
        return specialCarType;
    }

    @Override
    public String toString() {
        return super.getMark() + ", " +
                super.getYear() + " year, engine size " +
                super.getEngineSize() + ", color " +
                super.getColor() + ", wheel size " +
                super.getWheelSize() + ", type of car " +
                specialCarType +
                (super.getCarOptions().length == 0 ? '.' : ", options: " + Arrays.toString(super.getCarOptions()) + '.');
    }
}
