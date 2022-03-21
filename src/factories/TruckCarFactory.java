package factories;

import Dealership.DealershipApplication;
import cars.*;
import services.Services;
import java.time.Year;
import java.util.Arrays;
import java.util.Random;

public class TruckCarFactory extends CarFactory {
    private final CarryingCapacityEnum[] carryingCapacity;

    public TruckCarFactory(CarMarksEnum[] marks,
                           EngineDisplacementEnum[] engineSize,
                           CarColorsEnum[] carColors,
                           WheelSizeEnum[] wheelSize,
                           Services services,
                           CarryingCapacityEnum[] carryingCapacity) {
        super(marks,
                engineSize,
                carColors,
                wheelSize,
                services);
        this.carryingCapacity = carryingCapacity;
        //заполняем склад завода при запуске некоторыми машинами
        var random = new Random();
        int carCounter = random.nextInt(10);
        TruckCar truckCar;
        for (int i = 0; i < carCounter; i++) {
            truckCar = new TruckCar(
                    this.getMarks()[random.nextInt(this.getMarks().length)],
                    Year.now(),
                    this.getEngineSize()[random.nextInt(this.getEngineSize().length)],
                    this.getCarColors()[random.nextInt(this.getCarColors().length)],
                    this.getWheelSize()[random.nextInt(this.getWheelSize().length)],
                    this.carryingCapacity[random.nextInt(this.carryingCapacity.length)]);
            this.getFactoryStorage().addCarToStorage(truckCar);
        }
    }

    @Override
    public void printFactoryOpportunity() {
        super.printFactoryOpportunity();
        System.out.println("Грузоподъемность: " + Arrays.toString(carryingCapacity));
    }

    @Override
    protected boolean checkCarArgsToCreateOnFactory(DealershipApplication dealershipApplication) {
        return super.checkCarArgsToCreateOnFactory(dealershipApplication)
                && Arrays.stream(carryingCapacity).anyMatch(p -> p.equals(dealershipApplication.getCarryingCapacity()));
    }
}
