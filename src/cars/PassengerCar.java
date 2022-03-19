package cars;

import java.time.Year;

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

}
