class Calculation {

    String allProducts = "";
    double totalPrice = 0.0;

    void add(Product product) {
        allProducts += (String.format("%s %s, \n", product.addNameOfProduct(),Main.sumInRubles(product.addPriceOfProduct())));
        totalPrice += product.addPriceOfProduct();
    }
    double calculate(int numberOfGuests) {
        return totalPrice / numberOfGuests;
    }
}
