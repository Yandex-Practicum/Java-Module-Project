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

    public List<Product> getListOfProducts() {
        return this.listOfProducts;
    }

    public int getNumberOfVisitors() {
        return this.numberOfVisitors;
    }

    public void addProductToList(Product product) {
        listOfProducts.add(product);
    }

    @Override
    public String toString() {
        return "Количество посетителей: " + this.numberOfVisitors + "\n" +
        "Список продуктов: " + this.listOfProducts.toString();
    }

    // Расчитывает стоимость по счету на каждого посетителя
    private double calculate() {
        double totalValue = 0;
        for (Product product:listOfProducts) {
            totalValue += product.getValue();
        }
        return totalValue / this.numberOfVisitors;
    }

    // Возвращает слово "Рубль" с правильным окончанием в зависимости от значения
    private String getRightWord(double value) {
        int num = (int) value;
        if  (num == 1) {
            return "рубль";
        } else if (List.of(2, 3, 4).contains(num)) {
            return "рубля";
        } else {
            return "рублей";
        }
    }

    // Выводит итоговые результаты
    public void printResults() {
        System.out.println("Добавленные товары:");
        for (Product product:listOfProducts) {
            System.out.println(product.getName() + " " + String.format("%.2f", product.getValue()) +
                    " " + getRightWord(product.getValue()));
        }

        double valuePerPerson = this.calculate();

        System.out.println("Итого: ");
        System.out.println("Колличество персон: " + this.getNumberOfVisitors());
        System.out.println("Стоимость по чеку на каждую персону составляет по: "
                + String.format("%.2f", valuePerPerson) + " " + getRightWord(valuePerPerson));
    }
}
