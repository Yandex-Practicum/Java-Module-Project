public class Calculator {
   String foodName;
   String totalFoodList = "";
   int persons;
   double foodCost;
   double totalCost;
   double costPerPerson;


    double foodCostCalc (int persons, double foodCost) {
        this.persons = persons;
        this.foodCost = foodCost;
        totalCost += this.foodCost;
        System.out.println("Блюдо успешно добавлено в общий счет");
        return totalCost;


    }
    String foodNameConcat (String foodName) {
        this.foodName = foodName;
        totalFoodList  += this.foodName + "\n";
        return totalFoodList;

    }


}
