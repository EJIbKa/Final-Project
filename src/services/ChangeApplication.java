package services;

import cars.CarColorsEnum;
import cars.CarOptionsEnum;
import cars.WheelSizeEnum;

public class ChangeApplication {
    private CarColorsEnum carColor;
    private WheelSizeEnum wheelSize;
    private CarOptionsEnum[] carOptions;

    public ChangeApplication(CarColorsEnum carColor) {
        this.carColor = carColor;
    }

    public ChangeApplication(WheelSizeEnum wheelSize) {
        this.wheelSize = wheelSize;
    }

    public ChangeApplication(CarOptionsEnum[] carOptions) {
        this.carOptions = carOptions;
    }

    public CarColorsEnum getCarColor() {
        return carColor;
    }

    public WheelSizeEnum getWheelSize() {
        return wheelSize;
    }

    public CarOptionsEnum[] getCarOptions() {
        return carOptions;
    }
}
