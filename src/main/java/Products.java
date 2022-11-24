public class Products {

    String name;
    String finalList;
    double price;
    double finalPrice;


    Products(String name, String finalList, double price, double finalPrice){
        this.name = name;
        this.finalList = finalList;
        this.price = price;
        this.finalPrice = finalPrice;
    }
void finalPrice(double productPrice){
  finalPrice = finalPrice + price;
}
void finalProductList(String productList){
    finalList = finalList + "\n" + name.trim();
price = price - price;

}
}