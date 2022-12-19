import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек разделить счет?");
        int people;

        while (!(scanner.hasNextDouble())) { System.out.println("Ошибка,нужно ввести именно число");
                scanner.next();
            }

            while (true) {
                people = scanner.nextInt();
                if (people > 1) {
                    System.out.println(people + "чел");
                    break;
                } else if (people == 1 || people < 0) {
                    System.out.println("Ошибка,нужно ввести количество >1 и не минусовое.Введите количество заново");
                } else {
                    System.out.println("Ошибка.Введите количество заново");
                }
            }
            Calculate calculate = new Calculate(people);

            while (true) {
                System.out.println("Введите название товара");
                String name = scanner.next();
                System.out.println("Введите цену товара в формате: 00,00 (рубли.копейки)");

                double price;

                while (!(scanner.hasNextDouble())) {
                    System.out.println("Ошибка,нужно ввести именно число");
                    scanner.next();
                }
                price = scanner.nextDouble();

                while (true) {
                    if (price > 0) {
                        break;
                    } else if (price <= 0) {
                        System.out.println("Ошибка, цена не может быть 0 или минусовой.Введите цену заново");
                        price = scanner.nextDouble();
                    }
                }
                calculate.addProduct(new Product(name, price));

                System.out.println("Если хотите добавить еще товар, введите любой знак, если нет, введите 'Завершить'");
                String finish = scanner.next();
                if (finish.equalsIgnoreCase("Завершить")) {
                    break;
                }
            }
            double sum = Calculate.getSum();
            double result = sum / people;
            Format format = new Format();
            System.out.println(Calculate.listProduct);
            System.out.println("К оплате каждого человека:" + format.round(result) + format.padeg(result));
        }
    }





















