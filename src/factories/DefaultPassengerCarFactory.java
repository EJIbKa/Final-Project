package factories;

import cars.*;
import services.CarColorChangeService;
import services.CarOptionsChangeService;
import services.WheelSizeChangeService;

import java.time.Year;
import java.util.Arrays;
import java.util.Random;

public class DefaultPassengerCarFactory extends CarFactory {
    private final PassengerCarBodyEnum[] passengerCarBody;

    public DefaultPassengerCarFactory(CarMarksEnum[] marks,
                                      EngineDisplacementEnum[] engineSize,
                                      CarColorsEnum[] carColors,
                                      WheelSizeEnum[] wheelSize,
                                      CarColorChangeService carColorChangeService,
                                      WheelSizeChangeService wheelSizeChangeService,
                                      CarOptionsChangeService carOptionsChangeService,
                                      PassengerCarBodyEnum[] passengerCarBody) {
        super(marks,
                engineSize,
                carColors,
                wheelSize,
                carColorChangeService,
                wheelSizeChangeService,
                carOptionsChangeService);
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

    private void createCar(String[] carArgs) {
        this.getFactoryStorage().addCarToStorage(new PassengerCar(CarMarksEnum.valueOf(carArgs[0]),
                Year.now(),
                EngineDisplacementEnum.valueOf(carArgs[1]),
                CarColorsEnum.valueOf(carArgs[2]),
                WheelSizeEnum.valueOf(carArgs[3]),
                PassengerCarBodyEnum.valueOf(carArgs[5])));
    }

    @Override
    boolean checkCarArgsToCreateOnFactory(String[] carArgs) {
        boolean trigger = super.checkCarArgsToCreateOnFactory(carArgs);
        if (!trigger) {
            return trigger;
        }
        trigger = false;
        for (PassengerCarBodyEnum present : this.passengerCarBody) {
            if (present.equals(PassengerCarBodyEnum.valueOf(carArgs[5]))) {
                trigger = true;
                break;
            }
        }
        return trigger;
    }

    @Override
    public Car dealershipRequest(String[] carArgs) {
        System.out.println(
                "Заказ от автосалона: марка " + carArgs[0] +
                        ", размер двигателя " + carArgs[1] +
                        ", цвет " + carArgs[2] +
                        ", размер колес " + carArgs[3] +
                        ", тип кузова " + carArgs[5] +
                        (carArgs.length == 6 ? "." : (", список опций: "
                                + Arrays.toString(Arrays.copyOfRange(carArgs, 6, carArgs.length)))));
        if (checkCarArgsToCreateOnFactory(carArgs)) {
            CarOptionsEnum[] carOptions = null;
            if (carArgs.length > 6) {
                carOptions = new CarOptionsEnum[carArgs.length - 6];
                for (int i = 6; i < carArgs.length; i++) {
                    carOptions[i - 6] = CarOptionsEnum.valueOf(carArgs[i]);
                }
            }
            Car car = findCarInStorage(carArgs);
            if (car != null) {
                if (carArgs.length == 6) {
                    System.out.println("Найдена машина на складе завода, перемещение...");
                } else {
                    System.out.println("Найдена машина на складе завода, добавляем опции и перемещаем...");
                    addCarOptionsForRequest(car, carOptions);
                }
                return car;
            }
            String[] tempArgs = {carArgs[0], carArgs[1], carArgs[4], carArgs[5]};
            car = findCarInStorage(tempArgs);
            if (car != null) {
                System.out.println("Найдена машина на складе завода под изменение согласно заказу...");
                changeCarForRequest(car, CarColorsEnum.valueOf(carArgs[2]), WheelSizeEnum.valueOf(carArgs[3]));
                if (carArgs.length > 6) {
                    addCarOptionsForRequest(car, carOptions);
                }
                return car;
            }
            System.out.println("Создание новой машины...");
            createCar(carArgs);
            if (carArgs.length > 6) {
                addCarOptionsForRequest(getFactoryStorage().getStorage()[getFactoryStorage().getStorage().length - 1], carOptions);
            }
            return getFactoryStorage().moveCarFromStorageByIndex(getFactoryStorage().getStorage().length - 1);
        } else {
            System.out.println("Данный завод не может создать такую машину.");
        }
        return null;
    }
}
