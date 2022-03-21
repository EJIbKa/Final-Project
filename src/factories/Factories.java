package factories;

import Dealership.DealershipApplication;
import cars.Car;

public class Factories {
    private final BusCarFactory busCarFactory;
    private final PassengerCarFactory passengerCarFactory;
    private final SpecialCarFactory specialCarFactory;
    private final TruckCarFactory truckCarFactory;

    public Factories(BusCarFactory busCarFactory,
                     PassengerCarFactory passengerCarFactory,
                     SpecialCarFactory specialCarFactory,
                     TruckCarFactory truckCarFactory) {
        this.busCarFactory = busCarFactory;
        this.passengerCarFactory = passengerCarFactory;
        this.specialCarFactory = specialCarFactory;
        this.truckCarFactory = truckCarFactory;
    }

    public Car dealershipRequest(DealershipApplication dealershipApplication) {
        switch (dealershipApplication.getCarType()) {
            case BUS_CAR -> {
                return busCarFactory.dealershipRequest(dealershipApplication);
            }
            case TRUCK_CAR -> {
                return truckCarFactory.dealershipRequest(dealershipApplication);
            }
            case SPECIAL_CAR -> {
                return specialCarFactory.dealershipRequest(dealershipApplication);
            }
            case PASSENGER_CAR -> {
                return passengerCarFactory.dealershipRequest(dealershipApplication);
            }
            default -> {
                return null;
            }
        }
    }
}
