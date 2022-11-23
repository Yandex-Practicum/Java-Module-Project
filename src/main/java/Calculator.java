import java.util.*;

public class Calculator {
    public static float calculate() {
        Scanner console = new Scanner(System.in);
        float sum=0.00f;

        System.out.println("Введите товар");
        String product = console.nextLine();
        float price = priceChecking();
        sum=sum+price;
        String cheque = String.format("Добавленные товары:\n" + product + "    %.2f", price) + " руб.";
        System.out.println("Товар успешно добавлен. Завершить? (Введите Завершить либо любой другой символ для продолжения)");

        while(true) {
            if (console.next().equalsIgnoreCase("Завершить")) {
                System.out.println(cheque);
                break;
            }
            else {
                System.out.println("Введите товар");
                console.nextLine();
                product = console.nextLine();
                price = priceChecking();
                sum=sum+price;
                cheque = String.format(cheque + "\n" + product + "    %.2f", price) + " руб.";
                System.out.println("Товар успешно добавлен. Завершить? (Введите Завершить либо любой другой символ для продолжения)");
            }
        }
        return sum;
    }

    public static float priceChecking () {
        System.out.println("Введите цену товара в формате 00,00 (рубли,копейки)");
        float price;
        Scanner console = new Scanner(System.in);

        while (!(console.hasNextFloat())) {
            System.out.println("Требуется именно число в формате 00,00 (рубли,копейки) или 00 (рубли)");
            console.next();
        }
        price=console.nextFloat();

        while (!(price > 0)) {
            System.out.println("Стоимость товара должна быть больше нуля");
            price=console.nextFloat();
        }

        return price;
    }
}
