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
                double inputPrice = scanner.nextDouble();
                food = food + inputFood + "\n";

                if (inputPrice <= 0){
                    System.out.println("Неверная цена");
                } else {
                    price = price + inputPrice;
                }
            }

        }
        int rouble = (int) Math.round(price);
        System.out.println("Добавленные товары:\n" + food);
        String message = "Каждый человек должен заплатить %.2f" + " " + Main.declination(rouble);
        System.out.println(String.format(message, (price / people)));
    }

}
