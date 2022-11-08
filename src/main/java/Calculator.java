public class Calculator {

    int members;
    double dishCost;
    double totalCost;
    String dishName ;
    String totalDishList = "";
    double costPerFriend;


    double dishCostCalc (int members, double dishCost) {
        this.members = members;
        this.dishCost = dishCost;
        totalCost += this.dishCost;
        System.out.println("Блюдо успешно добавлено в общий счет");
        return totalCost;


    }
    String dishNameConcat (String dishName) {
        this.dishName = dishName;
        totalDishList  += this.dishName + "\n";
        return totalDishList;

    }

}
