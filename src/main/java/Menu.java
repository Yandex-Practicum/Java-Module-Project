import java.util.Scanner;

public class Menu {

    public void executeMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print("Введите количество покупателей: ");
            String str = scanner.next();
            if (Utils.isNumeric(str)) {
                int numberOfPeople = Integer.parseInt(str);
                if (numberOfPeople > 1) {
                    Calculator.setNumberOfPeople(numberOfPeople);
                    addProduct();
                    break;
                } else if (numberOfPeople == 0) {
                    System.out.println("Количество покупателей не может быть равно нулю");
                } else if (numberOfPeople == 1) {
                    System.out.println("Введите хотя бы 2");
                } else {
                    System.out.println("Число должно быть положительным");
                }
            } else if (Utils.isDouble(str)) {
                System.out.println("Хорошая шутка))) Попробуйте ещё разок ;D");
            } else {
                System.out.println("Не верный формат ввода. Введие число цифрами от 2 до 2147483647");
            }
        }
    }

    public void addProduct() {
        Scanner scanner;
        String nameOfProduct;
        String prize;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Введите название товара: ");
            nameOfProduct = scanner.nextLine();
            System.out.print("Введите стоимость товара в формате: \"рубли.копейки\" например 10.45: ");
            while (true) {
                prize = scanner.nextLine();
                if (Utils.isDouble(prize)) {
                    if (Double.parseDouble(prize) < 0) {
                        System.out.println("Цена не может быть меньше нуля");
                    } else {
                        Calculator.addProduct(new Product(nameOfProduct, Double.parseDouble(prize)));
                        System.out.println("Товар добвлен!!!");
                        System.out.println();
                        break;
                    }
                } else {
                    System.out.println("Не верный формат ввода цены, попробуйте ещё");
                }
            }
            System.out.println("Чтобы продолжить вводить товары введите любой символ. Если это все товары наберите \"Завершить\"");
            if (scanner.next().equalsIgnoreCase("Завершить")) {
                Calculator.showProducts();
                break;
            } else {
                System.out.println("Продолжим ввод товаров");
                System.out.println();
            }
        }
    }
}
