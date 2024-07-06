import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        System.out.println("Введите 3 машины:");
        for (int i = 1; i < 4; i++) {
            System.out.println("Имя машины №" + i + ": ");
            String name = scanner.next();
            while (true) {
                System.out.println("Скорость машины №" + i + ": ");
                if (scanner.hasNextInt()) {
                    int speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {
                        race.newLeader(new Car(name, speed));
                        break;
                    } else {
                        System.out.println("Скорость машины должна быть в интервале от 0 до 250.") ;
                    }
                } else {
                    System.out.println("Скорость машины должна быть в интервале от 0 до 250.") ;
                    scanner.next();
                }
            }
        }
        scanner.close();
        System.out.println("Самая быстрая машина: " + race.leader);
    }
}