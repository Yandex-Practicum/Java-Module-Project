import java.util.Scanner;

public class Calculator {
    String products = "\n"; //Аккумулируем товары
    String prodName; //Наименование 1 шт из сканера
    String exit = "завершить"; // Команда прерывания
    String exitMessage = "Программа завершена"; // Сообщение после прерывания
    double price = 0.00; //цена 1 шт вводимая пользователем
    double sum = 0.00; // сумма
    int countProducts; // Количество введенных товаров

    public void consoleProducts() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Введите название товара или '%s' для выхода\n", exit); // эта строка юзается для первого и последующих запрсов ввода товаров
            prodName = scanner.next();
            if (prodName.equalsIgnoreCase(exit)) {
                System.out.println(exitMessage);
                break;
            }
            while (true) {
                System.out.println("Введите стоимость товара в формате рубли.копейки. Например: 10,45");
                price = scanner.nextDouble();
                if (price > 0.00) {
                    countProducts++;
                    products = products + prodName + " ";
                    sum += price;
                    break;
                } else {
                    System.out.println("Ошибка ввода стоимости");
                }
            }
            System.out.println("Товар успешно добавлен.");
        }
        double bill = sum / Main.persons;
        System.out.printf("Введены следующие товары, в количестве %d шт.:", countProducts);
        System.out.print(products + "\n");
        System.out.println("Сумма на одного человека: " + String.format("%.2f", bill) + " " + rubles(bill));
    }
    public String rubles(double a) {
        int rub = (int) Math.floor(a);
        if (rub % 100 > 5 && rub <= 20) {
            return "рублей";
        } else if (rub % 10 == 1) {
            return "рубль";
        } else if (rub % 10 > 1 && rub % 10 < 5) {
            return "рубля";
        }
        return "рублей";
    }
}