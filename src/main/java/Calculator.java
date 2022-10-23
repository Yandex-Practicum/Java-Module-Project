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
        int i = (int)sum;
        if (i % 10 == 2  || i % 10 == 3  || i % 10 == 4) {
            return String.format("%.2f",sum) + " рубля";
        } else if (i % 10 == 1 || i == 1){
            return String.format("%.2f",sum) + " рубль";
        } else {
            return String.format("%.2f",sum) + " рублей";
        }
    }
}
