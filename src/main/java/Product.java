public class Product {

    String nameOfProduct;
    double priceOfProduct;

    void getNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }
    void getPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }
    public String addNameOfProduct(){
        return nameOfProduct;
    }
    public double addPriceOfProduct() {
        return priceOfProduct;
    }
}
