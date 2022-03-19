package factories;

import cars.*;
import services.CarColorChangeService;
import services.CarOptionsChangeService;
import services.WheelSizeChangeService;

import java.util.Arrays;

public abstract class CarFactory {
    private final CarMarksEnum[] marks;
    private final EngineDisplacementEnum[] engineSize;
    private final CarColorsEnum[] carColors;
    private final WheelSizeEnum[] wheelSize;
    private final CarStorage factoryStorage;
    private final CarColorChangeService carColorChangeService;
    private final WheelSizeChangeService wheelSizeChangeService;
    private final CarOptionsChangeService carOptionsChangeService;

    public CarStorage getFactoryStorage() {
        return factoryStorage;
    }

    public CarMarksEnum[] getMarks() {
        return marks;
    }

    public EngineDisplacementEnum[] getEngineSize() {
        return engineSize;
    }

    public CarColorsEnum[] getCarColors() {
        return carColors;
    }

    public WheelSizeEnum[] getWheelSize() {
        return wheelSize;
    }

    public CarFactory(CarMarksEnum[] marks,
                      EngineDisplacementEnum[] engineSize,
                      CarColorsEnum[] carColors,
                      WheelSizeEnum[] wheelSize,
                      CarColorChangeService carColorChangeService,
                      WheelSizeChangeService wheelSizeChangeService,
                      CarOptionsChangeService carOptionsChangeService) {
        this.marks = marks;
        this.engineSize = engineSize;
        this.carColors = carColors;
        this.wheelSize = wheelSize;
        this.factoryStorage = new CarStorage();
        this.carColorChangeService = carColorChangeService;
        this.wheelSizeChangeService = wheelSizeChangeService;
        this.carOptionsChangeService = carOptionsChangeService;
    }

    //вывод параметров с которыми завод может создать автомобиль
    public void printFactoryOpportunity() {
        System.out.println("Список возможных параметров машины для создания на заводе:");
        System.out.println("Марки: " + Arrays.toString(marks));
        System.out.println("Цвета: " + Arrays.toString(carColors));
        System.out.println("Объем двигателя: " + Arrays.toString(engineSize));
        System.out.println("Размер колес: " + Arrays.toString(wheelSize));
    }

    //создание новой машины на заводе и помещение на склад
    //машины создаются в базовой комплектации, без опций
    private void createCar(String[] carArgs) {
    }

    //проверка можно ли создать машину с переданными параметрами на заводе
    boolean checkCarArgsToCreateOnFactory(String[] carArgs) {
        boolean trigger = false;
        for (CarMarksEnum present : marks) {
            if (present.equals(CarMarksEnum.valueOf(carArgs[0]))) {
                trigger = true;
                break;
            }
        }
        if (!trigger) {
            return trigger;
        }
        trigger = false;
        for (EngineDisplacementEnum present : this.engineSize) {
            if (present.equals(EngineDisplacementEnum.valueOf(carArgs[1]))) {
                trigger = true;
                break;
            }
        }
        if (!trigger) {
            return trigger;
        }
        trigger = false;
        for (CarColorsEnum present : this.carColors) {
            if (present.equals(CarColorsEnum.valueOf(carArgs[2]))) {
                trigger = true;
                break;
            }
        }
        if (!trigger) {
            return trigger;
        }
        trigger = false;
        for (WheelSizeEnum present : this.wheelSize) {
            if (present.equals(WheelSizeEnum.valueOf(carArgs[3]))) {
                trigger = true;
                break;
            }
        }
        return trigger;
    }

    Car findCarInStorage(String[] carArgs) {
        int tempIndex = -1;
        tempIndex = factoryStorage.searchCarInTheStorage(carArgs);
        if (tempIndex >= 0) {
            return factoryStorage.moveCarFromStorageByIndex(tempIndex);
        }
        return null;
    }

    void changeCarForRequest(Car car, CarColorsEnum color, WheelSizeEnum wheelSize) {
        if (!car.getColor().equals(color)) {
            carColorChangeService.changeCarColor(car, color);
        }
        if (!car.getWheelSize().equals(wheelSize)) {
            wheelSizeChangeService.changeWheelSize(car, wheelSize);
        }
    }

    void addCarOptionsForRequest(Car car, CarOptionsEnum[] carOptions) {
        for (int i = 0; i < carOptions.length; i++) {
            carOptionsChangeService.addCarOption(car, carOptions[i]);
        }
    }

    //поиск машины на складе или создание новой машины согласно заказу из автосалона
    public abstract Car dealershipRequest(String[] carArgs); /*{
        System.out.println("Заказ от автосалона: марка " + cars.CarMarksEnum.valueOf(carArgs[0]).name() +
                ", размер двигателя " + cars.EngineDisplacementEnum.valueOf(carArgs[1]).name() +
                ", цвет " + cars.CarColorsEnum.valueOf(carArgs[2]).name() +
                ", размер колес " + cars.WheelSizeEnum.valueOf(carArgs[3]).name() +
                (carArgs.length == 4 ? "." : (", список опций: " +
                        Arrays.toString(Arrays.copyOfRange(carArgs, 4, carArgs.length)))));

        if (checkCarArgsToCreateOnFactory(mark, engineSize, color, wheelSize)) {
            cars.Car car = findCarInStorage(mark, engineSize, color, wheelSize);
            if (car != null) {
                if (carOptions.length == 0) {
                    System.out.println("Найдена машина на складе завода, перемещение...");
                    return car;
                } else {
                    System.out.println("Найдена машина на складе завода, добавляем опции и перемещаем...");
                    addCarOptionsForRequest(car, carOptions);
                    return car;
                }

            }
            car = findCarInStorage(mark, engineSize);
            if (car != null) {
                System.out.println("Найдена машина на складе завода под изменение согласно заказу...");
                changeCarForRequest(car, color, wheelSize);
                if (carOptions.length > 0) {
                    addCarOptionsForRequest(car, carOptions);
                }
                return car;
            }
            System.out.println("Создание новой машины...");
            createCar(new String[]{mark.name(), engineSize.name(), color.name(), wheelSize.name()});
            if (carOptions.length > 0) {
                addCarOptionsForRequest(factoryStorage.getStorage()[factoryStorage.getStorage().length - 1], carOptions);
            }
            return factoryStorage.moveCarFromStorageByIndex(factoryStorage.getStorage().length - 1);
        } else {
            System.out.println("Данный завод не может создать такую машину.");
        }
        return null;
    }*/
}
