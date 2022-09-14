import java.util.Scanner;

public class Calculate {

    public static void product(double person) {

        String food = "";
        double price = 0.0;

        while (true) {
            System.out.println("Для добавления товара введите название продукта\nДля завершения программы введите \"Завершить\"");
            Scanner scanner = new Scanner(System.in);
            String inputFood = scanner.next();
            double itog = 0;

            if (inputFood.equalsIgnoreCase("Завершить")) {
                itog = (int) (price / person);
                System.out.println("Покупка завершена, " + String.format("%.0f", person) + " персоны заплатят по " + itog + " " + Matsh.floover(itog));
                break;

            } else {
                System.out.println("Введите стоимость продукта в формате \"'рубли.копейки' [10.45, 11.40]\"");
                while (!scanner.hasNextInt()) {
                    System.out.println("Некорректное значение, введите стоимость продукта в формате \"'рубли.копейки' [10.45, 11.40]\"");
                    scanner.next();
                }
                float inputPrice = (float) scanner.nextDouble();
                food = food + "\n" + inputFood;
                price = price + inputPrice;

                System.out.println("Вы успешно добавили продукт:" + food + "\nИтог: " + String.format("%.2f", price) + " " + Matsh.floover(itog));
            }
        }
    }

static class Matsh {

    public static String floover(double price) {

        int amount = (int) price;

        if (amount > 100)
            amount %= 100;

        if (amount > 20)
            amount %= 10;

        switch (amount) {
            case 1:
                return "Рублю";
            case 2:
            case 3:
            case 4:
                return "Рубля";
            default:
                return "Рублей";
            }
        }
    }
}