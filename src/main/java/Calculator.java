class Calculator {

    String allProducts = "";
    double totalPrice = 0;

    void addProduct(Product product) {
        allProducts += product.getName() + "\n";
        totalPrice += product.getPrice();
    }

    double calculateShare(int numberOfPersons) {
        return totalPrice / numberOfPersons;
    }

}