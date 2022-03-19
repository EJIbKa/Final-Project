package factories;

import cars.*;
import services.CarColorChangeService;
import services.CarOptionsChangeService;
import services.WheelSizeChangeService;

import java.time.Year;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class TruckCarFactory extends CarFactory {
    private final CarryingCapacityEnum[] carryingCapacity;

    public TruckCarFactory(CarMarksEnum[] marks,
                           EngineDisplacementEnum[] engineSize,
                           CarColorsEnum[] carColors,
                           WheelSizeEnum[] wheelSize,
                           CarColorChangeService carColorChangeService,
                           WheelSizeChangeService wheelSizeChangeService,
                           CarOptionsChangeService carOptionsChangeService,
                           CarryingCapacityEnum[] carryingCapacity) {
        super(marks,
                engineSize,
                carColors,
                wheelSize,
                carColorChangeService,
                wheelSizeChangeService,
                carOptionsChangeService);
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

    private void createCar(String[] carArgs) {
            this.getFactoryStorage().addCarToStorage(new TruckCar(CarMarksEnum.valueOf(carArgs[0]),
                    Year.now(),
                    EngineDisplacementEnum.valueOf(carArgs[1]),
                    CarColorsEnum.valueOf(carArgs[2]),
                    WheelSizeEnum.valueOf(carArgs[3]),
                    CarryingCapacityEnum.valueOf(carArgs[4])));
    }

    @Override
    boolean checkCarArgsToCreateOnFactory(String[] carArgs) {
        boolean trigger = super.checkCarArgsToCreateOnFactory(carArgs);
        if (!trigger) {
            return trigger;
        }
        trigger = false;
        for (CarryingCapacityEnum present : this.carryingCapacity) {
            if (present.equals(CarryingCapacityEnum.valueOf(carArgs[4]))) {
                trigger = true;
                break;
            }
        }
        return trigger;
    }

    @Override
    public Car dealershipRequest(String[] carArgs) {
        System.out.println(
                "Заказ от автосалона: марка " + CarMarksEnum.valueOf(carArgs[0]).name() +
                ", размер двигателя " + EngineDisplacementEnum.valueOf(carArgs[1]).name() +
                ", цвет " + CarColorsEnum.valueOf(carArgs[2]).name() +
                ", размер колес " + WheelSizeEnum.valueOf(carArgs[3]).name() +
                ", грузоподъемность " + CarryingCapacityEnum.valueOf(carArgs[4]) +
                (carArgs.length == 5 ? "." :
                        (", список опций: " + Arrays.toString(Arrays.copyOfRange(carArgs, 5, carArgs.length)))));
        if (checkCarArgsToCreateOnFactory(carArgs)) {
            CarOptionsEnum[] carOptions = null;
            if (carArgs.length > 5) {
                carOptions = new CarOptionsEnum[carArgs.length - 5];
                for (int i = 5; i < carArgs.length; i++) {
                    carOptions[i - 5] = CarOptionsEnum.valueOf(carArgs[i]);
                }
            }
            Car car = findCarInStorage(carArgs);
            if (car != null) {
                if (carArgs.length == 5) {
                    System.out.println("Найдена машина на складе завода, перемещение...");
                } else {
                    System.out.println("Найдена машина на складе завода, добавляем опции и перемещаем...");
                    addCarOptionsForRequest(car, carOptions);
                }
                return car;
            }
            String[] tempArgs = {carArgs[0], carArgs[1], carArgs[4]};
            car = findCarInStorage(tempArgs);
            if (car != null) {
                System.out.println("Найдена машина на складе завода под изменение согласно заказу...");
                changeCarForRequest(car, CarColorsEnum.valueOf(carArgs[2]), WheelSizeEnum.valueOf(carArgs[3]));
                if (carArgs.length > 5) {
                    addCarOptionsForRequest(car, carOptions);
                }
                return car;
            }
            System.out.println("Создание новой машины...");
            createCar(carArgs);
            if (carArgs.length > 5) {
                addCarOptionsForRequest(getFactoryStorage().getStorage()[getFactoryStorage().getStorage().length - 1], carOptions);
            }
            return getFactoryStorage().moveCarFromStorageByIndex(getFactoryStorage().getStorage().length - 1);
        } else {
            System.out.println("Данный завод не может создать такую машину.");
        }
        return null;
    }

}
