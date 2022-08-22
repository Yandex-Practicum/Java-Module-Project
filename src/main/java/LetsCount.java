import java.util.HashMap;
import java.util.Scanner;

public class LetsCount {
    Scanner scanner = new Scanner(System.in);

    int guestCount;

    LetsCount(int guestCount) {
        this.guestCount = guestCount;
    }

    private final HashMap<String, Double> productList = new HashMap<>();

    String productName;
    double price;

    // Метод для заведения товаров
    public void inputProduct() {
        while (true) {
            System.out.println("Введите название товара:");
            productName = scanner.next();

            // Точка прерывания метода на ключевом слове "завершить"
            if (productName.equalsIgnoreCase("завершить")) {
                break;
            }

            System.out.println("Введите цену в т.ч. с копейками, формат 'рубли.копейки' [10.45, 11.40]:");
            try {
                price = scanner.nextDouble();
                if (productList.containsKey(productName) && price > 0) { // На случай, если мы уже добавили такой продукт
                    price = productList.get(productName) + price;
                    productList.put(productName, price);
                    System.out.println("Вы успешно добавили товар \"" + productName + "\"");
                } else if (price > 0) {
                    productList.put(productName, price);
                    System.out.println("Вы успешно добавили товар \"" + productName + "\"");
                } else if (price <= 0) {
                    System.out.println("Товар не может быть с отрицательной или нулевой стоимостью");
                }

            } catch (Exception nfe) {
                System.out.println("Убедитесь, что вы вводите число в формате 00.00 руб. Попробуйте добавить товар еще раз.");
                scanner.next(); //очистка сканера
            }

            System.out.println("Промежуточный итог: " + subTotal() +
                    " руб. \nДля завершения подсчета просто напишите \"завершить\"");
        }
    }

    // Метод для подсчета промежуточного итога
    public double subTotal() {
        double sum = 0;
        for (double d : productList.values()) {
            sum += d;
        }
        return sum;
    }

    // Метод для вывода чека в конце
    public void finalReceipt() {
        int i = 1;
        for (String key : productList.keySet()) {
            System.out.println("№ " + i + ". " + key + ", " + productList.get(key) + " руб.");
            i++;
        }
    }

    // Метод для подсчета долга на душу
    public double duePerGuest(double guestCount, double subTotal) {
        double d;
        d = subTotal / guestCount;
        return d;
    }

    // метод для определения формы слова "рубль" в зависимости от числа,
    // которое передается на входе
    public String rubCase(double duePerGuest) {
        int i = (int) Math.floor(duePerGuest);
        if (i >= 100) { // Для чеков больше 100 руб., для обработки остатков 11, 12, 13 и 14.
            switch (i % 100) {
                case 11:
                case 12:
                case 13:
                case 14:
                    return "рублей";
                default: // на случай, если остаток деления будет, например, 01, 24 и т.д.
                    return rubCaseDefault(i);
            }
        } else { // Если итоговый чек меньше, чем на 100 руб.
            return rubCaseDefault(i);
        }
    }

    // В отдельный метод вынесено определение формы слова "рубль" для случаев по умолчанию.
    // Просто чтобы соблюсти принцип DRY.
    private String rubCaseDefault(int i) {
        switch (i % 10) {
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
}