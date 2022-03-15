import java.util.Arrays;
import java.util.Calendar;

public class Tests {
    public static void main(String[] args) {
//        var car1 = new DefaultPassengerCar(
//                CarMarksEnum.MERCEDES_BENZ,
//                2020,
//                EngineDisplacementEnum.MEDIUM_CAPACITY,
//                CarColorsEnum.GREEN,
//                WheelSizeEnum.INCH_20,
//                5,
//                PassengerCarBodyEnum.SEDAN);
//        System.out.println(car1);
        String[] carArgs = new String[7];
        carArgs[0] = CarMarksEnum.BMW.name();
        carArgs[1] = EngineDisplacementEnum.MEDIUM_CAPACITY.name();
        carArgs[2] = CarColorsEnum.BLACK.name();
        carArgs[3] = WheelSizeEnum.INCH_18.name();
        carArgs[4] = SpecialCarTypeEnum.EXCAVATOR.name();
        carArgs[5] = CarOptionsEnum.BACKUP_CAMERA.name();
        carArgs[6] = CarOptionsEnum.HEATED_SEATS.name();
        CarColorChangeService carColorChangeService = new CarColorChangeService();
        WheelSizeChangeService wheelSizeChangeService = new WheelSizeChangeService();
        CarOptionsChangeService carOptionsChangeService = new CarOptionsChangeService();
        var factory = new SpecialCarFactory(
                new CarMarksEnum[]{CarMarksEnum.BMW, CarMarksEnum.AUDI},
                new EngineDisplacementEnum[]{EngineDisplacementEnum.MEDIUM_CAPACITY},
                new CarColorsEnum[]{CarColorsEnum.BLACK, CarColorsEnum.BLUE},
                new WheelSizeEnum[]{WheelSizeEnum.INCH_20, WheelSizeEnum.INCH_18},
                carColorChangeService,
                wheelSizeChangeService,
                carOptionsChangeService,
                new SpecialCarTypeEnum[]{SpecialCarTypeEnum.EXCAVATOR});
        System.out.println(factory.dealershipRequest(carArgs));

    }

}
