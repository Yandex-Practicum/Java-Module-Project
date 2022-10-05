public class Calculator {

    private String bill = "";
    private double finalPrice = 0.0;
    private int countPerson = 0;

    public Calculator(int countPerson) {
        this.countPerson = countPerson;
    }

    public void add(Product product) {
        finalPrice += product.getPrice();
        bill += product.getName() + " " + product.getPrice() + "\n";
    }

    public String calculate() {
        // finalePrice/countPerson
        double priceOfPerson = finalPrice / countPerson;
        return bill + "\n" + "Итого: " + finalPrice + "\n" + "Цена с человека: " + priceOfPerson;
    }

}
