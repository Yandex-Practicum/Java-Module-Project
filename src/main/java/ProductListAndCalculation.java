import java.util.Scanner;

public class ProductListAndCalculation { //класс для составления списка товаров и расчета цены
    static Scanner scanner = new Scanner(System.in);
    int numberOfGuests; // поле количество гостей
    String productName = ""; //поле название товара
    float productPrice = 0.00f; //поле цена товара
    float partPrice = 0.00f; // поле долг каждого гостя

    public void calculator() { //м-д, общий
        askGuests(); //узнаем количество гостей
        askNameAndPrice(); // составляем список товаров и и считаем их общую сумму
        stillTheBill();// считаем сколько должен каждый гость
    }

    public void askNameAndPrice() {
        System.out.println("\nВведите название товара или введите \"Завершить\" для выхода из программы:");
        while (true) { // бесконечный цикл для ввода товаров в список
            String scannerName = scanner.next();
            String end1 = "Завершить", end2 = "Pfdthibnm"; // строка end2 на случай, если пользователь введет "Завершить", забыв переключить раскладку на RU
            if (scannerName.equalsIgnoreCase(end1) || scannerName.equalsIgnoreCase(end2)) {
                break;
            } else {
                productName = productName + scannerName + "\n";
                askPrice();
            }
        }
    }

    public void askGuests() {
        System.out.println("Калькулятор счёта (version 1.0)\n"); // версия программы
        System.out.println("Здравствуйте!\nВ данном приложении вы можете составить список товаров и честно узнать, сколько каждый человек должен заплатить по счёту.\nВведите количество человек (целое число от 2 до 2147483647), на которое необходимо разделить счет:");
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("\nВы ввели не числовое значение! \nНеобходимо ввести целое число от 2 до 2147483647!");
                scanner.next();
                continue;
            } else {
                numberOfGuests = scanner.nextInt();
            }
            if (numberOfGuests <= 1) {
                System.out.println("\nВведеного значения недостаточно для расчёта! Значение должно быть равно от 2 до 2147483647. Попробуйте еще раз.");
            } else {
                System.out.println("\nОтлично!\nВведенное количество человек = " + numberOfGuests);
                break;
            }
        }
    }

    public void askPrice() {
        System.out.println("\nВведите цену товара в формате \"рубли,копейки\", например 14,78:");
        String errorPrice = "\nВведена некорректная цена. Попробуйте еще раз:";
        float scannerPrice = scanner.nextFloat();
        while (scannerPrice <= 0) {
            System.out.println(errorPrice);
            scannerPrice = scanner.nextFloat();
        }
        productPrice = productPrice + scannerPrice;
        System.out.println("\nТовар успешно добавлен!\n\nЕсли хотите продолжить введите еще одно название товара.\nЕсли список товаров готов ведите \"Завершить\".");
    }

    public void stillTheBill() {
        System.out.println("\nСписок добавленных товаров:\n" + productName + "\nСумма всех добавленных товаров - " + String.format("%.2f", productPrice) + " рублей.");
        partPrice = productPrice / numberOfGuests;
        finishRight(partPrice);
    }

    public void finishRight(float assay) {
        String willPay = "Каждый человек обязан заплатить - %.2f %s.";
        String rubles1 = "рублей", rubles2 = "рубль", rubles3 = "рубля";
        if (Math.floor(assay) % 100 >= 11 && Math.floor(assay) % 100 <= 19) {
            System.out.printf(willPay, assay, rubles1);
        } else {
            switch ((int) (Math.floor(assay) % 10)) {
                case 1:
                    System.out.printf(willPay, assay, rubles2);
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.printf(willPay, assay, rubles3);
                    break;
                default:
                    System.out.printf(willPay, assay, rubles1);
                    break;
            }
        }
    }
}