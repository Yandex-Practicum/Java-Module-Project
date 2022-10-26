import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Calculate {
    static String toComplete = "завершить";

    List<String> menuList = new LinkedList<>();
    List<Double> priceList = new ArrayList<>();
    String menu;
    double price = 0;
    double sum;

    public void product() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название товара : ");
            menu = scanner.next();
            menuList.add(menu);
            System.out.println("Введите цену товара в формате 'рубли.копейки' [10.45, 11.40] :");

            while (!scanner.hasNextDouble()) {
                System.out.println("Введите корректное значение :");
                scanner.next();
            }

            price = scanner.nextDouble();
            if (price > 0) {
                priceList.add(price);
                sum = sum + price;
                System.out.println("Товар успешно добавлен! ");
            }

                while (price <= 0) {
                    if (price <= 0) {
                        System.out.println("Ошибка цена не может быть отрицательной,ошибка введите цену заного");
                        price = scanner.nextDouble();
                        if (price > 0) {
                            priceList.add(price);
                            sum = sum + price;
                            System.out.println("Товар успешно добавлен! ");
                            break;
                        }
                    }
                }
                System.out.println("Если хотите продолжить введите - любой символ,если хотите остановиться введите 'завершить' ");
                menu = scanner.next();
                if (menu.equalsIgnoreCase(toComplete)) {
                    break;
                }
        }
    }


    public String GetRubleAddition(double num) {
        int numToInt = (int) num;
        double preLastDigit = num % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }
        switch (numToInt % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

    public String GetHumanAdddition(int num) {

        double preLastDigit = num % 100 / 10;
        if (preLastDigit == 1) {
            return "Человек";
        }
        switch (num % 10) {
            case 1:
            case 2:
            case 3:
            case 4:
                return "Человека";
            default:
                return "рублей";
        }
    }
}





