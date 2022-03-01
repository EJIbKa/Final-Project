public class WheelSizeChangeService {

    public void changeWheelSize(Car car, WheelSizeEnum wheelSize) {
        if (car.getWheelSize().equals(wheelSize)) {
            System.out.println("Текущий размер колес совпадает, замена не нужна.");
            return;
        }
        car.setWheelSize(wheelSize);
        System.out.println("Колеса на машине заменены. Текущий размер - " + wheelSize);
    }
}
