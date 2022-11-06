package calculator;

import java.util.*;

public class Calculator {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Product> products = new ArrayList<>();

    public void calculate() {
        int numberOfPersons = addNumberOfPersons();
        double sum = addProducts();
        double result = sum / numberOfPersons;

        printAllProducts();
        printResult(result);
    }

    private int addNumberOfPersons() {
        int numberOfPersons = 0;

        System.out.println("Введите количество персон");

        while (numberOfPersons < 2) {
            if (!scanner.hasNextInt()) {
                System.out.println("Вы ввели некорректное значение \nПопробуйте еще раз");
                scanner.next();
            } else {
                numberOfPersons = scanner.nextInt();
                if (numberOfPersons < 2) {
                    System.out.println("Количество персон должно быть более 1 \nПопробуйте еще раз");
                }
            }
        }

        return numberOfPersons;
    }

    private double addProducts() {
        String exit = "Завершить";
        double sumOfProducts = 0.0;

        do {
            String productTitle = addProductTitle();
            double productPrice = addProductPrice();
            Product product = new Product(productTitle, productPrice);
            sumOfProducts += productPrice;

            products.add(product);
            System.out.println("Товар успешно добавлен");
            System.out.println("Хотите добавить еще товар? " +
                    "\nЕсли да, то введите любой символ " +
                    "\nЕсли хотите завершить, то введите 'Завершить'");

        } while (!scanner.next().equalsIgnoreCase(exit));

        return sumOfProducts;
    }

    private String addProductTitle() {
        System.out.println("Введите название товара");

        return scanner.next();
    }

    private double addProductPrice() {
        double price = 0.0;

        System.out.println("Введите стоимость товара в формате 'рубли,копейки' [10,45, 11,40]");

        while (price <= 0.01) {
            if (!scanner.hasNextDouble()) {
                System.out.println("Вы ввели некорректное значение " +
                        "\nВведите стоимость товара в формате 'рубли,копейки' [10,45, 11,40] " +
                        "\nПопробуйте еще раз");
                scanner.next();
            } else {
                price = scanner.nextDouble();
                if (price <= 0.0) {
                    System.out.println("Стоимость товара должна быть больше 0 \nПопробуйте еще раз");
                }
            }
        }

        return price;
    }

    private void printAllProducts() {
        System.out.println("Добавленные товары:");

        for (Product product : products) {
            System.out.println(product.getTitle() + " : " + String.format("%.2f", product.getPrice()));
        }
    }

    private void printResult(double price) {
        String format = String.valueOf((int) price);
        String result;

        if (format.endsWith("11")) {
            result = "рублей";
        } else if (format.endsWith("1")) {
            result = "рубль";
        } else if (format.endsWith("2") || format.endsWith("3") || format.endsWith("4")) {
            result = "рубля";
        } else {
            result = "рублей";
        }

        System.out.println("Сумма к оплате: " + String.format("%.2f", price) + " " + result);
    }
}
