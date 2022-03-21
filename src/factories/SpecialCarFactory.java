package factories;

import Dealership.DealershipApplication;
import cars.*;
import services.Services;
import java.time.Year;
import java.util.Arrays;
import java.util.Random;

public class SpecialCarFactory extends CarFactory {
    private final SpecialCarTypeEnum[] specialCarType;

    public SpecialCarFactory(CarMarksEnum[] marks,
                             EngineDisplacementEnum[] engineSize,
                             CarColorsEnum[] carColors,
                             WheelSizeEnum[] wheelSize,
                             Services services,
                             SpecialCarTypeEnum[] specialCarType) {
        super(marks,
                engineSize,
                carColors,
                wheelSize,
                services);
        this.specialCarType = specialCarType;
        //заполняем склад завода при запуске некоторыми машинами
        var random = new Random();
        int carCounter = random.nextInt(10);
        SpecialCar specialCar;
        for (int i = 0; i < carCounter; i++) {
            specialCar = new SpecialCar(
                    this.getMarks()[random.nextInt(this.getMarks().length)],
                    Year.now(),
                    this.getEngineSize()[random.nextInt(this.getEngineSize().length)],
                    this.getCarColors()[random.nextInt(this.getCarColors().length)],
                    this.getWheelSize()[random.nextInt(this.getWheelSize().length)],
                    this.specialCarType[random.nextInt(this.specialCarType.length)]);
            this.getFactoryStorage().addCarToStorage(specialCar);
        }
    }

    @Override
    public void printFactoryOpportunity() {
        super.printFactoryOpportunity();
        System.out.println("Тип: " + Arrays.toString(specialCarType));
    }

    @Override
    protected boolean checkCarArgsToCreateOnFactory(DealershipApplication dealershipApplication) {
        return super.checkCarArgsToCreateOnFactory(dealershipApplication)
                && Arrays.stream(specialCarType).anyMatch(p -> p.equals(dealershipApplication.getSpecialCarType()));
    }
}
