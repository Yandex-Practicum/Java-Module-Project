import java.io.IOError;
import java.io.IOException;
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
            n = ReadInt(sc, "На сколько человек необходимо разделить счёт ?");

            if (n == 1) System.out.println("Нет смысла ничего считать и делить при 1 человеке");
            else if (n < 1) System.out.println("Количество людей должно быть больше 1");
            else System.out.println(String.format("Будем делить на %d %s", n, OutPers(n)));

        } while (n < 2);

        System.out.println("Что будем покупать ?");

        while(true) {
            System.out.println("Введите название товара или слово \"Завершить\" (\"Complete\")");
            name = sc.next();
            if (name.equalsIgnoreCase(test1) || name.equalsIgnoreCase(test2))
                break;
            if (name.isEmpty())
                System.out.println("Обратите внимаение! Вы не ввели пустое имя, видимо не хотите раскрывать имя товара...");
            do {
                price = ReadDouble(sc, "Введите стоимость товара в формате рубли.копейки, если копеек нет их можно не вводить");
                if (price < 0.0)
                    System.out.println("Ошибка!! Товар не может стоить меньше 0 рублей 00 копеек");
                else if (price == 0.0)
                    System.out.println("Обратите внимание! Бесплатный товар, но мы его добавим");
            } while(price < 0);
            Calc.calculate(name, price);
            System.out.println(String.format("Добавлен товар \"%s\" по цене %.2f, каждому теперь нужно внести уже по %s\n",
                    name, price, OutMoneySum(Calc.sum / n, 2)));
            System.out.println("Если больше не хотите добавлять товар наберите слово \"Завершить\" или \"Complete\"");
            System.out.println("Английское можно ввести в любом регистре, но русское именно так, как написано\n");
        }
        System.out.println(String.format("\nДобавленные товары:\n%s\nОбщая сумма: %s на %d %s\nКаждому нужно внести по %s\n",
                Calc.list, OutMoneySum(Calc.sum, 1), n, OutPers(n), OutMoneySum(Calc.sum / n, 2)));
    }

    // Вывод денежной суммы в формате
    // для var == 1: хх рубль/рубля/рублей xx копейка/копейки/копеек
    // для var == 2: хх рублю/рубля/рублей xx копейке/копейки/копеек
    private static String OutMoneySum(double sum, int var) {
        int rub = (int)sum;
        int kop = (int)((sum - rub) * 100 + 0.5);
        return String.format("%d %s %d %s", rub, OutRub(rub, var), kop, OutKop(kop, var));
    }

    private static String OutRub(int rub, int var) {
        String Out = "рубль";       // именительный падеж
        if (var == 2)
            Out = "рублю";          // дательный падеж
        int p1 = rub % 100;
        if ((p1 >= 5) && (p1 <= 20))    // Обработка исключений от 11 до 14: рублей
            Out = "рублей";
        else {
            int p2 = p1 % 10;
            if ((p2 >= 5) || (p2 == 0))    // Обработка оканчивающихся от 5 до 9 и на 0: рублей
                Out = "рублей";
            else if (p2 >= 2)
                Out = "рубля";           // Обработка оканчивающихся от 2 до 4: рубля
        }
        return Out;                     // При 1 остается в единственном числе: рубль/рублю
    }

    private static String OutKop(int kop, int var) {
        String Out = "копейка";     // именительный падеж
        if (var == 2)
            Out = "копейке";          // дательный падеж

        int p1 = kop % 100;
        if ((p1 >= 5) && (p1 <= 20))    // Обработка исключений от 11 до 14: копеек
            Out = "копеек";
        else {
            int p2 = p1 % 10;
            if ((p2 >= 5) || (p2 == 0))    // Обработка оканчивающихся от 5 до 9 и на 0: копеек
                Out = "копеек";
            else if (p2 >= 2)
                Out = "копейки";           // Обработка оканчивающихся от 2 до 4: копейки
        }
        return Out;                     // При 1 остается в единственном числе: копейка/копейке
    }

    // Вывод в формате: (на) хх человека/человек
    private static String OutPers(int persons) {
        String Out = "человека";        // Разделить на 1, 2, 3, 4 человека
        int p1 = persons % 100;
        if ((p1 >= 5) && (p1 <= 20))    // исключение от 11 до 14 человек
            Out = "человек";
        else {
            int p2 = p1 % 10;
            if ((p2 >= 5) || (p2 == 0))
                Out = "человек";
        }
        return Out;                     // При последней цифре 1, 2, 3, 4 (кроме 11..14) остается значение по умолчанию: человека
    }

    private static class Calculator {
        double sum = 0;
        String list = "";
        void calculate(String name, double price) {
            this.sum += price;
            this.list += String.format("%s по цене %.2f\n", name, price);
        }
    }

    private static int ReadInt(Scanner sc, String prompt) {
        int ret;

        System.out.println(prompt);
        while(!sc.hasNextInt()) {
            sc.next();
            System.out.println("Это явно не целое число. Попробуйте снова. Вводите целое число !");
            System.out.println(prompt);
        }
        ret = sc.nextInt();
        return ret;
    }

    private static double ReadDouble(Scanner sc, String prompt) {
        double ret;

        System.out.println(prompt);
        while(!sc.hasNextDouble()) {
            sc.next();
            System.out.println("Это явно не число. Возможно, вместо точки нужно поставить запятую\nПопробуйте еще раз");
            System.out.println(prompt);
        }
        System.out.println();
        ret = sc.nextDouble();
       return ret;
    }
}
