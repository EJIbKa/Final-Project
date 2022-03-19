package cars;

import java.time.Year;
import java.util.Arrays;

public abstract class PassengerCar extends Car {
    private Integer personCapacity;

    public PassengerCar(CarMarksEnum mark,
                        Year year,
                        EngineDisplacementEnum engineSize,
                        CarColorsEnum color,
                        WheelSizeEnum wheelSize,
                        Integer personCapacity) {
        super(mark, year, engineSize, color, wheelSize);
        this.personCapacity = personCapacity;
    }

    public PassengerCar(CarMarksEnum mark,
                        Year year,
                        EngineDisplacementEnum engineSize,
                        CarColorsEnum color,
                        WheelSizeEnum wheelSize,
                        Integer personCapacity,
                        CarOptionsEnum... carOptions) {
        super(mark, year, engineSize, color, wheelSize, carOptions);
        this.personCapacity = personCapacity;
    }

    public Integer getPersonCapacity() {
        return personCapacity;
    }

    public void setPersonCapacity(Integer personCapacity) {
        this.personCapacity = personCapacity;
    }

    @Override
    public String toString() {
        return super.getMark() + ", " +
                super.getYear() + " year, engine size " +
                super.getEngineSize() + ", color " +
                super.getColor() + ", wheel size " +
                super.getWheelSize() + ", person capacity " +
                personCapacity +
                (super.getCarOptions().length == 0 ? '.' : ", options: " + Arrays.toString(super.getCarOptions()) + '.');
    }

}
