import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        String name = "default";
        double speed = -1;
        Car car = new Car(name, speed);
        for (int i = 0; i < 3; i++) {
            System.out.println("Название автомобиля " + (i + 1) + ":");
            name = scanner.next();
            do {
                System.out.println("Скорость автомобиля " + (i + 1) + ":");
                String speedStr = scanner.next();
                try {
                    speed = Double.parseDouble(speedStr);
                } catch (Exception e) {
                    speed = -1;
                }
                car = new Car(name, speed);
                if (!car.isCorrectSpeed()) System.out.println("Неправильная скорость!");
            } while (!car.isCorrectSpeed());
            race.addCar(car);
        }
        Car winner = race.getWinner();
        System.out.println("Самый быстрый автомобиль -> " + winner.getName());
    }
}