import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Здравствуйте!");
        collectingInfo();

    }

    //Сбор информации о количестве человек
    private static void collectingInfo() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("На скольких человек разделить счет?");
            int numbOfPeople = scanner.nextInt();
            if (numbOfPeople == 1) {
                //вызвать счет
                System.out.println("Ваш счет.");
                break;
            }
            if (numbOfPeople < 1) {
                System.out.println("Некорректное количество гостей. Пожалуйста попробуйте ввести количество гостей еще раз.");

            }
            if (numbOfPeople > 1) {

                products();

                break;
            }
        }
    }

    //Добавление товаров в список
    private static void products() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите наименование товара:");
        String name = scanner.next();
        System.out.println("Введите стоимость товара:");
        String price = scanner.next();
        System.out.println("Товар добавлен в список!");
        Products products = new Products(name, price);
        System.out.println("Ваш список продуктов:\n" + name + " стоимостью " + price + " рублей\n");
        listOfProducts();

    }

    private static void listOfProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите добавить еще товар?");
        String add = scanner.next();
        while (true) {
            if (add.equalsIgnoreCase("да")) {
                products();
                break;
            }
             if (add.equalsIgnoreCase("нет")) {
                System.out.println("Завершить покупку?");
                String complete = scanner.next();
                while (true) {
                    if (complete.equalsIgnoreCase("Завершить")) {
                        break;
                    }
                    if (complete.equalsIgnoreCase("нет")){
                        break;
                    }
                    else {
                        System.out.println("введите еще раз");

                    }
                }
            }

        }
    }

}


