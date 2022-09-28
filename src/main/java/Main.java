import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int members = 0;
        String dishName;
        double dishCost =0;
        String statement;
        String totalDishList;
        double totalCost;

    // Задаем первый вопрос и проверяем на корректность ввода.
      while (true) {
          Scanner input = new Scanner(System.in);
          System.out.println("Привет. Похоже после учебы вы отлично посидели с друзьями. Сколько вас было человек ?");
          if (input.hasNextInt()) {
              members = input.nextInt();
              break;
          }
          System.out.println("Что-то не так. Попробуйте еще раз");
      }
      /* Считываем ввод блюд и их стомость. Создаем экземплаяры класса calculator.
         Вычисляем сумму затрат и суммируем ввод в единую строку */
        Calculator calculating= new Calculator();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Что вы с друзьями заказали ?");
            dishName = input.next();
            totalDishList = calculating.dishNameConcat(dishName);
            System.out.println("Сколько стоило это блюдо ?");
            dishCost = input.nextDouble();
            totalCost = calculating.dishCostCalc(members,dishCost);
            System.out.println("Это все ? Если Да - напишите \"Завершить\". Если Нет - напишите \"Нет\" ");
            statement = input.next();
            if (statement.equalsIgnoreCase("Завершить")) {
                break;
            }

        }
        // Создаем объект для проверки окончания валюты
        Checks cur = new Checks();
        //Пользователь дал команду на завершение. Выводим результат.
        System.out.println("Ваш заказ: " + "\n" + totalDishList);
        System.out.println("Ваш общий счет: " + String.format("%,.2f", totalCost) + " " + cur.currencyAddition(totalCost) );
        System.out.println("Каждый должен оплатить " + String.format("%,.2f", (totalCost/members)) + " " + cur.currencyAddition(totalCost/members));




    }

}
