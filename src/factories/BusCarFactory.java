package factories;

import Dealership.DealershipApplication;
import cars.*;
import services.Services;
import java.time.Year;
import java.util.Arrays;
import java.util.Random;

public class BusCarFactory extends CarFactory {
    private final OverallDimensionsEnum[] overallDimensions;
    private final BusAppointmentEnum[] busAppointment;

    public BusCarFactory(CarMarksEnum[] marks,
                         EngineDisplacementEnum[] engineSize,
                         CarColorsEnum[] carColors,
                         WheelSizeEnum[] wheelSize,
                         Services services,
                         OverallDimensionsEnum[] overallDimensions,
                         BusAppointmentEnum[] busAppointment) {
        super(marks,
                engineSize,
                carColors,
                wheelSize,
                services);
        this.overallDimensions = overallDimensions;
        this.busAppointment = busAppointment;
        //заполняем склад завода при запуске некоторыми машинами
        var random = new Random();
        int carCounter = random.nextInt(10);
        BusCar busCar;
        for (int i = 0; i < carCounter; i++) {
            busCar = new BusCar(
                    this.getMarks()[random.nextInt(this.getMarks().length)],
                    Year.now(),
                    this.getEngineSize()[random.nextInt(this.getEngineSize().length)],
                    this.getCarColors()[random.nextInt(this.getCarColors().length)],
                    this.getWheelSize()[random.nextInt(this.getWheelSize().length)],
                    this.overallDimensions[random.nextInt(this.overallDimensions.length)],
                    this.busAppointment[random.nextInt(this.busAppointment.length)]);
            getFactoryStorage().addCarToStorage(busCar);
        }
    }

    @Override
    public void printFactoryOpportunity() {
        super.printFactoryOpportunity();
        System.out.println("Габаритные размеры: " + Arrays.toString(overallDimensions));
        System.out.println("Назначение автобуса: " + Arrays.toString(busAppointment));
    }

    @Override
    protected boolean checkCarArgsToCreateOnFactory(DealershipApplication dealershipApplication) {
        return super.checkCarArgsToCreateOnFactory(dealershipApplication)
                && Arrays.stream(overallDimensions).anyMatch(p -> p.equals(dealershipApplication.getOverallDimensions()))
                && Arrays.stream(busAppointment).anyMatch(p -> p.equals(dealershipApplication.getBusAppointment()));
    }
}
