
class Calculator {


    static String cart = "Добавленные товары "; // название продукта в корзине
    double totalPrice = 0; // Общая стоимость товара
    double devideSum;
    int numberPeople; // количество людей

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



