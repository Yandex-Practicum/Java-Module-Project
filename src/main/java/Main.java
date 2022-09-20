import java.util.Scanner;

public class Main {

    public static Calculator initializeCalculator(Scanner inputScanner) {
        int countFriends = -1;
        // Получение количества друзей.
        while (countFriends <= 1) {
            System.out.println("На скольких человек необходимо разделить счёт?");

            if (inputScanner.hasNextInt()) {
                countFriends = inputScanner.nextInt();

            } else {
                System.out.println("[Ошибка] Необходимо ввести целочисленное количество друзей.");
                inputScanner.next();
                continue;

            }
            if (countFriends == 1) {
                System.out.println("[Ошибка] Нет смысла ничего считать и делить.");

            } else if (countFriends < 1) {
                System.out.println("[Ошибка] " + countFriends  +  " - это некорректное значение для подсчёта.");

            }
        }

        // Инициализация калькулятора в зависимости от количества друзей.
        return new Calculator(countFriends);
    }

    // Добавление товаров в калькулятор.
    public static void addProductsToCalculator(Scanner inputScanner, Calculator calculator) {
        while (true) {
            System.out.println("Введите название товара:");
            String product = inputScanner.next();

            System.out.println("Введите цену товара в формате рубли.копейки:");
            while (true) {
                if (inputScanner.hasNextDouble()) {
                    double productCost = inputScanner.nextDouble();
                    if (productCost < 0) {
                        System.out.println("[Ошибка] Введите корректную цену товара: цена не может быть отрицательной.");
                    } else {
                        calculator.addProductCost(new Product(product, productCost));
                        System.out.println("Товар успешно добавлен в корзину.");
                        break;
                    }
                } else {
                    inputScanner.next();
                    System.out.println("[Ошибка] Введите корректную цену товара в формате: рубли.копейки");
                }
            }

            System.out.println("Хотите ли добавить ещё один товар? завершить/что-либо");
            String answer = inputScanner.next();
            if (answer.equalsIgnoreCase("завершить")) {
                break;
            }
        }
    }

    public static void printEachFriendAmount(Calculator calculator) {
        double eachFriendAmount = calculator.getEachFriendAmount();
        String rubles = "";
        switch ((int)eachFriendAmount % 10) {
            case 1:
                rubles = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                rubles = "рубля";
                break;
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                rubles = "рублей";
                break;
        }
        System.out.println("Добавленные товары:\r\n" + calculator.products + String.format("%.2f", eachFriendAmount) + " " + rubles);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Calculator calculator = initializeCalculator(inputScanner);
        addProductsToCalculator(inputScanner, calculator);
        printEachFriendAmount(calculator);
    }
}
