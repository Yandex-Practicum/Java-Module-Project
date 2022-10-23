import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    // количество посетителей
    static int numberOfVisitors;
    // объект типа Calculator
    static Calculator calculator;

    public static void main(String[] args) {
        numberOfVisitors = getNumberOfVisitors();
        calculator = new Calculator(numberOfVisitors);
        requestProductFromUser();

        if (calculator.getListOfProducts().isEmpty()) {
            System.out.println("Ничего не было заказано...");
        } else {
            calculator.printResults();
        }
    }

    /* спрашивает у пользователя, на скольких человек необходимо разделить счёт
    и возвращает это значение
     */
    private static int getNumberOfVisitors() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("На скольких человек нужно разделить счет?");
            String response = scanner.next();
            if (isNumeric(response)) {
                int intValue = Integer.parseInt(response);
                if (intValue <= 1) {
                    System.out.println("Значение должно быть больше 1...");
                } else {
                    return intValue;
                }
            } else {
                System.out.println("Введите корректное значение...");
            }
        }
    }

    // Проверяет, является ли введеное пользователем значение целочисленным числом - true, иначе - false
    private static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Проверяет, является ли введеное пользователем значение цислом с дробной частью - true, иначе - false
    private static boolean isDoubleNumeric(String string) {
//        try {
//            Double.parseDouble(string);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
        String decimalPattern = "([0-9]*)\\.([0-9]*)";
        return Pattern.matches(decimalPattern, string);
    }

    /* Запрашивает наименование и стоимость продукта у пользователя и добавляет объекты
     класса Product в объект calculator класса Calculator, пока пользователь не введет команду
     "Завершить"
     */
    private static void requestProductFromUser() {
        Scanner scanner = new Scanner(System.in);
        String nameOfProduct;
        double value;

        while (true) {
            System.out.println("Введите, пожалуйста, название товара. (Чтобы завершить процесс, введите \"Завершить\")");
            String response = scanner.next();
            if (response.equalsIgnoreCase("завершить")) {
                return;
            } else {
                nameOfProduct = response;
                while (true) {
                    System.out.println("Ведите, пожалуйста, стоимость товара в формате XX.YY (где ХХ - рубли, YY - копейки)...");
                    response = scanner.next();
                    if (isDoubleNumeric(response)) {
                        value = Double.parseDouble(response);
                        break;
                    } else {
                        System.out.println("Введите корректное значение...");
                    }
                }
                calculator.addProductToList(new Product(nameOfProduct, value));
                System.out.println("Продукт успешно добавлен в калькулятор");
            }
        }
    }
}
