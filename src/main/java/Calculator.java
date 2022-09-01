import java.util.ArrayList;

public class Calculator {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct (String name, double price) {
        Product product = new Product(name, price);
        products.add(product);
    }

    public void printProducts () {
        if (products.isEmpty()) {
            System.out.println("Пока товаров нет");
        } else {
            for (Product product : products) {
                System.out.println(product.name);
            }
        }
    }

    public double sumOfProducts () {
        double sum = 0;

        for (Product product : products) {
            sum += product.price;
        }

        return sum;
    }

    public void eachPortion (int peoples) {
        double sum = sumOfProducts();
        double portion = sum / peoples;
        String result = String.format("%.2f", portion);

        if (portion % 10 == 1 && (portion > 19 || portion < 10)) {
            System.out.println("Каждому надо заплатить " + result + " рубль");
        } else if ((portion % 10 >= 2 && portion % 10 <= 4) && ((portion > 19 || portion < 10))) {
            System.out.println("Каждому надо заплатить " + result + " рубля");
        } else {
            System.out.println("Каждому надо заплатить " + result + " рублей");
        }
    }
}
