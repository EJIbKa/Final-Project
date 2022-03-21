package factories;

import Dealership.DealershipApplication;
import cars.*;
import services.Services;
import java.time.Year;
import java.util.Arrays;

public abstract class CarFactory {
    private final CarMarksEnum[] marks;
    private final EngineDisplacementEnum[] engineSize;
    private final CarColorsEnum[] carColors;
    private final WheelSizeEnum[] wheelSize;
    private final CarStorage factoryStorage;
    private final Services services;

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
                      Services services) {
        this.marks = marks;
        this.engineSize = engineSize;
        this.carColors = carColors;
        this.wheelSize = wheelSize;
        this.factoryStorage = new CarStorage();
        this.services = services;
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
    protected void createCar(DealershipApplication dealershipApplication) {
        switch (dealershipApplication.getCarType()) {
            case PASSENGER_CAR -> factoryStorage.addCarToStorage(
                    new PassengerCar(
                            dealershipApplication.getMark(),
                            Year.now(),
                            dealershipApplication.getEngineSize(),
                            dealershipApplication.getColor(),
                            dealershipApplication.getWheelSize(),
                            dealershipApplication.getPassengerCarBody()
                    )
            );
            case SPECIAL_CAR -> factoryStorage.addCarToStorage(
                    new SpecialCar(
                            dealershipApplication.getMark(),
                            Year.now(),
                            dealershipApplication.getEngineSize(),
                            dealershipApplication.getColor(),
                            dealershipApplication.getWheelSize(),
                            dealershipApplication.getSpecialCarType()
                    )
            );
            case TRUCK_CAR -> factoryStorage.addCarToStorage(
                    new TruckCar(
                            dealershipApplication.getMark(),
                            Year.now(),
                            dealershipApplication.getEngineSize(),
                            dealershipApplication.getColor(),
                            dealershipApplication.getWheelSize(),
                            dealershipApplication.getCarryingCapacity()
                    )
            );
            case BUS_CAR -> factoryStorage.addCarToStorage(
                    new BusCar(
                            dealershipApplication.getMark(),
                            Year.now(),
                            dealershipApplication.getEngineSize(),
                            dealershipApplication.getColor(),
                            dealershipApplication.getWheelSize(),
                            dealershipApplication.getOverallDimensions(),
                            dealershipApplication.getBusAppointment()
                    )
            );
        }
    }

    //проверка можно ли создать машину с переданными параметрами на заводе
    protected boolean checkCarArgsToCreateOnFactory(DealershipApplication dealershipApplication) {
        return Arrays.stream(marks).anyMatch(p -> p.equals(dealershipApplication.getMark()))
                && Arrays.stream(engineSize).anyMatch(p -> p.equals(dealershipApplication.getEngineSize()))
                && Arrays.stream(carColors).anyMatch(p -> p.equals(dealershipApplication.getColor()))
                && Arrays.stream(wheelSize).anyMatch(p -> p.equals(dealershipApplication.getWheelSize()));
    }

    protected Car findCarInStorage(DealershipApplication dealershipApplication) {
        int carIndex = factoryStorage.searchCarInTheStorage(dealershipApplication);
        if (carIndex >= 0) {
            return factoryStorage.moveCarFromStorageByIndex(carIndex);
        }
        return null;
    }

    protected void changeCarForRequest(Car car, DealershipApplication dealershipApplication) {
        if (!car.getColor().equals(dealershipApplication.getColor())) {
            services.changeCarColor(car, dealershipApplication.getColor());
        }
        if (!car.getWheelSize().equals(dealershipApplication.getWheelSize())) {
            services.changeWheelSize(car, dealershipApplication.getWheelSize());
        }
    }

    protected void addCarOptionsForRequest(Car car, DealershipApplication dealershipApplication) {
        services.addCarOptions(car, dealershipApplication.getCarOptions().toArray(new CarOptionsEnum[0]));
    }

    //поиск машины на складе или создание новой машины согласно заказу из автосалона
    public Car dealershipRequest(DealershipApplication dealershipApplication) {
        if (checkCarArgsToCreateOnFactory(dealershipApplication)) {
            Car car = findCarInStorage(dealershipApplication);
            if (car != null) {
                changeCarForRequest(car, dealershipApplication);
                if (dealershipApplication.getCarOptions().size() != 0) {
                    System.out.println("Добавляем опции и перемещаем...");
                    addCarOptionsForRequest(car, dealershipApplication);
                }
                return car;
            }
            System.out.println("Создание новой машины...");
            createCar(dealershipApplication);
            if (dealershipApplication.getCarOptions().size() != 0) {
                addCarOptionsForRequest(factoryStorage.getStorage().get(factoryStorage.getStorage().size() - 1),
                        dealershipApplication);
            }
            return factoryStorage.moveCarFromStorageByIndex(factoryStorage.getStorage().size() - 1);
        } else {
            System.out.println("Данный завод не может создать такую машину.");
        }
        return null;
    }
}
