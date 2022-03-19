package cars;

import java.time.Year;
import java.util.Arrays;

public class PassengerCar extends Car {
    private final PassengerCarBodyEnum passengerCarBody;

    public PassengerCar(CarMarksEnum mark,
                        Year year,
                        EngineDisplacementEnum engineSize,
                        CarColorsEnum color,
                        WheelSizeEnum wheelSize,
                        PassengerCarBodyEnum passengerCarBody) {
        super(mark, year, engineSize, color, wheelSize);
        this.passengerCarBody = passengerCarBody;
    }

    public PassengerCar(CarMarksEnum mark,
                        Year year,
                        EngineDisplacementEnum engineSize,
                        CarColorsEnum color,
                        WheelSizeEnum wheelSize,
                        PassengerCarBodyEnum passengerCarBody,
                        CarOptionsEnum... carOptions) {
        super(mark, year, engineSize, color, wheelSize, carOptions);
        this.passengerCarBody = passengerCarBody;
    }

    public PassengerCarBodyEnum getPassengerCarBody() {
        return passengerCarBody;
    }

    @Override
    public String toString() {
        return super.getMark() + ", " + super.getYear() + " year, engine size " + super.getEngineSize()
                + ", color " + super.getColor() + ", wheel size " + super.getWheelSize()
                + ", car body " + passengerCarBody
                + (super.getCarOptions().length == 0
                ? '.' : ", options: " + Arrays.toString(super.getCarOptions()) + '.');
    }
}
