package factories;

import cars.*;

import java.util.ArrayList;
import java.util.List;

public class CarStorage {
    private final List<Car> storage;

    public CarStorage() {
        this.storage = new ArrayList<>();
    }

    public List<Car> getStorage() {
        return storage;
    }

    public Integer searchCarInTheStorage(String[] carArgs) {
        if (storage.size() > 0) {
            if (storage.get(0) instanceof TruckCar) {
                return searchTruckCar(carArgs);
            }
            if (storage.get(0) instanceof BusCar) {
                return searchBusCar(carArgs);
            }
            if (storage.get(0) instanceof PassengerCar) {
                return searchDefaultPassengerCar(carArgs);
            }
            if (storage.get(0) instanceof SpecialCar) {
                return searchSpecialCar(carArgs);
            }
        }
        return -1;
    }

    public Integer searchCarInTheStorageToChange(String[] carArgs) {
        if (storage.size() > 0) {
            if (storage.get(0) instanceof TruckCar) {
                return searchTruckCar(carArgs);
            }
            if (storage.get(0) instanceof BusCar) {
                return searchBusCar(carArgs);
            }
            if (storage.get(0) instanceof PassengerCar) {
                return searchDefaultPassengerCar(carArgs);
            }
            if (storage.get(0) instanceof SpecialCar) {
                return searchSpecialCar(carArgs);
            }
        }
        return -1;
    }

    private Integer searchSpecialCar(String[] carArgs) {
        SpecialCar car;
        for (int i = 0; i < storage.size(); i++) {
            car = (SpecialCar) storage.get(i);
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
        PassengerCar car;
        for (int i = 0; i < storage.size(); i++) {
            car = (PassengerCar) storage.get(i);
            if (carArgs.length >= 6) {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getColor().equals(CarColorsEnum.valueOf(carArgs[2])) &&
                        car.getWheelSize().equals(WheelSizeEnum.valueOf(carArgs[3])) &&
                        car.getPassengerCarBody().equals(PassengerCarBodyEnum.valueOf(carArgs[5]))) {
                    return i;
                }
            } else {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getPassengerCarBody().equals(PassengerCarBodyEnum.valueOf(carArgs[3]))) {
                    return i;
                }
            }
        }
        return -1;
    }

    private Integer searchBusCar(String[] carArgs) {
        BusCar car;
        for (int i = 0; i < storage.size(); i++) {
            car = (BusCar) storage.get(i);
            if (carArgs.length >= 7) {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
                        car.getColor().equals(CarColorsEnum.valueOf(carArgs[2])) &&
                        car.getWheelSize().equals(WheelSizeEnum.valueOf(carArgs[3])) &&
                        car.getOverallDimensions().equals(OverallDimensionsEnum.valueOf(carArgs[5])) &&
                        car.getBusAppointment().equals(BusAppointmentEnum.valueOf(carArgs[6]))) {
                    return i;
                }
            } else {
                if (car.getMark().equals(CarMarksEnum.valueOf(carArgs[0])) &&
                        car.getEngineSize().equals(EngineDisplacementEnum.valueOf(carArgs[1])) &&
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
        for (int i = 0; i < storage.size(); i++) {
            car = (TruckCar) storage.get(i);
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
        synchronized (storage) {
            storage.add(car);
        }
    }

    public Car moveCarFromStorageByIndex(Integer index) {
        synchronized (storage) {
            return storage.remove(index.intValue());
        }
    }
}
