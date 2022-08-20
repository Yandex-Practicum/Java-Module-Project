import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    private final int countPeople;
    private double sum;
    private double price;

    private final List<Product> goods = new ArrayList<>();

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

        while (true) {
            System.out.println("Введите название товара");

            String name = sc.next();

            System.out.println("Введите цену товара");

            while (true) {

                Scanner scDouble = new Scanner(System.in).useLocale(Locale.US);

                if (scDouble.hasNextDouble()){

                    price = scDouble.nextDouble();
                    sum += price;
                    break;

                }else{
                    System.out.println("Неверный ввод, введите цену в формате 00.00");
                }


            }

            Product product = new Product(name, price);
            goods.add(product);
            System.out.println("Товар добавлен, введи Завершить, чтобы закончить ввод");
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
