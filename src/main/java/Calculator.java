import java.util.InputMismatchException;
import java.util.Scanner;
public class Calculator {

    static void calculate(int people) {
        String food = "";
        double price = 0.0;

        while (true) {
            System.out.println("Введите название продукта, для выхода введите [Завершить]");
            Scanner scanner = new Scanner(System.in);
            String inputFood = scanner.next();

            if (inputFood.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                System.out.println("Введите цену в формате [руб,коп]");
                double inputPrice = 0;
                try {inputPrice = scanner.nextDouble();}
                catch (InputMismatchException e) {
                System.out.println("Неверное значение");
            }
                food = food + inputFood + "\n";
                price = price + inputPrice;
            }

        }
        int rouble = (int) Math.round(price);
        System.out.println("Добавленные товары:\n" + food);
        String message = "Каждый человек должен заплатить %.2f" + " " + Main.declination(rouble);
        System.out.println(String.format(message, (price / people)));
    }

}


