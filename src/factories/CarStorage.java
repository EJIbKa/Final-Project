package factories;

import cars.*;

public class CarStorage {
    private Car[] storage;

    public CarStorage() {
        this.storage = new Car[0];
    }

    public Car[] getStorage() {
        return storage;
    }

    public Integer searchCarInTheStorage(String[] carArgs) {
        if (storage.length > 0) {
            if (storage[0] instanceof TruckCar) {
                return searchTruckCar(carArgs);
            }
            if (storage[0] instanceof BusCar) {
                return searchBusCar(carArgs);
            }
            if (storage[0] instanceof DefaultPassengerCar) {
                return searchDefaultPassengerCar(carArgs);
            }
            if (storage[0] instanceof SpecialCar) {
                return searchSpecialCar(carArgs);
            }
        }
        return -1;
    }

    public Integer searchCarInTheStorageToChange(String[] carArgs) {
        if (storage.length > 0) {
            if (storage[0] instanceof TruckCar) {
                return searchTruckCar(carArgs);
            }
            if (storage[0] instanceof BusCar) {
                return searchBusCar(carArgs);
            }
            if (storage[0] instanceof DefaultPassengerCar) {
                return searchDefaultPassengerCar(carArgs);
            }
            if (storage[0] instanceof SpecialCar) {
                return searchSpecialCar(carArgs);
            }
        }
        return -1;
    }

    private Integer searchSpecialCar(String[] carArgs) {
        SpecialCar car;
        for (int i = 0; i < storage.length; i++) {
            car = (SpecialCar) storage[i];
            if (carArgs.length >= 5) {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getColor().equals(CarColorsEnum.valueOf(carArgs[2])) &&
                        car.getWheelSize().equals(WheelSizeEnum.valueOf(carArgs[3])) &&
                        car.getSpecialCarType().equals(SpecialCarTypeEnum.valueOf(carArgs[4]))) {
                    return i;
                }
            } else {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getSpecialCarType().equals(SpecialCarTypeEnum.valueOf(carArgs[2]))) {
                    return i;
                }
            }
        }
        return -1;
    }

    private Integer searchDefaultPassengerCar(String[] carArgs) {
        DefaultPassengerCar car;
        for (int i = 0; i < storage.length; i++) {
            car = (DefaultPassengerCar) storage[i];
            if (carArgs.length >= 6) {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getColor().equals(CarColorsEnum.valueOf(carArgs[2])) &&
                        car.getWheelSize().equals(WheelSizeEnum.valueOf(carArgs[3])) &&
                        car.getPersonCapacity().equals(Integer.parseInt(carArgs[4])) &&
                        car.getPassengerCarBody().equals(PassengerCarBodyEnum.valueOf(carArgs[5]))) {
                    return i;
                }
            } else {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getPersonCapacity().equals(Integer.parseInt(carArgs[2])) &&
                        car.getPassengerCarBody().equals(PassengerCarBodyEnum.valueOf(carArgs[3]))) {
                    return i;
                }
            }
        }
        return -1;
    }

    private Integer searchBusCar(String[] carArgs) {
        BusCar car;
        for (int i = 0; i < storage.length; i++) {
            car = (BusCar) storage[i];
            if (carArgs.length >= 7) {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getColor().equals(CarColorsEnum.valueOf(carArgs[2])) &&
                        car.getWheelSize().equals(WheelSizeEnum.valueOf(carArgs[3])) &&
                        car.getPersonCapacity().equals(Integer.parseInt(carArgs[4])) &&
                        car.getOverallDimensions().equals(OverallDimensionsEnum.valueOf(carArgs[5])) &&
                        car.getBusAppointment().equals(BusAppointmentEnum.valueOf(carArgs[6]))) {
                    return i;
                }
            } else {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getPersonCapacity().equals(Integer.parseInt(carArgs[2])) &&
                        car.getOverallDimensions().equals(OverallDimensionsEnum.valueOf(carArgs[3])) &&
                        car.getBusAppointment().equals(BusAppointmentEnum.valueOf(carArgs[4]))) {
                    return i;
                }
            }
        }
        return -1;
    }

    private Integer searchTruckCar(String[] carArgs) {
        TruckCar car;
        for (int i = 0; i < storage.length; i++) {
            car = (TruckCar) storage[i];
            if (carArgs.length >= 5) {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getColor().equals(CarColorsEnum.valueOf(carArgs[2])) &&
                        car.getWheelSize().equals(WheelSizeEnum.valueOf(carArgs[3])) &&
                        car.getCarryingCapacity().equals(CarryingCapacityEnum.valueOf(carArgs[4]))) {
                    return i;
                }
            } else {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getCarryingCapacity().equals(CarryingCapacityEnum.valueOf(carArgs[2]))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void addCarToStorage(Car car) {
        var tempArrayStorage = new Car[storage.length + 1];
        System.arraycopy(storage, 0, tempArrayStorage, 0, storage.length);
        tempArrayStorage[tempArrayStorage.length - 1] = car;
        this.storage = tempArrayStorage;
    }

    public Car moveCarFromStorageByIndex(Integer index) {
        var tempArrayStorage = new Car[storage.length - 1];
        if (index > 0) {
            System.arraycopy(storage, 0, tempArrayStorage, 0, index);
        }
        System.arraycopy(storage, index + 1, tempArrayStorage, index, tempArrayStorage.length - index);
        var tempCar = storage[index];
        this.storage = tempArrayStorage;
        return tempCar;
    }
}
