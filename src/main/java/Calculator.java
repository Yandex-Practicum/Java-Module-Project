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
        String rubles = "руб";
        if (priceOfPerson > 10 && priceOfPerson <20 ) {
            return rubles + "лей";
        } switch ((int) priceOfPerson % 10) {
            case 1: {
                return rubles + "ль";
            }
            case 2:
            case 3:
            case 4: {
                return rubles + "ля";
            }
            default: {
                return rubles + "лей";
            }
        }
    }

    public void calculate() {
        priceOfPerson = finalPrice / countPerson;
        System.out.println("Количество персон: " + countPerson + "\n" + "Общий чек: " +
                "\n" + bill + "\n" + "Денег с человека:" + "\n" + String.format("%.2f", priceOfPerson) + " " + math());
    }
}
