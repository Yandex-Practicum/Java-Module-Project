import java.util.Locale;

public class GetProductsAndTheirPrices {
    Calculator calculator = new Calculator();

    public Calculator execute() {
        while (Main.scanner.hasNext()) {
            String product = Main.scanner.next();
            if (product.toLowerCase(Locale.ROOT).equals("завершить") || product.toLowerCase(Locale.ROOT).equals("exit")) {
                break;
            } else {
                calculator.products += product + " ";
            }
            System.out.println("Enter product's price in rubles and pennies , example \"20.22\"");
            String price = Main.scanner.next();
            if (price.toLowerCase(Locale.ROOT).equals("завершить") || product.toLowerCase(Locale.ROOT).equals("exit")) {
                calculator.products = calculator.products.substring(0, calculator.products.length() - product.length() - 1);
                break;
            } else {
                calculator.products += price + "\n";
                calculator.totalSum += Double.parseDouble(price);
                System.out.printf("Product %1s with price %2.2f was successfully added\n", product, Double.parseDouble(price));
            }
            System.out.println("If you've finished adding products, you can type \"exit\" to stop or just continue");

        }
        return calculator;
    }
}

