import java.util.Scanner;

public class Calculator {
    public static void calculator(int delitel) {

        Scanner scannerProduct = new Scanner(System.in);
        String allProduct = "";
        Float allPrice = 0.0f;
        while (true) {
            System.out.println("Введите название товара");
            String product = scannerProduct.next();
            String and = "Завершить";
            if (product.equalsIgnoreCase(and)) {
                break;
            }

            System.out.println("Введите стоимость товара (рубли.копейки)");
            Float price = cost();
            allProduct = allProduct + "\n" + product + ": " + price;
            allPrice = allPrice + price;
            System.out.println("Товар добавлен, хотите добавить еще товар ?  \n Если нет, введите команду \"Завершить\"");
            String answer = scannerProduct.next();
            if (answer.equalsIgnoreCase(and)) {
                break;
            }

        }
        float personPrice = allPrice / delitel;
        String personPriceString = String.format("%.2f", personPrice);
        int personPriceInteger = (int) personPrice;
        String rub = PrintRub.getStringRub(personPriceInteger);
        System.out.println("Добавленные товары:" + "\n" + allProduct + "\n" + "Сумма к оплате для каждого человека - " + personPriceString + rub);

    }

    //введение цены
    public static float cost() {
        Scanner scanner = new Scanner(System.in);
        float price = 0.0f;
        try {
            String value = scanner.next().trim();
            price = Float.parseFloat(value);
            int pointPosition = value.indexOf('.');
            if (!(pointPosition == -1 || value.length() - 1 - pointPosition <= 2)) {
                System.out.println("Введено некорректное значение, попробуйте еще.");
                price = cost();
            }
            if (price > 0) {
                System.out.println("Введено некорректное значение, попробуйте еще.");
                price = cost();
            }
        } catch (Exception e) {
            System.out.println("Введено некорректное значение, попробуйте еще.");
            price = cost();
        }

        return price;
    }
}
