import java.util.Scanner;


public class Main


{
    public static void main(String[] args) {
        //Определяем переменные для приложения
        int members;
        String dishName;
        double dishCost;
        String totalDishList;
        double totalCost;
        String statement;

        //Запускаем бесконечный цикл для проверки корректности воода количества участников
        while (true) {
            System.out.println("Введите количество участников");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                members = input.nextInt();
                if (members <= 0) {System.out.println("Количество участников отрицательно или равно нулю. Так не бывает. Попробуйте еще раз.");}
                else if (members == 1) {System.out.println("Вы были один. Нет необходимости делить счет");}
                else if (members >0) {break;}
            }

            else {System.out.println("Вы ввели неверные данные. Попробуйте еще раз.");}

        }
        //Создаем объект для подстчетов и конкатенации
        Calculator calculating = new Calculator();

        //Запускаем бесконечный цикл для сбора данных о блюдах и стоимости
        while (true) {
            Scanner dishesInput = new Scanner (System.in);
            System.out.println("Что Вы с друзями заказали ?");

            dishName = dishesInput.next();
            totalDishList = calculating.dishNameConcat(dishName);
            System.out.println("Сколько стоило это блюдо ?");

            // Проверка корректности воода стоимости блюда
            if (dishesInput.hasNextDouble()) {
                dishCost = dishesInput.nextDouble();
                totalCost = calculating.dishCostCalc(members,dishCost);
                System.out.println("Это все ? Завершить/Нет");
                statement = dishesInput.next();
                if (statement.equalsIgnoreCase("Завершить")) {
                    break;
                }
            }

            else {System.out.println("Что-то не так со стоимостью блюда. Попробуйте еще раз.");}

        }

        // Создаем объект для проверки окончания валюты
        Checks cur = new Checks();
        //Пользователь дал команду на завершение. Выводим результат.
        System.out.println("Ваш заказ: " + "\n" + totalDishList);
        System.out.println("Ваш общий счет: " + String.format("%,.2f", totalCost) + " " + cur.currencyAddition(totalCost) );
        System.out.println("Каждый должен оплатить " + String.format("%,.2f", (totalCost/members)) + " " + cur.currencyAddition(totalCost/members));



    }

}

