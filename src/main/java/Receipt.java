public class Receipt {

    static String totalDishes = "";
    static float totalPrice = 0.0f;

    void addDish(String dishName) {
        totalDishes = totalDishes.concat("\n").concat(dishName);
        System.out.println("Блюдо успешно добавлено..");
    }

    void addSum(float dishPrice) {
        totalPrice += dishPrice;
    }
}
