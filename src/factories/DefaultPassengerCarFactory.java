package factories;

import Dealership.DealershipApplication;
import cars.*;
import services.Services;
import java.time.Year;
import java.util.Arrays;
import java.util.Random;

public class DefaultPassengerCarFactory extends CarFactory {
    private final PassengerCarBodyEnum[] passengerCarBody;

    public DefaultPassengerCarFactory(CarMarksEnum[] marks,
                                      EngineDisplacementEnum[] engineSize,
                                      CarColorsEnum[] carColors,
                                      WheelSizeEnum[] wheelSize,
                                      Services services,
                                      PassengerCarBodyEnum[] passengerCarBody) {
        super(marks,
                engineSize,
                carColors,
                wheelSize,
                services);
        this.passengerCarBody = passengerCarBody;
        //заполняем склад завода при запуске некоторыми машинами
        var random = new Random();
        int carCounter = random.nextInt(10);
        PassengerCar passengerCar;
        for (int i = 0; i < carCounter; i++) {
            passengerCar = new PassengerCar(
                    this.getMarks()[random.nextInt(this.getMarks().length)],
                    Year.now(),
                    this.getEngineSize()[random.nextInt(this.getEngineSize().length)],
                    this.getCarColors()[random.nextInt(this.getCarColors().length)],
                    this.getWheelSize()[random.nextInt(this.getWheelSize().length)],
                    this.passengerCarBody[random.nextInt(this.passengerCarBody.length)]);
            this.getFactoryStorage().addCarToStorage(passengerCar);
        }
    }

    @Override
    public void printFactoryOpportunity() {
        super.printFactoryOpportunity();
        System.out.println("Тип кузова: " + Arrays.toString(passengerCarBody));
    }

    @Override
    protected boolean checkCarArgsToCreateOnFactory(DealershipApplication dealershipApplication) {
        return super.checkCarArgsToCreateOnFactory(dealershipApplication)
                && Arrays.stream(passengerCarBody).anyMatch(p -> p.equals(dealershipApplication.getPassengerCarBody()));
    }
}
