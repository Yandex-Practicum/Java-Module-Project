public class Calculator {

    String bill = "";
    double finalPrice = 0;
    int countPerson = 0;
    

    public void setCountPerson(int countPerson) {
        this.countPerson = countPerson;
    }
    
    public void setBill(Product product) {
        bill += (product.getNameOfProduct() + "\n" + product.getCost()) + "\n";
        finalPrice += product.getCost();

        }


    public void calculate() {
        double priceOfPerson = finalPrice / countPerson;
        System.out.println("Количество персон: " + countPerson + "\n" + "Общий чек: " +
                "\n" + bill + "\n" + "Денег с человека:" + "\n" + priceOfPerson  + " рублей");
    }

}
