import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте!");
        //Сбор информации о количестве человек
        while (true) {
            System.out.println("На скольких человек разделить счет?");
            int numbOfPeople = scanner.nextInt();
            if (numbOfPeople > 1) {
                listOfProducts();
                break;
            }
            if (numbOfPeople <= 1) {
                System.out.println("Некорректное количество гостей. Пожалуйста попробуйте ввести количество гостей еще раз.");
            }
        }
        System.out.println("На скольких человек разделить счет?");
    }


    //Добавление товаров в список
    private static void listOfProducts() {
        Scanner scanner = new Scanner(System.in);
        String names = "";

        while (true) {
            System.out.println("Введите наименование товара:");
            String name = scanner.next();
            names += name + " ";

            System.out.println("Введите стоимость товара:");
            String price = scanner.next();
            names += price + "\n";

            System.out.println("Товар добавлен в список!");


            //Выбор дальнейшего действия
            System.out.println("Хотите добавить еще товар?");
            String add = scanner.next();
            if (add.equalsIgnoreCase("да")) {

            }
            if (add.equalsIgnoreCase("нет")) {
                break;
            }

        }

        //Завершение
        while (true) {
            System.out.println("Завершить покупку?");
            String complete = scanner.next();
            if (complete.equalsIgnoreCase("Завершить")) {
                System.out.println("Ваш список товаров:\n" + names);
                break;
            }
            listOfProducts();
        }

    }


}


