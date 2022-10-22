import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* Этот класс выполняет обработку входных данных после заказа. Расчитывает стоимость на каждого
    человека и выводит данные на консоль
     */

    private int numberOfVisitors;
    private List<Product> listOfProducts;

    public Calculator(int numberOfVisitors) {
        this.numberOfVisitors = numberOfVisitors;
        this.listOfProducts = new ArrayList<>();
    }

    public void addProductToList(Product product) {
        listOfProducts.add(product);
    }

    public double calculate() {
        return 0.0;
    }
}
