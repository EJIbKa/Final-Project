package factories;

import cars.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class BusCarFactory extends CarFactory {
    private final Integer[] personCapacity;
    private final OverallDimensionsEnum[] overallDimensions;
    private final BusAppointmentEnum[] busAppointment;

    public BusCarFactory(CarMarksEnum[] marks,
                         EngineDisplacementEnum[] engineSize,
                         CarColorsEnum[] carColors,
                         WheelSizeEnum[] wheelSize,
                         CarColorChangeService carColorChangeService,
                         WheelSizeChangeService wheelSizeChangeService,
                         CarOptionsChangeService carOptionsChangeService,
                         Integer[] personCapacity,
                         OverallDimensionsEnum[] overallDimensions,
                         BusAppointmentEnum[] busAppointment) {
        super(marks,
                engineSize,
                carColors,
                wheelSize,
                carColorChangeService,
                wheelSizeChangeService,
                carOptionsChangeService);
        this.personCapacity = personCapacity;
        this.overallDimensions = overallDimensions;
        this.busAppointment = busAppointment;
        //заполняем склад завода при запуске некоторыми машинами
        var random = new Random();
        int carCounter = random.nextInt(10);
        BusCar busCar;
        for (int i = 0; i < carCounter; i++) {
            busCar = new BusCar(
                    this.getMarks()[random.nextInt(this.getMarks().length)],
                    Calendar.getInstance().get(Calendar.YEAR),
                    this.getEngineSize()[random.nextInt(this.getEngineSize().length)],
                    this.getCarColors()[random.nextInt(this.getCarColors().length)],
                    this.getWheelSize()[random.nextInt(this.getWheelSize().length)],
                    this.personCapacity[random.nextInt(this.personCapacity.length)],
                    this.overallDimensions[random.nextInt(this.overallDimensions.length)],
                    this.busAppointment[random.nextInt(this.busAppointment.length)]);
            this.getFactoryStorage().addCarToStorage(busCar);
        }
    }

    @Override
    public void printFactoryOpportunity() {
        super.printFactoryOpportunity();
        System.out.println("Вместимость человек: " + Arrays.toString(personCapacity));
        System.out.println("Габаритные размеры: " + Arrays.toString(overallDimensions));
        System.out.println("Назначение автобуса: " + Arrays.toString(busAppointment));
    }

    private void createCar(String[] carArgs) {
        this.getFactoryStorage().addCarToStorage(new BusCar(CarMarksEnum.valueOf(carArgs[0]),
                Calendar.getInstance().get(Calendar.YEAR),
                EngineDisplacementEnum.valueOf(carArgs[1]),
                CarColorsEnum.valueOf(carArgs[2]),
                WheelSizeEnum.valueOf(carArgs[3]),
                Integer.parseInt(carArgs[4]),
                OverallDimensionsEnum.valueOf(carArgs[5]),
                BusAppointmentEnum.valueOf(carArgs[6])));
    }

    @Override
    boolean checkCarArgsToCreateOnFactory(String[] carArgs) {
        boolean trigger = super.checkCarArgsToCreateOnFactory(carArgs);
        if (!trigger) {
            return trigger;
        }
        trigger = false;
        for (Integer present : this.personCapacity) {
            if (present.equals(Integer.parseInt(carArgs[4]))) {
                trigger = true;
                break;
            }
        }
        if (!trigger) {
            return trigger;
        }
        trigger = false;
        for (OverallDimensionsEnum present : this.overallDimensions) {
            if (present.equals(OverallDimensionsEnum.valueOf(carArgs[5]))) {
                trigger = true;
                break;
            }
        }
        if (!trigger) {
            return trigger;
        }
        trigger = false;
        for (BusAppointmentEnum present : this.busAppointment) {
            if (present.equals(BusAppointmentEnum.valueOf(carArgs[6]))) {
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
                        ", вместимость человек " + carArgs[4] +
                        ", габаритные размеры " + carArgs[5] +
                        ", назначение автобуса " + carArgs[6] +
                        (carArgs.length == 7 ? "." :
                                (", список опций: " + Arrays.toString(Arrays.copyOfRange(carArgs, 5, carArgs.length)))));
        if (checkCarArgsToCreateOnFactory(carArgs)) {
            CarOptionsEnum[] carOptions = null;
            if (carArgs.length > 7) {
                carOptions = new CarOptionsEnum[carArgs.length - 7];
                for (int i = 7; i < carArgs.length; i++) {
                    carOptions[i - 7] = CarOptionsEnum.valueOf(carArgs[i]);
                }
            }
            Car car = findCarInStorage(carArgs);
            if (car != null) {
                if (carArgs.length == 7) {
                    System.out.println("Найдена машина на складе завода, перемещение...");
                    return car;
                } else {
                    System.out.println("Найдена машина на складе завода, добавляем опции и перемещаем...");
                    addCarOptionsForRequest(car, carOptions);
                    return car;
                }
            }
            String[] tempArgs = {carArgs[0], carArgs[1], carArgs[4], carArgs[5], carArgs[6]};
            car = findCarInStorage(tempArgs);
            if (car != null) {
                System.out.println("Найдена машина на складе завода под изменение согласно заказу...");
                changeCarForRequest(car, CarColorsEnum.valueOf(carArgs[2]), WheelSizeEnum.valueOf(carArgs[3]));
                if (carArgs.length > 7) {
                    addCarOptionsForRequest(car, carOptions);
                }
                return car;
            }
            System.out.println("Создание новой машины...");
            createCar(carArgs);
            if (carArgs.length > 7) {
                addCarOptionsForRequest(getFactoryStorage().getStorage()[getFactoryStorage().getStorage().length - 1], carOptions);
            }
            return getFactoryStorage().moveCarFromStorageByIndex(getFactoryStorage().getStorage().length - 1);
        } else {
            System.out.println("Данный завод не может создать такую машину.");
        }
        return null;
    }
}
