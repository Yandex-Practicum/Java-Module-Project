import java.util.Scanner;

import jdk.nashorn.internal.ir.WhileNode;
import jdk.nashorn.internal.objects.annotations.Where;

public class Main {
    static String end = "Завершить"; // проверка для завершения ввода продуктов

    public static void main(String[] args) {
        People.howPeople();
        Product.calculate();

        // Вывод результата
        double costPerson = Product.cost / People.countPeople;
        System.out.println("Добавленные товары:\n" + Product.name);
        System.out.printf("%.2f", Math.floor(costPerson));
        System.out.print(" рублей.");
    }
}
