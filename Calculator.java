public class Calculator {
    // общая сумма
    double totalPrice = 0;
    // все товары
    String products = "";
    // добавить товар
    public void setProducts (String product) {
        products += "\n" + product;
    }
    // получить товары
    public String getProducts () {
        return products;
    }
    // получить сумму
    public double getTotalPrice() {
        return totalPrice;
    }
    // добавить стоимость в общую сумму
    public void setTotalPrice(double price) {
        totalPrice += price;
    }
}












