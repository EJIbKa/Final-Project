package services;

import cars.Car;

public class WheelSizeChangeService implements Changeable {

    @Override
    public void change(Car car, ChangeApplication changeApplication) {
        if (car.getWheelSize().equals(changeApplication.getWheelSize())) {
            System.out.println("Текущий размер колес совпадает, замена не нужна.");
            return;
        }
        car.setWheelSize(changeApplication.getWheelSize());
        System.out.println("Колеса на машине заменены. Текущий размер - " + car.getWheelSize());
    }
}
