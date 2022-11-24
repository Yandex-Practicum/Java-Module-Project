import java.util.Locale;
import java.util.Scanner;
public class Calc {

    public static void Calculator() {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        double count = 0;
        boolean cont = true;
        //создаем бесконечный цикл вызова товара
        while (cont) {
            System.out.println("Введите название товара");
            String res = scanner.next();
            // устанавливаем слово для остановки цикла
            if (res.toUpperCase(Locale.ROOT).equals("ЗАВЕРШИТЬ")) {
                cont = false;
            } else {
                result += res + "\n";
                System.out.println("Введите стоимость в формате: \'рубли.копейки'  ");
                String temp = scanner.next();
                // проверка на то чтобы пользователь вводил только int стоимость
                if (!checkPrice(temp)) {
                    System.out.println("Некорректные данные");
                } else {
                    System.out.println("Товар " + res + " успешно добавлен");
                    count += Double.parseDouble(temp);
                }
            }
        }
        //Вывод будет одинаковый вне зависимости от того, какие данные укажет пользователь

        double bill = count / Users.users;

        String resultMessage = ("Общая стоимость: %.2f RUB");
        System.out.println(String.format(resultMessage, count));

        System.out.println("Сумма на одного человека: " + String.format("%.2f", bill) + " " + rubles(bill));
    }
    //реализация проверки
    public static boolean checkPrice(String next) {
        boolean isDigit = true;
        for (int i = 0; i < next.length(); i++) {
            if (!Character.isDigit(next.charAt(i)) && next.charAt(i) != '.') {
                isDigit = false;
                break;
            }
        }
        return isDigit;

    }
    public static String rubles(double a) {
        int rub = (int) Math.floor(a);
        if (rub % 100 > 5 && rub <= 20) {
            return "рублей";
        } else if (rub % 10 == 1) {
            return "рубль";
        } else if (rub % 10 > 1 && rub % 10 < 5) {
            return "рубля";
        }
        return "рублей";
    }

}

