import java.util.Scanner;

public class List {
    public static void listOfProduct() {
        Scanner scanner = new Scanner(System.in);
        String names = "";
        double sumPrice = 0;




        while (true) {
            System.out.println("Введите наименование товара:");
            String name = scanner.next();
            names += "Продукт: " + name + " стоимость: ";

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
                System.out.println("Завершить покупку? \n(напишите \"Завершить\" для положительного ответа)");
                String complete = scanner.next();
                if (complete.equalsIgnoreCase("Завершить")) {
                    System.out.println("Добавленные товары:\n" + names);
                    System.out.println("вот " + sumPrice);

                    break;
                } else ;
            }
        }
    }


    //для вывода кода в калькулятор
    private double sumPrice;
    List() {
        Scanner scanner = new Scanner(System.in);
        this.sumPrice = scanner.nextInt();
    }
    public double sumPrice() {
        return 0;
    }
}
