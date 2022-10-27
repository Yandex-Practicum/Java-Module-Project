import java.util.ArrayList;
import java.util.Scanner;

public class BillSplitCalculator {
    double totalCost;
    short numberOfPersons;
    ArrayList<Product> products = new ArrayList<Product>();

    public void askForNumberOfPersons() {
        Scanner scanner = new Scanner(System.in);
        short input;

        System.out.print("Укажите количество людей для разделения счета: ");
        while (true) {
            while (!scanner.hasNextShort()) {
                System.out.println("Это не целое число. Пожалуйста, введите снова: ");
                scanner.next();
            }
            input = scanner.nextShort();

            if (input < 2)
                System.out.println("Количество людей должно быть больше 1. Введите снова: ");
            else
                break;
        }
        numberOfPersons = input;
    }

    private void addProductToList(Product product) {
        products.add(product);
        totalCost += product.price;
        System.out.println("Товар успешно добавлен.");
    }

    public void createProductFromInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название товара: ");
            String name = scanner.nextLine();
            while (name.isEmpty() || !name.matches("(?U).*\\w.*")) {
                System.out.println("Товар должен иметь название. Введите ещё раз: ");
                name = scanner.nextLine();
            }

            System.out.println("Введите стоимость товара в формате 'рубли.копейки' (20.50): ");
            String price = scanner.nextLine();
            while (!price.matches("\\d+\\.\\d{1,2}")) {
                System.out.println("Неверный формат стоимости. Попробуйте ещё раз: ");
                price = scanner.nextLine();
            }

            Product product = new Product(name, Double.parseDouble(price));
            addProductToList(product);

            System.out.println("Если нужно добавить ещё товар - нажмите Enter или введите любой символ, если хотите закончить - введите 'Завершить'");
            if (scanner.nextLine().equalsIgnoreCase("завершить"))
                break;
        }
    }

    public void showFinalBill() {
        System.out.println("Добавленные товары:\n-------------------------");

        for (Product product : products) {
            System.out.println(String.format("%s - %.2f\n-------------------------", product.name, product.price));
        }
        System.out.println(String.format("Общая стоимость товаров - %.2f %s ", totalCost, getCorrectRubleEnding(totalCost)));
        System.out.println(String.format("Каждый должен заплатить %.2f %s", totalCost / numberOfPersons, getCorrectRubleEnding(totalCost / numberOfPersons)));
    }

    public String getCorrectRubleEnding(double money) {
        int moneyAsInt = (int)money;

        if (moneyAsInt % 100 >= 11 && moneyAsInt % 100 <= 14) {
            return "рублей";
        } else if (moneyAsInt % 10 > 1 && moneyAsInt % 10 < 5) {
            return "рубля";
        } else if (moneyAsInt % 10 == 1) {
            return "рубль";
        }

        return "рублей";
    }


}
