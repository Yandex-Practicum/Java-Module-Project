import java.util.Scanner;

public class People {

    public static int persons;

    public static void howMany(){
        System.out.println("На скольких человек необходимо разделить счёт?");
        while(true) {
            Scanner scanner = new Scanner(System.in);
            boolean hasInt = scanner.hasNextInt();
            if(hasInt) {
                int hasPersons = scanner.nextInt();
                if (hasPersons > 1) {
                    persons = hasPersons;
                    return;
                } else {
                    System.out.println("Ошибка! Введите корректное число.");
                }
            }
            else {
                System.out.println("Ошибка! Введите корректное число.");
            }
        }
    }
}
