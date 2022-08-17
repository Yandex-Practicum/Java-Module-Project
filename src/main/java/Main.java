import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int MIN_NUMBER_OF_GUESTS = 2;
    private static final String FINISH_COMMAND = "завершить";
    private static final double MIN_PRICE = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantityOfGuests = getInputQuantity(scanner);
        List<Item> items = getInputItems(scanner);

    }

    private static int getInputQuantity(Scanner scanner) {
        System.out.println("введите количество человек, на которое следует разделить счет:");
        int inputQuantity;
        while (true) {
            try {
                inputQuantity = scanner.nextInt();
                if (inputQuantity < MIN_NUMBER_OF_GUESTS) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("вы ввели некорректное колчество людей, попробуйте снова:");
                scanner.nextLine();
            }
        }
        return inputQuantity;
    }

    private static List<Item> getInputItems(Scanner scanner) {
        List<Item> items = new ArrayList<>();
        String command = "";
        while (!command.equalsIgnoreCase(FINISH_COMMAND)) {
            System.out.println("введите название товара:");
            Item item = new Item();
            item.setName(scanner.next());
            System.out.println("введите стоимость:");
            try {
                double price = scanner.nextDouble();
                if (price < MIN_PRICE) {
                    throw new InputMismatchException();
                }
                item.setPrice(price);
                items.add(item);
                System.out.println("товар добавлен:");
                System.out.println("для завершения: \"ЗАВЕРШИТЬ\"/ для продолжения: ANY KEY");
                command = scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("некорректная цена, повторите ввод товара сначала \n(возможно нужно ',' вместо '.'):");
                scanner.nextLine();
            }
        }
        return items;
    }
}
