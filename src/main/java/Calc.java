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
        // к сожалению я не смог разобраться как сделать вывод рублей связанных с падежом и цифрой
        String resultMessage = ("Общая стоимость: %.2f RUB");
        System.out.println(String.format(resultMessage, count));
        String resultMessage1 = ("Каждый заплатит: %.2f RUB");
        System.out.println(String.format(resultMessage1,count/Users.users));

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
}




