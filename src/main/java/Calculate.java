import java.util.Scanner;

public class Calculate {

        class Product {
            String name;
            float price;

            void input() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите наименование товара");
                name = scanner.next();

                System.out.println("Введите стоимость товара в формате 'рубли.копейки'");
                while (true) {
                    if (scanner.hasNextFloat()) {
                        price = scanner.nextFloat();
                        if (price < 0) {
                            System.out.println("Введено недопустимое значение. Введите целое число больше 0");
                            scanner.nextLine();
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Введено недопустимое значение. Введите целое число больше 0");
                        scanner.nextLine();
                    }
                }
            }
        }

        Product product = new Product(); // создали новый объект класса Product
        float sum = 0.00f; // переменная для хранения суммы чека
        String order = ""; // переменная для хранения перечня продуктов
        Scanner scannerAdd = new Scanner(System.in);
        int guests = CountOfGuests.countOfGuests(); // число гостей, на которых делим счет

        public void bill() {
            while (true) {
                product.input();

                order = order.concat(product.name).concat("\n");
                sum = sum + product.price;

                System.out.println("Товар успешно добавлен в калькулятор!");
                System.out.println("Чтобы завершить добавление товаров введите команду Завершить.\n\nДля продолжения внесения товаров в калькулятор введите любое другое значение.");
                String add = scannerAdd.next();
                if (add.equalsIgnoreCase("Завершить")) {
                    System.out.println("Список товаров:\n" + order);
                    float guestDebt = sum / guests; // расчёт суммы для каждого гостя
                    if ((Math.floor(guestDebt) % 100 >= 11) && (Math.floor(guestDebt) % 100 <= 19)) {
                        String format = "Каждый гость должен: %.2f рублей";
                        System.out.println(String.format(format, guestDebt));
                    } else if (Math.floor(guestDebt) % 10 > 5) {
                        String format = "Каждый гость должен: %.2f рублей";
                        System.out.println(String.format(format, guestDebt));
                    } else if ((2 <= Math.floor(guestDebt) % 10) && (Math.floor(guestDebt) % 10 <= 4)) {
                        String format = "Каждый гость должен: %.2f рубля";
                        System.out.println(String.format(format, guestDebt));
                    } else {
                        String format = "Каждый гость должен: %.2f рубль";
                        System.out.println(String.format(format, guestDebt));
                    }
                    break;
                }
            }
        }
    }
