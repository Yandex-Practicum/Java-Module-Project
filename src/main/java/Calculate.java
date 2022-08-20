import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Calculate {
    private double fullSum = 0;
    private int maxLength = 0;
    private List<Product> listOfProducts = new LinkedList<>();

    public void getProducts() {
        //for testing
        //File file = new File("testing");
        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);
        String command = "";
        int counter = 1;
        System.out.println("Теперь давай добавим товары в список, ");
        System.out.println("Когда товары закончатся используй пожалуйста команду 'завершить'");
        while (!command.equalsIgnoreCase("завершить")) {
            System.out.println("Товар номер: " + counter);
            counter++;
            System.out.println("Имя: ");
            String name = scanner.nextLine();
            double price = -1;
            while (price <= 0.0) {
                System.out.println("Стоимость в формате 'рубли.копейки': ");
                String temp = scanner.nextLine();
                try {
                    price = Double.parseDouble(temp);
                    if (price <= 0.0)
                        System.out.println("Стоимость не бывает меньше 0, попробуй ещё раз");
                    else
                        maxLength = Math.max(maxLength, (name.length() + temp.indexOf('.') + 7));
                } catch (NumberFormatException exception) {
                    System.out.println("Кажется что-то пошло не так, это не похоже на число," +
                            " давай попробуем ещё раз");
                    price = -1;
                }
            }
            listOfProducts.add(new Product(name, price));
            fullSum += price;
            System.out.println("Добавить еще один товар или завершить?: ");
            command = scanner.nextLine();
        }
    }

    public void printBill() {
        if (listOfProducts.isEmpty()) {
            System.out.println("Ошибка, заполните пожалуйста сначала список товаров");
            getProducts();
        }
        System.out.println("Добавленные товары:");
        int counter = 1;
        for (Product product : listOfProducts) {
            System.out.print(counter + "." + product.getName());
            printSpaces(maxLength - product.getLengthIntPart() - product.getName().length() + 2);
            System.out.println(String.format(Locale.US, "%.2f", product.getPrice()));
            counter++;
        }
        printSpaces(maxLength + 5);
        System.out.println(String.format(Locale.US, "\nИтого: %.2f", fullSum));
    }

    public void divideBill(int n) {
        if (listOfProducts.isEmpty()) {
            System.out.println("Ошибка, заполните пожалуйста сначала список товаров");
            getProducts();
            printBill();
        }
        double result = fullSum / n;
        String temp = "С каждого по: %.2f " + rublesFormatter((int) Math.floor(result));
        System.out.println(String.format(Locale.US, temp, result));
    }

    private void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("_");
        }
    }

    private String rublesFormatter(int ruble) {
        if ((ruble % 100) >= 11 && (ruble % 100) <= 19)
            return "рублей";
        else
            switch (ruble % 10) {
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
