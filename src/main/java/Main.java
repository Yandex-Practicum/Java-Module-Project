//import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String name;
        String test1 = "Завершить";
        String test2 = "Complete";
        double price;
        double summ;
        Calculator Calc = new Calculator();

        do {
            System.out.println("На сколько человек необходимо разделить счёт ?");
            n = sc.nextInt();
            if (n == 1) System.out.println("Нет смысла ничего считать и делить при 1 человеке");
            else if (n < 1) System.out.println("Количество людей должно быть больше 1");
            else System.out.println(String.format("Будем делить на %d чел.", n));
        } while (n < 2);

        System.out.println("Что будем покупать ?");

        while(true) {
            System.out.println("Введите название товара или слово \"Завершить\" (\"Complete\")");
            name = sc.next();
             if (name.equalsIgnoreCase(test1) || name.equalsIgnoreCase(test2))
                break;
            do {
                System.out.println("Введите стоимость товара в формате рубли.копейки, если копеек нет их можно не вводить");
                price = sc.nextDouble();
                if (price < 0.0)
                    System.out.println("Ошибка!! Товар не может стоить меньше 0.00 руб.");
                else if (price == 0.0)
                    System.out.println("Обратите внимаение! Бесплатный товар, но мы его добавим");
            } while(price < 0);
            Calc.calculate(name, price);
            System.out.println(String.format("Добавлен товар \"%s\" по цене %.2f, каждому теперь нужно внести уже по %.2f руб.\n", name, price, Calc.sum / n));
            System.out.println("Если больше не хотите добавлять товар наберите слово \"Завершить\" или \"Complete\"");
            System.out.println("Английское можно ввести в любом регистре, но русское именно так, как написано\n");
        }
        System.out.println(String.format("\nДобавленные товары:\n%s\nОбщая сумма: %.2f руб. на %d чел.\nКаждому нужно внести по %.2f руб.\n", Calc.list, Calc.sum, n, Calc.sum / n));
    }
    private static class Calculator {
        double sum;
        String list = "";
        void Calculator() {
            this.sum = 0;
         }
        void calculate(String name, double price) {
            this.sum += price;
            this.list += String.format("%s по цене %.2f\n", name, price);
        }
    }
}
