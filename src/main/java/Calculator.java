import java.util.Scanner;

public class Calculator {
    double total;
    String products = "Добавленные продукты:\n";
    Scanner scanner = new Scanner(System.in);

    void addProducts() {
        while (true) {
            Product product = new Product();
            System.out.println("Введите наазвание товара:");
            product.name = scanner.next();
            while (true) {

                System.out.println("Введите стоимость товара в формате ('рубли.копейки' [10.45, 11.40]):");

                String strPriceProduct = scanner.next();
                try {
                    product.price = Double.parseDouble(strPriceProduct);
                } catch (NumberFormatException error) {
                    System.out.println("Стоимость указана в некорректном формате.");
                    continue;
                }
                if (product.price > 0) {
                    break;
                }
                System.out.println("Ошибка. Значение стоимости введено некорректно.");
            }
            System.out.println("Товар уcпешно добавлен. Хотите добавить еще товар?");
            total = total + product.price;
            products = products + product.name + "\n";
            String NoOrYes = scanner.next();
            if (NoOrYes.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
    }

    double calcPriceForPerson(int countGuest) {
        return total / (double) countGuest;
    }

    String getRubleAddition(double moneyValue) {
        int preLastDigit = (int)moneyValue % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }
        int LastDigit = (int)moneyValue % 10;
        switch (LastDigit) {
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
