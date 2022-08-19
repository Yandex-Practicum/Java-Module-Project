import java.util.Locale;
import java.util.Scanner;

public class Calculate {
    String menu = ""; // список продуктов с ценами
    double sum = 0; // общий счет
    String sumForEach; // сумма на каждого

    public Calculate() {
    }

    // записываем в menu список продуктов с ценами
    public void recordItems(Item item) {
        menu += String.format("%s %.2f\n", item.name, item.price);
    }

    // вычисление суммы на каждого гостя
    public String check(int count) {
        sumForEach = String.format("%.2f", sum / count);
        return sumForEach;
    }

    // сумма всех товаров
    public void sumPrice(double price) {
        sum += price;
    }

    // метод вычисления правильного формата рублей
    public String formatRuble() {
        //первая цифра перед точкой
        char charLastNumber = sumForEach.charAt(sumForEach.length() - 4);
        int lastNumber = Character.getNumericValue(charLastNumber);

        //если перед точкой больше одного знака
        if (sumForEach.length() >= 5) {
            //вторая цифра перед точкой
            char charPreLastNumber = sumForEach.charAt(sumForEach.length() - 5);
            int preLastNumber = Character.getNumericValue(charPreLastNumber);

            if (preLastNumber != 1 && lastNumber == 1) {
                return "рубль";
            } else if (preLastNumber != 1 && lastNumber >= 2 && lastNumber <= 4) {
                return "рубля";
            } else {
                return "рублей";
            }

            //если перед точкой один знак
        } else {
            if (lastNumber == 1) {
                return "рубль";
            } else if (lastNumber >= 5 || lastNumber == 0) {
                return "рублей";
            } else {
                return "рубля";
            }
        }
    }

    // определение корректного ввода стоимости товара
    public double countRightNumber() {
        while (true) {
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
            try {
                double price = scanner.nextDouble();
                if (price < 0) {
                    throw new Exception();
                }
                return price;
            } catch (Exception e) {
                System.out.println("Введите корректную стоимость в формате 'рубли.копейки' [10.45, 11.40]\"");
            }
        }
    }
}
