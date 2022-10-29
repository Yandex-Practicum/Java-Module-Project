import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Calculator.calculator();
        People.People();
        List.listOfProduct();
        Calculator.calculator();
        /* Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте!");
        double sumPrice;
        double score;
        double numbOfPeople;

        //Сбор информации о количестве человек
        while (true) {
            System.out.println("На скольких человек разделить счет?");
            numbOfPeople = scanner.nextDouble();
            sumPrice = 0;
            score = sumPrice / numbOfPeople;

            if (numbOfPeople > 1) {
                String names = "";
                while (true) {
                    System.out.println("Введите наименование товара:");
                    String name = scanner.next();
                    names += name + " ";

                    System.out.println("Введите стоимость товара:");
                    double price = scanner.nextDouble();
                    names += price + "\n";
                    sumPrice += price;

                    System.out.println("Товар добавлен в список!");

                    //Выбор дальнейшего действия
                    System.out.println("Хотите добавить еще товар?");
                    String add = scanner.next();
                    if (add.equalsIgnoreCase("да")) {

                    }
                    if (add.equalsIgnoreCase("нет")) {
                        System.out.println("Завершить покупку?");
                        String complete = scanner.next();
                        if (complete.equalsIgnoreCase("Завершить")) {
                            System.out.println("Добавленные товары:\n" + names);
                            break;
                        }else;
                    }
                }
                break;
            }
            if (numbOfPeople <= 1) {
                System.out.println("Некорректное количество гостей. Пожалуйста попробуйте ввести количество гостей еще раз.");
            }

        } */

        /* System.out.println("общая сумма равна " + sumPrice + "\nкаждый человек заплатит по " + score);
        System.out.println("sumPrice " + sumPrice + "\nscore " + score + "\nnumbOfPeople " + numbOfPeople); */
    }

}


