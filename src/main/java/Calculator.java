import java.util.ArrayList;

public class Calculator {

    private static ArrayList<Product> products = new ArrayList<>();
    private static int numberOfPeople;

    public static void addProduct(Product product) {
        Calculator.products.add(product);
    }

    public static void setNumberOfPeople(int numberOfPeople) {
        Calculator.numberOfPeople = numberOfPeople;
    }

    public static void showProducts() {
        System.out.println("Добавленные товары:");
        products.forEach(x -> System.out.println(x.toString() + currencyFormat(x.getPrice())));
        System.out.println("=========================");

        System.out.println("Общая сумма: " + currencyFormat(getPrize()));
        System.out.print("Каждый должен заплатить: " + currencyFormat(getPrize() / numberOfPeople));
    }

    private static double getPrize() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public static String currencyFormat(double sum) {
        int remains = (int)sum % 10;
        String format = String.format("%.2f",sum);
        if ((int)sum >= 11 && (int)sum <= 19){
            return format + " рублей";
        } else if (remains >= 2 && remains <= 4) {
            return format + " рубля";
        } else if (remains == 1){
            return format + " рубль";
        } else {
            return format + " рублей";
        }
    }
}
