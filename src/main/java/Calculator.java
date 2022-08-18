import java.util.Locale;
import java.util.Scanner;


public class Calculator {
    int peopleCount;
    public Calculator(int peopleCount) {
        this.peopleCount = peopleCount; //создали конструктор
    }
    public void doCalculate() {
        String allProduct = "";
        double totalPrice = 0;
        String userResponce;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US); //без принудительной смены locale программа не принимала "." в качестве разделителя.
        while (true) {
            System.out.println("Введите название товара: ");
            allProduct += scanner.next() + "\n";
            System.out.println("Введите цену товара в формате \"'рубли.копейки' [10.45, 11.40]\": ");
            while (true) {
                double i = scanner.nextDouble();// бесконечный цикл проверки, цена может быть 0 если это комплимент от заведения.
                if (i >= 0) {
                    totalPrice += i;
                    break;
                }
                System.out.println("Вы ввели отрицательно число! Пожалуйста, попробуйте снова!");
            }
            System.out.println("Товар успешно добавлен!\n" +
                    "Хотите добавить еще один товар?\n" +
                    "Для продолжения введите любой символ, для завершения введите завершить (регистр не важен):");
            userResponce = scanner.next();
            if (userResponce.equalsIgnoreCase("завершить")) {
                System.out.println("Добавленные товары:\n" + allProduct);
                System.out.printf("Каждый должен заплатить %.2f %s.%n",
                        totalPrice / (double) peopleCount, correctEnding((int) totalPrice / peopleCount));
                break;
            }

        }
    }
    public String correctEnding (int totalPriceInt) {
        int preLastDigit = totalPriceInt % 100 / 10; //Решаем проблему с препоследней единицей в числе, например 11, 1011 и тд.
        if (preLastDigit == 1) {
            return "рублей";
        }
        switch (totalPriceInt % 10) {
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
}
