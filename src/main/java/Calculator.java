public class Calculator {

    String bill = "";
    double finalPrice = 0.00;
    int countPerson = 0;

    public void setBill(Product product) {
        finalPrice += product.getCost();
        bill = product.getNameOfProduct() + product.getCost();
        }


    public String calculate() {
        double priceOfPerson = finalPrice / countPerson;
        return "Итого: " + bill + "Денег с человека:" + priceOfPerson;
    }
}

