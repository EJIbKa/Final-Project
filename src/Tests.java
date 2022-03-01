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
        carArgs[3] = WheelSizeEnum.INCH_20.name();
        carArgs[4] = CarryingCapacityEnum.MEDIUM.name();
        carArgs[5] = CarOptionsEnum.BACKUP_CAMERA.name();
        carArgs[6] = CarOptionsEnum.HEATED_SEATS.name();
//        Tests tests = new Tests();
//        System.out.println(tests.createtruckcar(carArgs));
        CarColorChangeService carColorChangeService = new CarColorChangeService();
        WheelSizeChangeService wheelSizeChangeService = new WheelSizeChangeService();
        CarOptionsChangeService carOptionsChangeService = new CarOptionsChangeService();
        var factory = new TruckCarFactory(
                new CarMarksEnum[]{CarMarksEnum.BMW},
                new EngineDisplacementEnum[]{EngineDisplacementEnum.MEDIUM_CAPACITY},
                new CarColorsEnum[]{CarColorsEnum.BLACK},
                new WheelSizeEnum[]{WheelSizeEnum.INCH_20},
                carColorChangeService,
                wheelSizeChangeService,
                carOptionsChangeService,
                new CarryingCapacityEnum[]{CarryingCapacityEnum.MEDIUM});
        System.out.println(factory.dealershipRequest(carArgs));

    }

    public TruckCar createtruckcar(String[] carArgs) {
        System.out.println("Заказ от автосалона: марка " + CarMarksEnum.valueOf(carArgs[0]).name() +
                ", размер двигателя " + EngineDisplacementEnum.valueOf(carArgs[1]).name() +
                ", цвет " + CarColorsEnum.valueOf(carArgs[2]).name() +
                ", размер колес " + WheelSizeEnum.valueOf(carArgs[3]).name() +
                ", грузоподъемность " + CarryingCapacityEnum.valueOf(carArgs[4]) +
                (carArgs.length == 5 ? "." : (", список опций: " +
                        Arrays.toString(Arrays.copyOfRange(carArgs, 5, carArgs.length)))));
        if (carArgs.length == 5) {
            return new TruckCar(CarMarksEnum.valueOf(carArgs[0]),
                    Calendar.getInstance().get(Calendar.YEAR),
                    EngineDisplacementEnum.valueOf(carArgs[1]),
                    CarColorsEnum.valueOf(carArgs[2]),
                    WheelSizeEnum.valueOf(carArgs[3]),
                    CarryingCapacityEnum.valueOf(carArgs[4]));
        } else if (carArgs.length > 5) {
            CarOptionsEnum[] carOptions = new CarOptionsEnum[carArgs.length - 5];
            for (int i = 5; i < carArgs.length; i++) {
                carOptions[i - 5] = CarOptionsEnum.valueOf(carArgs[i]);
            }
            return new TruckCar(CarMarksEnum.valueOf(carArgs[0]),
                    Calendar.getInstance().get(Calendar.YEAR),
                    EngineDisplacementEnum.valueOf(carArgs[1]),
                    CarColorsEnum.valueOf(carArgs[2]),
                    WheelSizeEnum.valueOf(carArgs[3]),
                    CarryingCapacityEnum.valueOf(carArgs[4]),
                    carOptions);
        } else {
            System.out.println("Ошибка создания!");
        }
        return null;
    }
}
