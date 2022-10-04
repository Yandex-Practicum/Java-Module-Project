public class Goods {
    static String name;
    static double price;
    Goods (String nameOfGoods, double priceOfGoods) {
        name = nameOfGoods;
        price = priceOfGoods;
    }
    public static double count (double summOfBasket) {
        return summOfBasket + price;

    }
    public static String listing (String listOfGoods) {
        String y = "";
        y = listOfGoods +"/n"+ name;
        return y;
    }
}
