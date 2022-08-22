import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductCalculator {
    private static final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Product> products = new ArrayList<>();
    private float totalPriceOfAllProducts = 0.00f;
    private final int peopleCount;


    ProductCalculator(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.totalPriceOfAllProducts += product.getPrice();
    }

    public float getPricePerOnePerson() {
        return totalPriceOfAllProducts / peopleCount;
    }

    public float getTotalAmountOfProducts() {
        return this.totalPriceOfAllProducts;
    }

    public void showAllProducts() {
        System.out.println("Список продуктов:");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d) Название: \"%s\", стоимость: %.2f %s. \n",
                    i + 1,
                    products.get(i).getName(),
                    products.get(i).getPrice(),
                    getCorrectEnding(products.get(i).getPrice()));
        }
    }

    public void showResult() {
        showAllProducts();
        System.out.printf("Конечная стоимость всего товара: %.2f %s \n", getTotalAmountOfProducts(), getCorrectEnding(getTotalAmountOfProducts()));
        System.out.printf("Каждый человек должен будет заплатить: %.2f %s", getPricePerOnePerson(), getCorrectEnding(getPricePerOnePerson()));
    }

    private String getCorrectEnding(float rubles) {

        float roundedOffRubles = (float) Math.floor(rubles);

        if (roundedOffRubles == 1.00f) {
            return "рубль";
        } else if (roundedOffRubles > 1 && roundedOffRubles < 5) {
            return "рубля";
        } else {
            return "рублей";
        }
    }

    public void inputProducts() {
        String productName;
        float productPrice;


        while (true) {
            System.out.print("Введите название товара: ");
            productName = scanner.next();

            System.out.println("Введите стоимость товара стоимость в формате: \"'рубли.копейки' [10.45, 11.40]\"");
            try {
                productPrice = scanner.nextFloat();
            } catch (InputMismatchException er) {
                System.out.println("Цена товара некорректна, введите товар заново.");
                scanner.nextLine();
                continue;
            }

            if (productPrice <= 0.0f) {
                System.out.println("Цена товара некорректна, введите товар заново.");
                continue;
            }

            Product product = new Product(productName, productPrice);
            addProduct(product);

            System.out.printf("Вы успешно довавила товар \"%s\" \n", productName);

            System.out.printf("Предварительная стоимость всех товаров = %.2f %s\n", getTotalAmountOfProducts(), getCorrectEnding(getTotalAmountOfProducts()));


            System.out.println("\nВедите \"Завершить\", если добавили всё нужные товары");
            System.out.println("Добавить ещё товар?");

            String answer = scanner.next();

            if (answer.equalsIgnoreCase("завершить")) {
                showResult();
                break;
            }
        }
    }
}
