public class Dealership {
    private final CarColorChangeService carColorChangeService;
    private final WheelSizeChangeService wheelSizeChangeService;
    private final CarOptionsChangeService carOptionsChangeService;
    private final CarFactory factory;

    public Dealership(CarColorChangeService carColorChangeService,
                      WheelSizeChangeService wheelSizeChangeService,
                      CarOptionsChangeService carOptionsChangeService,
                      CarFactory factory) {
        this.carColorChangeService = carColorChangeService;
        this.wheelSizeChangeService = wheelSizeChangeService;
        this.carOptionsChangeService = carOptionsChangeService;
        this.factory = factory;
    }

    public Car changeSomethingInCar(Car car, CarColorsEnum carColors) {
        carColorChangeService.changeCarColor(car, carColors);
        return car;
    }

    public Car changeSomethingInCar(Car car, WheelSizeEnum wheelSize) {
        wheelSizeChangeService.changeWheelSize(car, wheelSize);
        return car;
    }

    public Car changeSomethingInCar(Car car, CarColorsEnum carColors, WheelSizeEnum wheelSize) {
        carColorChangeService.changeCarColor(car, carColors);
        wheelSizeChangeService.changeWheelSize(car, wheelSize);
        return car;
    }

    public Car addOptionsInCar(Car car, CarOptionsEnum... carOptions) {
        if (carOptions.length > 0) {
            for (int i = 0; i < carOptions.length; i++) {
                carOptionsChangeService.addCarOption(car, carOptions[i]);
            }
        }
        return car;
    }

    public Car removeOptionsInCar(Car car, CarOptionsEnum... carOptions) {
        if (carOptions.length > 0) {
            for (int i = 0; i < carOptions.length; i++) {
                carOptionsChangeService.removeCarOption(car, carOptions[i]);
            }
        }
        return car;
    }

    public Car clientOrder(CarMarksEnum mark, EngineDisplacementEnum engineSize, CarColorsEnum color,
                           WheelSizeEnum wheelSize, CarOptionsEnum... carOptions) {
        return null;//factory.dealershipRequest(mark, engineSize, color, wheelSize, carOptions);
    }
}
