package factories;

import Dealership.DealershipApplication;
import cars.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CarStorage {
    private final List<Car> storage;

    public CarStorage() {
        this.storage = new ArrayList<>();
    }

    public List<Car> getStorage() {
        synchronized (storage) {
            return storage;
        }
    }

    public int searchCarInTheStorage(DealershipApplication dealershipApplication) {
        int indexOfCar;
        synchronized (storage) {
            indexOfCar = searchSplitter(dealershipApplication, true);
            if (indexOfCar < 0) {
                indexOfCar = searchSplitter(dealershipApplication, false);
                if (indexOfCar > -1) {
                    System.out.println("Найдена машина на складе завода под изменение согласно заказу...");
                }
            } else {
                System.out.println("Найдена машина на складе завода, перемещение...");
            }
        }
        return indexOfCar;
    }

    private int searchSplitter(DealershipApplication dealershipApplication, boolean fullSearchOrForChange) {
        try {
            if (storage.size() > 0) {
                switch (dealershipApplication.getCarType()) {
                    case BUS_CAR -> {
                        return searchBusCar(dealershipApplication, fullSearchOrForChange);
                    }
                    case TRUCK_CAR -> {
                        return searchTruckCar(dealershipApplication, fullSearchOrForChange);
                    }
                    case SPECIAL_CAR -> {
                        return searchSpecialCar(dealershipApplication, fullSearchOrForChange);
                    }
                    case PASSENGER_CAR -> {
                        return searchPassengerCar(dealershipApplication, fullSearchOrForChange);
                    }
                }
            }
        } catch (NullPointerException | NoSuchElementException ignored) {}
        return -1;
    }

    private Stream<Car> filterForAllCars(Stream<Car> stream,
                                         DealershipApplication dealershipApplication,
                                         boolean firstSearch) {
        if (firstSearch) {
            return stream.filter( car ->
                    car.getMark().equals(dealershipApplication.getMark())
                            && car.getColor().equals(dealershipApplication.getColor())
                            && car.getWheelSize().equals(dealershipApplication.getWheelSize())
                            && car.getEngineSize().equals(dealershipApplication.getEngineSize()));
        }
        return stream.filter( car -> car.getMark().equals(dealershipApplication.getMark())
                        && car.getEngineSize().equals(dealershipApplication.getEngineSize()));
    }

    private int searchBusCar(DealershipApplication dealershipApplication, boolean firstSearch)
            throws NullPointerException, NoSuchElementException {
        return storage.indexOf(
                filterForAllCars(storage.stream(), dealershipApplication, firstSearch)
                        .map(car -> (BusCar) car)
                        .filter(busCar -> busCar.getBusAppointment().equals(dealershipApplication.getBusAppointment())
                                && busCar.getOverallDimensions().equals(dealershipApplication.getOverallDimensions()))
                        .findFirst()
                        .get()
        );
    }

    private int searchPassengerCar(DealershipApplication dealershipApplication, boolean firstSearch)
            throws NullPointerException, NoSuchElementException{
        return storage.indexOf(
                filterForAllCars(storage.stream(), dealershipApplication, firstSearch)
                        .map(car -> (PassengerCar) car)
                        .filter(passengerCar -> passengerCar.getPassengerCarBody().equals(
                                dealershipApplication.getPassengerCarBody()
                        ))
                        .findFirst()
                        .get()
        );
    }

    private int searchSpecialCar(DealershipApplication dealershipApplication, boolean firstSearch)
            throws NullPointerException, NoSuchElementException{
        return storage.indexOf(
                filterForAllCars(storage.stream(), dealershipApplication, firstSearch)
                        .map(car -> (SpecialCar) car)
                        .filter(specialCar -> specialCar.getSpecialCarType().equals(
                                dealershipApplication.getSpecialCarType()
                        ))
                        .findFirst()
                        .get()
        );
    }

    private int searchTruckCar(DealershipApplication dealershipApplication, boolean firstSearch)
            throws NullPointerException, NoSuchElementException{
        return storage.indexOf(
                filterForAllCars(storage.stream(), dealershipApplication, firstSearch)
                        .map(car -> (TruckCar) car)
                        .filter(truckCar -> truckCar.getCarryingCapacity().equals(
                                dealershipApplication.getCarryingCapacity()
                        ))
                        .findFirst()
                        .get()
        );
    }

    public void addCarToStorage(Car car) {
        synchronized (storage) {
            storage.add(car);
        }
    }

    public Car moveCarFromStorageByIndex(int index) {
        synchronized (storage) {
            return storage.remove(index);
        }
    }
}
