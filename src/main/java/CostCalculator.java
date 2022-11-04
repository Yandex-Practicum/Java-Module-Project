import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class CostCalculator {
    private final int countOfPerson;
    private double costSum = 0.0;
    private String products = "";

    public CostCalculator(int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    public void addProducts() {
        do {
            Product product = inputProduct();
            addProductInCost(product);
        } while (hasNextProduct());

        printCost();
    }

    private Product inputProduct() {
        String productName;
        float productCost;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        do {
            System.out.println("Введите название товара из счета: ");
            productName = scanner.nextLine();
        } while (productName.isEmpty());

        do {
            System.out.println("Введите стоимость указанного товара в виде рубли[.копейки]: ");
            while (!scanner.hasNextFloat()) {
                System.out.println("Введенное значение не является числом или введено в другом формате. Повторите ввод стоимости указанного товара:");
                scanner.next();
            }

            productCost = scanner.nextFloat();
            if (productCost < 0.0f) {
                System.out.println("Стоимость товара в чеке не может быть отрицательной.");
            }

        } while (productCost < 0.0f);

        return new Product(productName, productCost);
    }

    private void addProductInCost(Product product) {
        Formatter formatter = new Formatter(Locale.US);
        products += formatter.format("\n%s [%.2f]", product.name, product.cost).toString();
        costSum += product.cost;

        String formatString = String.format("Товар \"%s\" стоимостью %.2f руб. добавлен в чек.", product.name, product.cost);
        System.out.println(formatString);
    }

    private boolean hasNextProduct() {
        String answer;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Хотите добавить в чек еще один товар? (Введите слово 'Завершить' для окончания ввода товаров в чек или любой символ чтобы продолжить): ");
            answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Завершить")) {
                return false;
            }
        } while (answer.isEmpty());

        return true;
    }

    private void printCost() {
        System.out.println("Добавленные товары: ");
        System.out.println(products);

        double sumPerPerson = costSum / countOfPerson;

        Formatter formatter = new Formatter(Locale.US);
        String formatString = formatter.format("Сумма на человека: %.2f %s", sumPerPerson, getRublesPlural(sumPerPerson)).toString();
        System.out.println(formatString);
    }

    private String getRublesPlural(double sum) {

        int rubles = (int) Math.floor(sum);

        int lastTwoDigit = rubles % 100;
        if (lastTwoDigit >= 11 && lastTwoDigit <= 14) {
            return "рублей.";
        } else {
            int lastDigit = rubles % 10;

            switch (lastDigit) {
                case 1:
                    return "рубль.";
                case 2:
                case 3:
                case 4:
                    return "рубля.";
                default:
                    return "рублей.";
            }
        }
    }
}
