import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numberOfPeople;
        double productPrice;
        String productName;

            Calculator add = new Calculator();
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("На скольких человек необходимо разделить счёт?");
                numberOfPeople = 1;
                try { numberOfPeople = scanner.nextInt();
                    if (numberOfPeople == 1) {
                        System.out.println("Ничего делить не надо");
                    } else if (numberOfPeople <= 0) {
                        System.out.println("Некорректное значение для подсчёта.");
                    }
                    add.getNumberOfPpl(numberOfPeople);//добавляем кол-во людей
                } catch (InputMismatchException e) {
                    System.out.println("Не допустимое значение!");
                    scanner.next();
                }
            } while (numberOfPeople < 2);

            while (true) {
                System.out.println("Введите название товара");
                productName = scanner.next();
                if (productName.equalsIgnoreCase("Завершить")) {
                    break;
                }
                while (true) {
                    System.out.println("Введите стоимость товара в формате 'рубли.копейки' ");
                    try {
                        productPrice = scanner.nextDouble();
                        if (productPrice < 0) {
                            System.out.println("Не допустимое значение!");
                        } else {
                            Product product = new Product(productName, productPrice);
                            add.addProduct(product);//добавляем продукты
                            System.out.println("Товар добавлен, хотите ли вы добавить еще один товар? Если нет, введите: Завершить.");
                            break;}

                        } catch(InputMismatchException e){
                            System.out.println("Не допустимое значение!");
                            scanner.next();
                        }
                    }
                }
            typeGoods();
            add.count();
            add.nameOfCurrency();
        }
    private static void typeGoods() {
        System.out.print("Добавленные товары: ");
    }
}