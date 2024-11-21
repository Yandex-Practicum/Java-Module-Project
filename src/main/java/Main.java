import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter amount of racers");
        int amount = scanner.nextInt();

        System.out.println("Now enter racers' names and speed\nOn a separate lines");

        Car[] cars = create(amount);

        Race race = new Race(cars);

        race.start();


//        for (Car car: cars) System.out.printf("Name: %s\nSpeed: %d\n", car.name, car.speed);


    }

    private static Car[] create(int amount) {
        Car[] cars = new Car[amount];

        for (int i = 1; i < amount + 1; ++i) {
            System.out.printf("%d racer's name and speed:\n", i);
            String name = scanner.next();
            String speed;
            int intSpeed;
            while (true) {
                speed = scanner.next();

                try {
                    intSpeed = Integer.parseInt(speed);
                } catch (NumberFormatException e) {
                    System.out.println("Speed should be a number between 0 and 250\nTry again");
                    continue;
                }

                if (0 < intSpeed && intSpeed <= 250) {
                    break;
                } else {
                    System.out.println("Speed should be between 0 and 250\nTry again");
                }
            }
            cars[i - 1] = new Car(name, intSpeed);
        }

        return cars;
    }
}