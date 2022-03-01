public class CarColorChangeService {

    public void changeCarColor(Car car, CarColorsEnum carColors) {
        if (car.getColor().equals(carColors)) {
            System.out.println("Текущий цвет и так соответствует, покраска не нужна.");
            return;
        }
        car.setColor(carColors);
        System.out.println("Машина перекрашена. Новый цвет - " + carColors.name());
    }
}
