import java.util.Locale;

public class GetProductsAndTheirPrices {
   static Calculator calculator = new Calculator();

    public static   Calculator execute() {
        while (Main.scanner.hasNext()) {
            String product = Main.scanner.next();
            if (product.toLowerCase(Locale.ROOT).equals("завершить") || product.toLowerCase(Locale.ROOT).equals("exit")) {
                break;
            } else {
                calculator.products += product + " ";
            }
            System.out.println("Enter product's price in rubles and pennies , example \"20.22\"");
            String tempPrice = Main.scanner.next();
            if (tempPrice.toLowerCase(Locale.ROOT).equals("завершить") || product.toLowerCase(Locale.ROOT).equals("exit")) {
                removeLastProduct(product);
                break;
            } else {

                try {
                    double price = Double.parseDouble(tempPrice);

                    if (price < 0) {
                        System.out.println("Invalid input, the price cannot be negative");
                        removeLastProduct(product);
                    } else if (price == 0) {
                        System.out.println("Invalid input, the price cannot be zero");
                        removeLastProduct(product);
                    } else {
                        calculator.products += tempPrice + "\n";
                        calculator.totalSum += price;
                        System.out.printf("Product %1s with price %2.2f was successfully added\n", product, Double.parseDouble(tempPrice));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. You should type the correct price, example \"20.22\"");
                    removeLastProduct(product);
                }

            }
            System.out.println("If you've finished adding products, you can type \"exit\" to stop or just continue, then type product's name");

        }
        return calculator;
    }

    private static void removeLastProduct(String product) {
        calculator.products = calculator.products.substring(0, calculator.products.length() - product.length() - 1);
    }
}

