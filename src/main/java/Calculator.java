import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    private final Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private int guestsCount;
    private final ArrayList<Product> products = new ArrayList<>();

    public void resolveGuestsCount() {
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true) {
            try {
                int count = scanner.nextInt();
                if (count > 1) {
                    guestsCount = count;
                    break;
                }
            } catch (Exception e) {
                scanner.next();
            }
            System.out.println("Введено неверное значение, попробуйте еще раз");
        }
    }

    public void resolveProducts() {
        while (true) {
            System.out.println("Введите название товара");
            String productName = scanner.next();
            double productPrice = resolvePrice();
            products.add(new Product(productName, productPrice));
            System.out.println("Товар успешно добавлен");
            System.out.println("Введите любой символ, чтобы добавить еще один товар или введите Завершить");
            if (scanner.next().equalsIgnoreCase("завершить")) {
                break;
            }
        }
    }

    public void proceedTotals() {
        StringBuffer productsTotal = new StringBuffer();
        float sum = 0f;
        int productsLastIndex = products.size() - 1;
        for (int i = 0; i <= productsLastIndex; i++) {
            Product product = products.get(i);
            productsTotal.append(product.name);
            if (i != productsLastIndex) {
                productsTotal.append("\n");
            }
            sum += product.price;
        }
        System.out.println("Добавленные товары:");
        System.out.println(productsTotal);
        System.out.println(formatGuestBill(sum/guestsCount));
    }

    private double resolvePrice() {
        double validatedPrice;
        while (true) {
            System.out.println("Введите стоимость товара в формате рубли.копейки");
            double price = 0.0;
            try {
                String priceInput = scanner.next();
                int fractionSize = priceInput.split("\\.")[1].length();
                if (fractionSize == 2) {
                    price = Double.parseDouble(priceInput);
                }
            } catch (Exception e) {
                scanner.next();
            }
            if (price > 0) {
                validatedPrice = price;
                break;
            } else {
                System.out.println("Введено некорректное значение");
            }
        }
        return validatedPrice;
    }

    private String formatGuestBill(float amount) {
        int amountLastDigit = ((int) amount) % 10;
        String currency;
        if (amountLastDigit == 1){
            currency = "рубль";
        } else if (amountLastDigit < 5){
            currency = "рубля";
        } else {
            currency = "рублей";
        }
        return String.format(Locale.ENGLISH, "%.2f ".concat(currency), amount);
    }
}
