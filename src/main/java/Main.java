import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int people;

        while (true) {
                System.out.println("Введите количество гостей, которые будут делить счёт.");
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    people = scanner.nextInt();
                } else {
                    System.out.println("Пожалуйста, введите число!");
                    continue;
                }
                if (people <= 1) {
                    System.out.println("Это некорректное значение для подсчёта.");
                    continue;
                } else {
                    System.out.println("Отлично");
                    break;
                }
        }
        float sum = Calculator.calc();
        float onepersonbill = sum / people;
        double a = Math.floor(onepersonbill);
        String rubles = Calculator.rubles(a);
        System.out.println("Цена для одного человека: " + String.format("%.2f ", onepersonbill) + rubles);
    }
}