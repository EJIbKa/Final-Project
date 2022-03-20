package services;

import cars.Car;
import cars.CarOptionsEnum;

public class RemoveCarOptionsService implements Changeable {

    @Override
    public void change(Car car, ChangeApplication changeApplication) {
        for (CarOptionsEnum present : changeApplication.getCarOptions()) {
            if (car.getCarOptions().remove(present)) {
                System.out.println("Опция " + present.name() + " демонтирована с автомобиля.");
            }
        }
    }
}
