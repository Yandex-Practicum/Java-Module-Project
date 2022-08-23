import java.util.ArrayList;

public class BillCalculator {
    int personsNumber;
    double sumPrice;
    ArrayList<Product> products = new ArrayList<>();

    public BillCalculator(int personsNumber) {
        this.personsNumber = personsNumber;
    }

    public void addProduct(String name, double price) {     // Добавление продукта в список
        products.add(new Product(name, price));
        sumPrice += price;
    }

    public void printProducts() {       // Вывод списка продуктов
        int size = products.size();
        System.out.println("Добавленные товары:");
        for (int i = 0; i < size; i++) {
            products.get(i).printProduct();
        }
        System.out.println("Итого: " + sumPrice + Helpers.getRuble(sumPrice));
    }

    public double calculateBill() {      // Расчет суммы к оплате каждым человеком
        return  sumPrice/personsNumber;
    }
}
