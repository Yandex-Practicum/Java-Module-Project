import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    ArrayList<Product> products = new ArrayList<>(); // Создаем объект содержащий список продуктов.
    float total;

    public void calculate() {
        Scanner scanner = new Scanner(System.in); // Создаём новый объект класса Scanner
        scanner.useLocale(Locale.US);             // Настраиваем объект Scanner на американскую локаль.

        while (true) {
            System.out.println("Введите наименование товара.");
            String name = scanner.next(); // Присваиваем переменной ввод с клавиатуры.
            System.out.println("Введите стоимость товара ХХ руб. ХХ коп.");
            if (scanner.hasNextFloat()) {  // Проверяем ввод с клавиатуры. Должен быть Float.
                float cost = scanner.nextFloat(); // Присваиваем переменной ввод с клавиатуры.
                    if (cost < 0) {       // Проверяем введеную стоимость товара на отрицательное значение.
                        System.out.println("Стоимость товара не может быть отрицательной");
                        continue; // Если условие if выполнено то отправляет в начало цикла.
                    }

                Product product = new Product(cost, name);  // Создал новый объект класса Product с двуя параметрами.
                products.add(product);    // Добавляем продукт в список продуктов.
                total = total + cost;     // Суммируем стоимость введенных товаров
                System.out.println("Товар добавлен");
                System.out.println("Вы хотите добавит еще один продукт ?   Да или Завершить");
                String addName = scanner.next(); // Присваиваем переменной ввод с клавиатуры.
                if (addName.equalsIgnoreCase("завершить")) break;
            } else {
                System.out.println(String.format("Вы сделали не корректный ввод %s", scanner.next()));
            }
        }
    }

}
