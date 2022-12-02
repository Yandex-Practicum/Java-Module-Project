import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    public static String summablyud = "";
    public static float sum = 0;

    public static float calc() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название блюда: ");
            String blyudo = scanner.next();
            summablyud += blyudo + "\n";
            float stoimost;
            while (true) {
                Scanner scan = new Scanner(System.in);
                scan.useLocale(Locale.US);
                System.out.println("Введите стоимость блюда в формате 'рубли.копейки' : ");
                if (scan.hasNextFloat()) {
                    stoimost = scan.nextFloat();
                        break;
                }
            }
            System.out.println("Блюдо '" + blyudo + "' удачно добавлено!");
            sum += stoimost;
            System.out.format("Текущая сумма: " + "%.2f.\n", sum);
            System.out.println("Хотите добавить еще одно блюдо? Если нет, напишите 'завершить' ");
            String abc = scanner.next();
                if (abc.equalsIgnoreCase("Завершить")) {
                    break;
                } else {
                    continue;
                }
        }
        System.out.println("Добавленные товары:\n" + summablyud);
        return sum;
    }

    public static String rubles(double a) {
        if (a % 100 >= 5 && a % 100 <= 20) {
            return "рублей";
        } else if (a % 10 == 1) {
            return "рубль";
        } else if (a % 10 >= 2 && a % 10 <= 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}