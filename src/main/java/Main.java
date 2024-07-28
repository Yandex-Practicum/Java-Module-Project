import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Race race = new Race();
        Car[] carArray = new Car[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("- Введите название машины №" + (i + 1) + ":");
            String newName = scanner.next();
            while (true) {
                System.out.println("- Введите скорость машины №" + (i + 1) + ":");
                int newVelocity;
                while (true) {
                    if (scanner.hasNextInt()) {
                        newVelocity = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Введите скорость в формате целого числа.");
                        scanner.next();
                    }
                }
                if ((newVelocity >= 0) && (newVelocity <= 250)) {
                    carArray[i] = new Car(newName, newVelocity);
                    race.newLeaderDefining(carArray[i]);
                    break;
                } else {
                    System.out.println("Неверная скорость, скорость должна быть от 0 до 250 км/ч.");
                }

            }
        }

        System.out.println("Самая быстрая машина: " + race.leaderName);
    }
}