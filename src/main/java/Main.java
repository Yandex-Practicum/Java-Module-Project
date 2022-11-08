import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPersons = 0;
        String name = "";
        double price = 0.0;
        Product random = new Product(name, price);
        Calculator calc = new Calculator(random);

        while (true) {
            System.out.println("На скольких человек нужно разделить счёт?");
            if (scanner.hasNextInt()) {
                numberOfPersons = scanner.nextInt();

                if (numberOfPersons > 1) {
                    break;
                } else if (numberOfPersons == 1) {
                    System.out.println("Вы один, счёт делить не нужно)");
                } else {
                    System.out.println("Некорректное значение");
                }
            }
            else{
                System.out.println("Некорректное значение");
                scanner.nextLine();
            }
        }

        System.out.println("Введите название продукта");
        scanner.nextLine();
        name = scanner.nextLine();

        while (true) {
            System.out.println("Введите стоимость продукта в формате XX,XX");
            if(scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                    if(price >= 0) {
                        Product UserInput = new Product(name, price);
                        calc.addProduct(UserInput);

                        System.out.println("Продукт успешно добавлен");
                        System.out.println("Не хотите добавить еще один продукт?");
                        System.out.println("Введите название продукта или");
                        System.out.println("Введите \"Завершить\", чтобы завершить процесс добавления товаров");
                        scanner.nextLine();
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("завершить")) {
                            break;
                        } else {
                            name = answer;
                        }
                    }
                    else{
                         System.out.println("Некорректное значение");
                         scanner.nextLine();
                    }
            }
            else{
                System.out.println("Некорректное значение");
                scanner.nextLine();
            }
        }
        calc.everyonePays(numberOfPersons);
        calc.ending(calc.fullPriceSharing);
        System.out.println("Добавленные товары:\n" + calc.listOfProducts);
        System.out.println(String.format("Каждый должен заплатить %.2f" + " %s", calc.fullPriceSharing, calc.rubles));
    }
}
