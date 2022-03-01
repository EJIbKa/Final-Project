public class CarOptionsChangeService {

    public void addCarOption(Car car, CarOptionsEnum carOptions) {
        for (CarOptionsEnum present : car.getCarOptions()) {
            if (present.equals(carOptions)) {
                System.out.println("Такая опция уже есть в машине!");
                return;
            }
        }
        var tempArrayCarOptions = new CarOptionsEnum[car.getCarOptions().length + 1];
        System.arraycopy(car.getCarOptions(), 0, tempArrayCarOptions, 0, car.getCarOptions().length);
        tempArrayCarOptions[tempArrayCarOptions.length - 1] = carOptions;
        car.setCarOptions(tempArrayCarOptions);
        System.out.println("Опция " + carOptions.name() + " добавлена на автомобиль.");
    }

    public void removeCarOption(Car car, CarOptionsEnum carOptions) {
        for (int i = 0; i < car.getCarOptions().length; i++) {
            if (car.getCarOptions()[i].equals(carOptions)) {
                var tempArrayCarOptions = new CarOptionsEnum[car.getCarOptions().length - 1];
                if (i > 0) {
                    System.arraycopy(car.getCarOptions(), 0, tempArrayCarOptions, 0, i);
                }
                System.arraycopy(car.getCarOptions(), i + 1, tempArrayCarOptions, i, tempArrayCarOptions.length - i);
                car.setCarOptions(tempArrayCarOptions);
                System.out.println("Опция " + carOptions.name() + " демонтирована с автомобиля.");
                return;
            }
        }
        System.out.println("Такой опции на автомобиле не найдено.");
    }
}
