import java.util.Arrays;

public abstract class Car {
    private final CarMarksEnum mark;
    private final Integer year;
    private final EngineDisplacementEnum engineSize;
    private CarColorsEnum color;
    private WheelSizeEnum wheelSize;
    private CarOptionsEnum[] carOptions;

    public Car(CarMarksEnum mark,
               Integer year,
               EngineDisplacementEnum engineSize,
               CarColorsEnum color,
               WheelSizeEnum wheelSize) {
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = new CarOptionsEnum[0];
    }

    public Car(CarMarksEnum mark,
               Integer year,
               EngineDisplacementEnum engineSize,
               CarColorsEnum color,
               WheelSizeEnum wheelSize,
               CarOptionsEnum... carOptions) {
        this.mark = mark;
        this.year = year;
        this.engineSize = engineSize;
        this.color = color;
        this.wheelSize = wheelSize;
        this.carOptions = carOptions;
    }

    public void setColor(CarColorsEnum color) {
        this.color = color;
    }

    public void setWheelSize(WheelSizeEnum wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setCarOptions(CarOptionsEnum[] carOptions) {
        this.carOptions = carOptions;
    }

    public CarMarksEnum getMark() {
        return mark;
    }

    public Integer getYear() {
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

    public void printCarInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return mark + ", " + year + " year, engine size " + engineSize +
                ", color " + color + ", wheel size " + wheelSize +
                (carOptions.length == 0 ? '.' : ", options: " + Arrays.toString(carOptions) + '.');
    }
}
