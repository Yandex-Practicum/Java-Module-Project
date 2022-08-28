import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    String listOfProducts;
    double productPrice;

    public Calculator() {
        listOfProducts = "";
        productPrice = 0.0;
    }

    public void addProduct() { //метод добавления товаров
        while (true) {
            Scanner in = new Scanner(System.in).useLocale(Locale.US);
            System.out.println("Введите название товара: ");
            String productName = in.nextLine();
            if (productName.equalsIgnoreCase("Завершить")) {
                break;
            }
            listOfProducts = productName + "\n";

            System.out.println("Введите стоимость в формате: 'рубли.копейки' [10.45, 11.40]");
            double price = inputPrice();
            productPrice += price;
            System.out.println("Товар успешно добавлен! Хотите добавить ещё один товар? Если да, то продолжайте писать ваш список. Если нет, то напишите \"Завершить\"");
        }
    }

    public double inputPrice() {
        while (true) {
            Scanner in = new Scanner(System.in).useLocale(Locale.US);

            if (in.hasNextDouble()) {
                double price = in.nextDouble();

                if (price >= 0) {
                    return price;
                } else {
                    System.out.println("Стоимость не может быть отрицательная");
                }
            } else {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public static String getRubleAddition(double price)
    {
        int num = (int)Math.floor(price);
        int preLastDigit = num % 100 / 10;
        if (preLastDigit == 1)
        {
            return "рублей";
        }

        switch (num % 10)
        {
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

    public void printInfo(int persona) {
        System.out.println("Добавленные товары: \n" + listOfProducts);
        System.out.printf("Стоимость товаров для каждого по отдельности: %.2f %s \n", productPrice / persona, getRubleAddition(productPrice / persona));
        System.out.printf("Общая стоимость товаров: %.2f %s \n" , productPrice, getRubleAddition(productPrice));
    }
}