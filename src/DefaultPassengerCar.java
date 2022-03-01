import java.util.Arrays;

public class DefaultPassengerCar extends PassengerCar{
    private final PassengerCarBodyEnum passengerCarBody;

    public DefaultPassengerCar(CarMarksEnum mark,
                               Integer year,
                               EngineDisplacementEnum engineSize,
                               CarColorsEnum color,
                               WheelSizeEnum wheelSize,
                               Integer personCapacity,
                               PassengerCarBodyEnum passengerCarBody) {
        super(mark, year, engineSize, color, wheelSize, personCapacity);
        this.passengerCarBody = passengerCarBody;
    }

    public DefaultPassengerCar(CarMarksEnum mark,
                               Integer year,
                               EngineDisplacementEnum engineSize,
                               CarColorsEnum color,
                               WheelSizeEnum wheelSize,
                               Integer personCapacity,
                               PassengerCarBodyEnum passengerCarBody,
                               CarOptionsEnum... carOptions) {
        super(mark, year, engineSize, color, wheelSize, personCapacity, carOptions);
        this.passengerCarBody = passengerCarBody;
    }

    public PassengerCarBodyEnum getPassengerCarBody() {
        return passengerCarBody;
    }

    @Override
    public String toString() {
        return super.getMark() + ", " +
                super.getYear() + " year, engine size " +
                super.getEngineSize() + ", color " +
                super.getColor() + ", wheel size " +
                super.getWheelSize() + ", person capacity " +
                super.getPersonCapacity() + ", car body " +
                passengerCarBody +
                (super.getCarOptions().length == 0 ? '.' : ", options: " + Arrays.toString(super.getCarOptions()) + '.');
    }
}
