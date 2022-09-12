
import java.util.Scanner;

public class Calculate {

    public static int product(double person) {

        String food = "";
        double price = 0.0;
        String itog = "";

        while (true) {
            System.out.println("Для добавления товара введите название продукта\nДля завершения программы введите \"Завершить\"");
            Scanner scanner = new Scanner(System.in);

            String inputFood = scanner.next();

            if (inputFood.equals("Завершить")) {

                itog = String.format("%.2f", price / person);
                System.out.println("Покупка завершена, " + String.format("%.0f", person) + " персоны заплатят по " + itog + " рублей");

            } else {
                System.out.println("Введите стоимость продукта в формате \"'рубли.копейки' [10.45, 11.40]\"");
                float inputPrice = (float) scanner.nextDouble();

                food = food + "\n" + inputFood;
                price = price + inputPrice;
                System.out.println("Вы успешно добавили продукт:" + food + "\nИтог: " + String.format("%.2f", price) + " рублей");


            }
        }
    }
}









        



