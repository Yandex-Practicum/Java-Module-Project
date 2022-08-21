import java.util.Scanner;

public class Calculate {
    String listProducts = "";
    double money;

    void addProduct(Scanner scanner, int count) {
        double price;
        String name;
        while (true) {
            System.out.println("Введите название товара или \"Завершить\" для подсчета суммы:");
            name = scanner.next();
            if (name.equalsIgnoreCase("Завершить")) {
                System.out.println("Добавленные товары:\n" + listProducts);
                System.out.println(calc(money, count));
                break;
            } else {
                listProducts = listProducts + "\n" + name;
            }
            System.out.println("Введите цену товара в формате Х.ХХ:");
            while (true) {
                try {
                    price = Double.parseDouble(scanner.next());
                    if (price <= 0) {
                        System.out.println("Неверный ввод. Введите цену заново:");
                    } else {
                        money = money + price;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Неверный ввод. Введите цену заново:");
                }
            }
            System.out.println("Товар добавлен в список.");
        }
    }

    String calc(double summ, int countPerson) {
        String end;
        double onePrice = summ / countPerson;
        if ((int) (onePrice % 10) == 1) {
            end = " рубль";
        } else if ((int) (onePrice % 10) == 2 || (int) (onePrice % 10) == 3 || (int) (onePrice % 10) == 4) {
            end = " рубля";
        } else {
            end = " рублей";
        }
        return ("Каждый человек должен заплатить по " + String.format("%.2f", onePrice) + end);
    }
}
