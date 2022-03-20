package services;

import cars.Car;
import cars.CarOptionsEnum;

public class AddCarOptionsService implements Changeable {

    @Override
    public void change(Car car, ChangeApplication changeApplication) {
        for (CarOptionsEnum present : changeApplication.getCarOptions()) {
            if (car.getCarOptions().add(present)) {
                System.out.println("Опция " + present.name() + " добавлена на автомобиль.");
            }
        }
    }
}
