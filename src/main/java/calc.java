import java.util.Scanner;

public class calc {

    public static double calculator() {
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);
        for (String i = "Добавленные товары:"; 1 != 0; i = i) {
            for (double j = 0; j >= 0; j = j) {
                System.out.println("Пожалуйста, введите название товара.");
                String itemName = scan2.nextLine();
                System.out.println("Пожалуйста, введите цену товара в формате 'рубли.копейки' [10.45, 11.40]");
                double itemCost = scan3.nextDouble();
                System.out.println("Товар добавлен в список.");
                i = i + "\n" + itemName + " " + itemCost;
                j = j + itemCost;
                System.out.println("Хотите ли вы завершить покупки?");
                String answer = scan4.nextLine();
                String stopWord = "Завершить";
                if (answer.equalsIgnoreCase(stopWord)) {
                    System.out.println(i);
                    double summ = Math.floor(j) % 10;
                    int remainder = (int) summ;
                    switch (remainder) {
                        case 1:
                            System.out.println(String.format("Общая сумма покупок: %.2f рубль", j));
                            break;
                        case 2:
                            System.out.println(String.format("Общая сумма покупок: %.2f рубля", j));
                            break;
                        case 3:
                            System.out.println(String.format("Общая сумма покупок: %.2f рубля", j));
                            break;
                        case 4:
                            System.out.println(String.format("Общая сумма покупок: %.2f рубля", j));
                            break;
                        default:
                            System.out.println(String.format("Общая сумма покупок: %.2f рублей", j));
                            break;
                    }
                    return j;
                }
            }
        }
    }
}