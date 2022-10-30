import java.util.Scanner;

public class Product {
    Scanner scanner = new Scanner(System.in);
    float priceOfProduct; // переменная отвечающая за стоимость каждого товара
    float totalSumOfProducts; // переменная отвечающая за суммирование
    String nameOfProduct; // строка содержащая название продукта
    String totalProducts = ""; // строка сохраняющая все продукты
    String endOfCalculate; // строка для завершения бесконечного цикла

     void saveProducts() {
        while(true) {
             System.out.println("Введите название товара: ");
             nameOfProduct = scanner.next();
             totalProducts = totalProducts.concat(nameOfProduct + "\n");
             System.out.println("Введите стоимость товара в формате 'рубли.копейки' [10.45, 11.40]");
             testFloatPrice();
             totalSumOfProducts += priceOfProduct;
             System.out.println("Товар успешно добавлен");
             System.out.println("Желаете ли Вы добавить еще 1 товар? (Введите 'Завершить' для завершения программы, любой другой ввод продолжит выполнение программы)");
             endOfCalculate = scanner.next();
             if (endOfCalculate.equalsIgnoreCase("Завершить"))
                 break;
         }
        System.out.println("Итоговая сумма всех товаров: " + totalSumOfProducts);
        System.out.println("Добавленные товары:\n" + totalProducts);
    }

    void testFloatPrice() { // проверка значения float
        while(!scanner.hasNextFloat()) {
            System.out.println("Неверный формат, попробуйте еще раз:");
            scanner.next();
        }
        priceOfProduct = scanner.nextFloat();
        while(priceOfProduct < 0) {
            System.out.println("Значение меньше нуля, попробуйте еще раз:");
            while (!scanner.hasNextFloat()) {
                scanner.next();
            }
            priceOfProduct = scanner.nextFloat();
        }
    }
}
