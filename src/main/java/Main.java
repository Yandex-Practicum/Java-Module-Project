import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static String name;
    public static String speed;
    public static ArrayList<Car> park = new ArrayList<>();
    public static short participantes = 3; //good name. It's not a mistake, I'm from Latinoamerica

    public static void main(String[] args) {

        System.out.println("Приветствую на гонке 24 часа Ле Мана!");
        /*Цикл, в котором добавляются новые экземпляры автомобилей. По желанию можно изменить значение
        * переменной participantes и добавлять сколько угодно авто. Я бы мог сделать это по вводу пользователя
        * но задание того не требует, поэтому не писал лишнего*/
        for (int i = 0; i<participantes; i++){
            Car car = new Car(tryToName(i+1), tryToAccelerate(i+1));
            park.add(car);
            Race.setLeader();
            System.out.println(Race.getLeader());
        }

        System.out.println("Самая быстрая машина: " + Race.getLeader());
        /*System.out.println("Самая быстрая машина - " + Race.getLeader() + " его дистанция " + Race.getLeadersDistance());     // Можно и так*/
    }
    //Метод проверяет, число ли это (целое), что передаётся в метод
    public static boolean isDigit(String myAwesomeString) {
        try {
            int myAwesomeInt = Integer.parseInt(myAwesomeString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //Метод для проверки корректности введённой скорости
    public static boolean isCorrectSpeed(String myAwesomeString) {
        try {
            int myAwesomeInt = Integer.parseInt(myAwesomeString);
            return (myAwesomeInt >= 0) & (myAwesomeInt <= 250);
        } catch (NumberFormatException e) {
            return false;                                                       //Если не число, то в любом случае false
        }
    }
    //Метод для присвоения наименования автомобиля
    public static String tryToName(int i){
        //Here we initialize cars name
        System.out.println("— Введите название машины №" + i + ":");
        name = scanner.nextLine();
        return name;
    }
    //Метод для установки скорости автомобиля
    public static int tryToAccelerate(int i) {
        //Here we initialize cars speed
        System.out.println("— Введите скорость машины №" + i + ":");
        do {
            speed = scanner.nextLine();
            if (!isDigit(speed)) {                                              //Проверка, число ли это вообще
                System.out.println("Введите целое значение");
            } else if (isCorrectSpeed(speed)){                                  //В нужном ли диапазоне скорость
                return Integer.parseInt(speed);                                 //Лучшая строка в мире
            } else System.out.println("Введите корректное значение от 0 до 250");
        } while (!isCorrectSpeed(speed));
        return 0;
    }
}

