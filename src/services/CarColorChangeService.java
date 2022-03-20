package services;

import cars.Car;

public class CarColorChangeService implements Changeable {

    @Override
    public void change(Car car, ChangeApplication changeApplication) {
        if (car.getColor().equals(changeApplication.getCarColor())) {
            System.out.println("Текущий цвет и так соответствует, покраска не нужна.");
            return;
        }
        car.setColor(changeApplication.getCarColor());
        System.out.println("Машина перекрашена. Текущий цвет - " + car.getColor());
    }
}
