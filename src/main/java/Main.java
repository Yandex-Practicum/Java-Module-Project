import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название автомобиля " + (i + 1) + ":");
            String name = scanner.next();

            int speed;
            do {
                try {
                    System.out.println("Введите скорость автомобиля " + name + " (от 1 до 250 км/ч):");
                    speed = scanner.nextInt();
                    if (speed <= 0 || speed > 250) {
                        System.out.println("Скорость должна быть от 1 до 250 км/ч");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Пожалуйста, введите целое число.");
                    scanner.next();
                    speed = 0;
                }
            } while (speed <= 0 || speed > 250);

            Car car = new Car(name, speed);
            race.calculateDistance(car);
        }

        Car leader = race.getLeader();
        System.out.println("Самая быстрая машина: " + leader.getName());
    }
}