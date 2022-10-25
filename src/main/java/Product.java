import java.util.ArrayList;

public class Product {
    static ArrayList<String> nameProduct = new ArrayList<>();
    static ArrayList<Double> priceProduct = new ArrayList<>();

    public void setNameProduct(String nameProduct) {
        Product.nameProduct.add(nameProduct);
    }

    public void setPriceProduct(double priceProduct) {
        Product.priceProduct.add(priceProduct);
    }

    public ArrayList<String> getNameProduct() {
        return nameProduct;
    }

    public ArrayList<Double> getPriceProduct() {
        return priceProduct;
    }
}
