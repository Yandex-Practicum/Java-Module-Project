import java.util.Scanner;

public class Calculator {
    String products;
    double costOfGoods;

    public Calculator() {
        products = "";
        costOfGoods = 0.0;
    }


    public void addProduct() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название товара:");
            String product = scanner.nextLine();
            if (product.equalsIgnoreCase("Завершить")) {
                break;
            }
            products = products + product + "\n";
            System.out.println("Введите цену в формате: 'рубли.копейки' [10,45, 11,40]");
            double cost = addCost();
            costOfGoods += cost;
            System.out.println("Товар успешно добавлен. \n Хотите добавить ещё товар? Если нет, до введите: \"Завершить.\"");
        }
    }

    public double addCost() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextDouble()) {
                double cost = scanner.nextDouble();
                if (cost >= 0) {
                    return cost;
                } else {
                    System.out.println("Некорректиный ввод. Цена должна быть > 0. Попробуйте еще раз:");
                }
            } else {
                System.out.println("Некорректиный ввод. Введите цену в формате: 'рубли.копейки' [10,45, 11,40]:");
            }
        }
    }

    public static String rubleFormat(double cost) {
        if ((int) cost % 100 / 10 == 1) {
            return "рублей";
        }

        switch ((int) cost % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

    public void addOutput(int friends) {
        System.out.println("Добавленные товары: \n" + products);
        System.out.printf("Сумма, которую должен заплатить каждый человек: %.2f %s \n ", costOfGoods / friends, rubleFormat(costOfGoods / friends));
        System.out.printf("Общий счет: %.2f %s \n ", costOfGoods, rubleFormat(costOfGoods));
    }
}