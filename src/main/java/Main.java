import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();

            String quantityOfPersons = scanner.nextLine();
            int number = -1;

            try {
                number = Integer.parseInt(quantityOfPersons);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели что-то не то... Давайте ещё раз.");
            }

            if (number == 1) {
                System.out.println("Тебе грустно и одиноко, нечем заняться? Занимайся Джаббой!");
            } else if (number > 1) {
                System.out.println("Итак, вас " + quantityOfPersons + ". И вы харчевали...");
                Item.calculate();
                double pricePerPerson = Item.sum / number;
                System.out.println("\nКаждый из посетителей должен заплатить " + String.format("%.2f", pricePerPerson) + CaseEnding.setEnding(pricePerPerson) + ".");
                System.out.println("Вычисления завершены. Выход.");
                break;
            } else if (number == 0) {
                System.out.println("Выход, потому что кое-кто нажал ноль.");
                break;
            } else {
                System.out.println("Введите положительное число гостей.");
            }

        }
    }

    public static void printMenu() {
        System.out.println("\nДобрый день!");
        System.out.println("На скольких человек вы хотите разделить счёт?");
        System.out.println("Пожалуйста, введите количество гостей - от 1 и выше.");
        System.out.println("Или введите 0 для того, чтобы выйти из программы.");
    }
}
