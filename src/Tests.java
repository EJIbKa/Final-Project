import cars.*;
import factories.DefaultPassengerCarFactory;
import services.CarColorChangeService;
import services.CarOptionsChangeService;
import services.WheelSizeChangeService;

public class Tests {
    public static void main(String[] args) {
//        var car1 = new cars.DefaultPassengerCar(
//                cars.CarMarksEnum.MERCEDES_BENZ,
//                2020,
//                cars.EngineDisplacementEnum.MEDIUM_CAPACITY,
//                cars.CarColorsEnum.GREEN,
//                cars.WheelSizeEnum.INCH_20,
//                5,
//                cars.PassengerCarBodyEnum.SEDAN);
//        System.out.println(car1);
        String[] carArgs = new String[8];
        carArgs[0] = CarMarksEnum.BMW.name();
        carArgs[1] = EngineDisplacementEnum.MEDIUM_CAPACITY.name();
        carArgs[2] = CarColorsEnum.BLACK.name();
        carArgs[3] = WheelSizeEnum.INCH_18.name();
        carArgs[4] = String.valueOf(5);
        carArgs[5] = PassengerCarBodyEnum.SEDAN.name();
        carArgs[6] = CarOptionsEnum.BACKUP_CAMERA.name();
        carArgs[7] = CarOptionsEnum.HEATED_SEATS.name();
        CarColorChangeService carColorChangeService = new CarColorChangeService();
        WheelSizeChangeService wheelSizeChangeService = new WheelSizeChangeService();
        CarOptionsChangeService carOptionsChangeService = new CarOptionsChangeService();
        var factory = new DefaultPassengerCarFactory(
                new CarMarksEnum[]{CarMarksEnum.BMW, CarMarksEnum.AUDI},
                new EngineDisplacementEnum[]{EngineDisplacementEnum.MEDIUM_CAPACITY},
                new CarColorsEnum[]{CarColorsEnum.BLACK, CarColorsEnum.BLUE},
                new WheelSizeEnum[]{WheelSizeEnum.INCH_20, WheelSizeEnum.INCH_18},
                carColorChangeService,
                wheelSizeChangeService,
                carOptionsChangeService,
                new Integer[]{5 ,6},
                new PassengerCarBodyEnum[]{PassengerCarBodyEnum.SEDAN, PassengerCarBodyEnum.HATCHBACK});
        System.out.println(factory.dealershipRequest(carArgs));

    }

}
