import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();

            int quantityOfPersons = scanner.nextInt();

            if (quantityOfPersons == 1) {
                System.out.println("Тебе грустно и одиноко, нечем заняться? Занимайся Джаббой!");
                break;
            } else if (quantityOfPersons > 1) {
                System.out.println("Итак, " + quantityOfPersons + " человек харчевали...");
                Item.calculate();
                System.out.println(Item.sum / quantityOfPersons);
            } else if (quantityOfPersons == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Введите корректное количество гостей");
            }

        }
    }

    public static void printMenu() {
        System.out.println("Добрый день!");
        System.out.println("На скольких человек вы хотите разделить счёт?");
        System.out.println("Введите целое значение от 1 и выше");
        System.out.println("Введите 0, для того, чтобы выйти из программы");
    }
}
