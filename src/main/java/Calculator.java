public class Calculator {

    String bill = "";
    double finalPrice = 0;
    int countPerson = 0;

    public void setBill(Product product) {
        bill += (product.getNameOfProduct() + "\n" + product.getCost()) + "\n";
        finalPrice += product.getCost();
        countPerson = product.getCountPerson();
        }


    public void calculate() {
        double priceOfPerson = finalPrice / countPerson;
        System.out.println("Общий чек: " + "\n" + bill + "\n" + "Денег с человека:" + "\n" + priceOfPerson  + " рублей");
    }

}
