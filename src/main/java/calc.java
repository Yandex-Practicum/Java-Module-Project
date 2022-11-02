import java.util.Scanner;

public class calc {
    public static void input(int numberOfFriends) {
        Scanner scanner = new Scanner(System.in);
        String roubles;
        String[] product = new String[100];
        int numbersOfProduct = 0;
        float sum = 0;
        float price;

        for (int i = 0; i < product.length; i++) {
            System.out.println("Введите название блюда:");
            product[i] = scanner.next();

            do {
                System.out.println("Введите его стоимость с копейками (в формате 0,00): ");
                while (!scanner.hasNextFloat()) {
                    System.out.println("Вы ввели не число! Повторите ввод цены:");
                    scanner.next();
                }
                price = scanner.nextFloat();
            } while (price <= 0);

            sum += price;
            numbersOfProduct++;
            System.out.println("Добавлено!\n    Добавите ещё блюдо? Нет - введите Завершить. Да - введите любой символ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("завершить")) {
                break;
            }
        }

        printAllProducts(numbersOfProduct,product);

        roubles = getRubleAddition((int) sum / numberOfFriends);

        System.out.printf("\nС каждого друга по %.2f %s\n", sum / numberOfFriends, roubles);
    }

    private static void printAllProducts(int numbersOfProduct, String[] product){
        System.out.println("\n\"Добавленные товары:\" ");
        for (int j = 0; j < numbersOfProduct; j++) {
            if (product[j].isEmpty()) {
                break;
            } else {
                System.out.println(product[j]);
            }
        }
    }

    public static String getRubleAddition(int number){
        float predPosCifra = number % 100 / 10;
        if (predPosCifra == 1)
        {
            return "рублей";
        }
        switch (number % 10)
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
}
