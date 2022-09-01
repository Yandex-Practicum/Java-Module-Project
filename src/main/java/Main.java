import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int peoplesCount;
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в Калькулятор счёта");

        while (true) {
            System.out.println("Введите количество людей");
            peoplesCount = scanner.nextInt();
            if (peoplesCount > 1) {
                System.out.println("Спасибо");
                break;
            } else {
                System.out.println("Количество людей должно быть больше одного");
            }
        }

        while (true) {
            String productName;
            double productPrice;

            System.out.println("Если вы хотите добавить товар введите его название, если хотите закончить введите: Заверишть");
            productName = scanner.next();
            if (productName.equalsIgnoreCase("завершить")) {
                System.out.println("Добавленные товары");
                calculator.printProducts();
                calculator.eachPortion(peoplesCount);
                break;
            } else {
                while(true) {
                    System.out.println("Введите стоимость товара в формате: рубли.копейки");
                    productPrice = scanner.nextDouble();
                    if (productPrice < 0.01) {
                        System.out.println("Стоимость товара не может быть меньше 1 копейки");
                    } else {
                        break;
                    }
                }
                calculator.addProduct(productName, productPrice);
                System.out.println("Товар успешно добавлен.");
            }
        }
    }
}
