import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPeople; // количество людей

        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт");
            numberPeople = scanner.nextInt();

            if (numberPeople > 1) {
                break;
            } else if (numberPeople <= 1) { //Если пользователь вводит 1
                System.out.println("Это некорректное значение для подсчёта, повторите ввод");
            }

        }

        System.out.println("Сейчас все сделаем");
        Calculator Calculator = new Calculator(numberPeople);

        double prise;
        while (true) {
            System.out.println("Введите название продукта");
            String product = scanner.next();

            System.out.println("Введитестоимость в формате: 'рубли.копейки' 10.45, 11.40");
            prise = scanner.nextDouble();

            Calculator.calcul(new added(product, prise));
            System.out.println("Хотите добавить ещё один товар? Введите команду завершить, для прекращения ввода. Для продлежния введите любое слово или символ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }

        rubleOptions RubleOptions = new rubleOptions();
        double value = Calculator.devideSum;
        String result = String.format("%.2f",value);
        System.out.println(Calculator.cart + "\n" + "К оплате с человека  " + result + RubleOptions.rubles(prise));
    }
        }






        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости


