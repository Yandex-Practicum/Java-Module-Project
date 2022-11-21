import java.util.Scanner;

public class Users {
    public static int users;

    public static void persons() {
        Scanner scanner = new Scanner(System.in);
        //вводим бесконечный цикл, чтобы пользователь мог ввести правильное значение

        while (true) {
            System.out.println("Выберите количество человек");

            if (scanner.hasNextInt()) {
                users = scanner.nextInt();
                if (users>1) {
                    System.out.println("Колличество пользователей = " + users);
                    break;
                }
                if(users<=1){
                    System.out.println("Введите корректные данные. Значение должно быть больше 1");
                }
            } else {
                System.out.println("Введите корректные данные");
                scanner.nextLine();
            }
        }

    }

}
