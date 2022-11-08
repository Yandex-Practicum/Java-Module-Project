import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int persons;
        String foodName;
        double foodCost;
        String totalFoodList;
        double totalCost;
        String statement;


        while (true) {
            System.out.println("Введите количество участников");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                persons = input.nextInt();
                if (persons <= 0) {System.out.println("Количество участников отрицательно или равно нулю. Попробуйте еще раз.");}
                else if (persons == 1) {System.out.println("Нет необходимости делить счет");}
                else if (persons >0) {break;}
            }

            else {System.out.println("Вы ввели неверные данные. Попробуйте еще раз.");}

        }

        Calculator calculating = new Calculator();


        while (true) {
            Scanner dishesInput = new Scanner (System.in);
            System.out.println("Что Вы с друзями заказали ?");

            foodName = dishesInput.next();
            totalFoodList = calculating.foodNameConcat(foodName);
            System.out.println("Сколько стоило это блюдо ?");


            if (dishesInput.hasNextDouble()) {
                foodCost = dishesInput.nextDouble();
                totalCost = calculating.foodCostCalc(persons,foodCost);
                System.out.println("Это все ? Завершить/Нет");
                statement = dishesInput.next();
                if (statement.equalsIgnoreCase("Завершить")) {
                    break;
                }
            }

            else {System.out.println("Что-то не так со стоимостью блюда. Попробуйте еще раз.");}

        }


        Check cur = new Check();

        System.out.println("Ваш заказ: " + "\n" + totalFoodList);
        System.out.println("Ваш общий счет: " + String.format("%,.2f", totalCost) + " " + cur.currencyAddition(totalCost) );
        System.out.println("Каждый должен оплатить " + String.format("%,.2f", (totalCost/persons)) + " " + cur.currencyAddition(totalCost/persons));

    }
}
