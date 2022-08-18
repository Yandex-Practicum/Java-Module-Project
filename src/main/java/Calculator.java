import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private int countPeople;
    private double sum;

    private List<Product> goods = new ArrayList<>();

    Calculator(int countPeople) {

        this.countPeople = countPeople;

    }

    public void total() {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.println("Общая сумма " + decimalFormat.format(sum)+ " " + Product.GetRubleAddition(sum));
        System.out.println("С человека " + decimalFormat.format(sum / countPeople) + " " +
                Product.GetRubleAddition(sum  / countPeople));

    }

    public void start(Scanner sc) {

        final String REGEX = "\\d+.\\d{2}";

        while (true) {
            System.out.println("Введите название товара");

            String name = sc.next();
            String input;
            System.out.println("Введите цену товара");
            while (true) {
                input = sc.next();
                if (input.matches(REGEX)) {
                    break;
                } else {
                    System.out.println("Неверный ввод, введите цену в формате 00.00");
                }

            }
            Double price = Double.parseDouble(input);
            sum += price;
            Product product = new Product(name, price);
            goods.add(product);
            System.out.println("Товар добавлен, добавить еще товар?");
            String check = sc.next();
            if (check.equalsIgnoreCase("Завершить")) {

                break;

            }


        }
    }

    public void result() {
        System.out.println("Добавленные товары: ");
        for (Product product : goods
        ) {
            product.info();


        }


    }


}
