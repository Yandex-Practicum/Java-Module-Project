public class Calculator {
    int countPeople;
    double currentTotalAmount = 0;
    String products = "";

    Calculator(int countPeople) {
        this.countPeople = countPeople;
    }

    void addProductCost(Product product) {
        products += product.name + "\r\n";
        currentTotalAmount += product.cost;
    }

    double getEachFriendAmount() {
        return currentTotalAmount / countPeople;
    }
}
