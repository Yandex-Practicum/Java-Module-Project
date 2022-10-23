public class Item {
    String title;
    double price;
    Item(String Title, double Price) {
        title = Title;
        price = Price;
    }
    public String toString(){
        String priceAsStr = Double.toString(price);
        return title + " " + priceAsStr;
}
}
