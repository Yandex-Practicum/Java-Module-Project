public class Dishes {
    private String nameOfDish;
    private double amount;

    public Dishes(String nameOfDish, String amount) {
        this.nameOfDish = nameOfDish;
        this.amount = Double.parseDouble(amount);
    }

    public double getAmount() {
        return this.amount;
    }

    public String getNameOfDish() {
        return this.nameOfDish;
    }
}
