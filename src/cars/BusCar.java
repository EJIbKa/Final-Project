package cars;

import java.time.Year;
import java.util.Arrays;

public class BusCar extends PassengerCar {
private final OverallDimensionsEnum overallDimensions;
private final BusAppointmentEnum busAppointment;

    public BusCar(CarMarksEnum mark,
                  Year year,
                  EngineDisplacementEnum engineSize,
                  CarColorsEnum color,
                  WheelSizeEnum wheelSize,
                  Integer personCapacity,
                  OverallDimensionsEnum overallDimensions,
                  BusAppointmentEnum busAppointment) {
        super(mark, year, engineSize, color, wheelSize, personCapacity);
        this.overallDimensions = overallDimensions;
        this.busAppointment = busAppointment;
    }

    public BusCar(CarMarksEnum mark,
                  Year year,
                  EngineDisplacementEnum engineSize,
                  CarColorsEnum color,
                  WheelSizeEnum wheelSize,
                  Integer personCapacity,
                  OverallDimensionsEnum overallDimensions,
                  BusAppointmentEnum busAppointment,
                  CarOptionsEnum... carOptions) {
        super(mark, year, engineSize, color, wheelSize, personCapacity, carOptions);
        this.overallDimensions = overallDimensions;
        this.busAppointment = busAppointment;
    }

    public OverallDimensionsEnum getOverallDimensions() {
        return overallDimensions;
    }

    public BusAppointmentEnum getBusAppointment() {
        return busAppointment;
    }

    @Override
    public String toString() {
        return super.getMark() + ", " + super.getYear() + " year, engine size " + super.getEngineSize()
                + ", color " + super.getColor() + ", wheel size " + super.getWheelSize()
                + ", person capacity " + super.getPersonCapacity()
                + ", overall dimension " + overallDimensions
                + ", bus appointment " + busAppointment
                + (super.getCarOptions().length == 0
                ? '.' : ", options: " + Arrays.toString(super.getCarOptions()) + '.');
    }
}
