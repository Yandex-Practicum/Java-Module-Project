public class Сalculator {
int  amountFreinds;
String cart = "Добавление товаров";
double totalAmount = 0; // float с  запятой нужно с точкой

    public Сalculator(int amountFreinds) {
    }

    void Calculator (int amountFreinds) {
        this.amountFreinds = amountFreinds;
    }
    void addItem(Iteam item) {
        Object totalPrice = item.price;
        cart = cart + "\n" + item.name;
        System.out.println(item.name + " в корзине");
    }
    public double divideSum() {
        return totalAmount / amountFreinds ;
    }
}
