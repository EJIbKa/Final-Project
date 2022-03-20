package services;

import cars.Car;
import cars.CarColorsEnum;
import cars.CarOptionsEnum;
import cars.WheelSizeEnum;

public class Services {
    private final CarColorChangeService carColorChangeService;
    private final WheelSizeChangeService wheelSizeChangeService;
    private final AddCarOptionsService addCarOptionsService;
    private final RemoveCarOptionsService removeCarOptionsService;

    public Services() {
        this.carColorChangeService = new CarColorChangeService();
        this.wheelSizeChangeService = new WheelSizeChangeService();
        this.addCarOptionsService = new AddCarOptionsService();
        this.removeCarOptionsService = new RemoveCarOptionsService();
    }

    public void changeCarColor(Car car, CarColorsEnum carColors) {
        carColorChangeService.change(car, new ChangeApplication(carColors));
    }

    public void changeWheelSize(Car car, WheelSizeEnum wheelSize) {
        wheelSizeChangeService.change(car, new ChangeApplication(wheelSize));
    }

    public void addCarOptions(Car car, CarOptionsEnum...carOptions) {
        addCarOptionsService.change(car, new ChangeApplication(carOptions));
    }

    public void removeCarOptions(Car car, CarOptionsEnum...carOptions) {
        removeCarOptionsService.change(car, new ChangeApplication(carOptions));
    }


}
