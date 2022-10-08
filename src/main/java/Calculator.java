public class Calculator {
    float sum;
    String items;
    Calculator() {
        items = "";
        sum = 0;
    }
    public void addItem( float price , String product) {
        sum = sum + price;
        items = items + product + "\n";
    }
}

