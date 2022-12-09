import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPeople;

        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт");
            numberPeople = scanner.nextInt();

            if (numberPeople > 1) {
                break;
            } else if (numberPeople <= 1) {
                System.out.println("Это некорректное значение для подсчёта, повторите ввод");
            }

        }

        System.out.println("Сейчас все сделаем");
        Calculator Calculator = new Calculator(numberPeople);

        double prise;
        while (true) {
            System.out.println("Введите название продукта");
            String product = scanner.next();
          try {
              System.out.println("Введите стоимость в формате: 'рубли.копейки' 10.45, 11.40");
              prise = scanner.nextDouble();

            Calculator.calcul(new added(product, prise));
            System.out.println("Хотите добавить ещё один товар? Введите команду завершить, для прекращения ввода. Для продлежния введите любое слово или символ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
          } catch(Exception e) {
              System.out.println(e.getMessage());
          }
        }

        rubleOptions RubleOptions = new rubleOptions();
        double value = Calculator.devideSum;
        String result = String.format("%.2f",value);
        System.out.println(Calculator.cart + "\n" + "К оплате с человека  " + result + RubleOptions.rubles(value));
    }
        }
        // Привет, не могу исправить заглавную букву класса, выдает ошибку. Такое ощущение, что андроид студио логает.






        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости


