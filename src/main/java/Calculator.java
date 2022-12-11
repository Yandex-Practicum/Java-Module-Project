
class Calculator {


    static String cart = "Добавленные товары ";
    double totalPrice = 0;
    double devideSum;
    int numberPeople;

    void calcul(added added) {
        totalPrice = totalPrice + added.prise;
        cart = cart + "\n" + added.product;
        System.out.println(added.product + " - в корзине");
        devideSum = totalPrice / numberPeople;

    }

    Calculator(int numberPeople) {
        this.numberPeople = numberPeople;
    }
}
//


