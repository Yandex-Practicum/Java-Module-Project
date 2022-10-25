public class Calculation {
    String allProducts = " ";
    double totalPrice = 0.0;
    Product product = new Product();

    public String calculationNameProduct(){
        for (int i = 0; i < product.getNameProduct().size(); i++) {
            allProducts = allProducts + " " + product.getNameProduct().get(i);
        }return allProducts;
    }
    public Double calculationPriceProduct(){
        for (int i = 0; i < product.getPriceProduct().size(); i++) {
            totalPrice = totalPrice + product.getPriceProduct().get(i);
        } return totalPrice;
    }
}
