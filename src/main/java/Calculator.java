public class Calculator {

    String bill = "";
    double finalPrice = 0;
    int countPerson = 0;

    double priceOfPerson = 0;

    public void setCountPerson(int countPerson) {
        this.countPerson = countPerson;
    }

    public void setBill(Product product) {
        bill += (product.getNameOfProduct() + " " + product.getCost()) + "\n";
        finalPrice += product.getCost();

        }

    public String math() {
        String rubles = "";
        if (priceOfPerson < 5 || priceOfPerson % 10 > 1) {
            rubles = "рубля";
        } else if (priceOfPerson % 10 == 0 || priceOfPerson >= 6) {
            rubles = "рублей";
        } else if (priceOfPerson % 10 == 1 || priceOfPerson == 1){
            rubles = "рубль";
        }
        return rubles;
    }
    public void calculate() {
        priceOfPerson = finalPrice / countPerson;
        System.out.println("Количество персон: " + countPerson + "\n" + "Общий чек: " +
                "\n" + bill + "\n" + "Денег с человека:" + "\n" + String.format("%.2f", priceOfPerson) + " " + math());
    }



}
