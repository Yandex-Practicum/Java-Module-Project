import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // вспомогательный объект для посчета посетителей и работы с товарами
        Product assistant = new Product();
        // подсчет количество человек
        assistant.calculatePersons();

        // создание калькулятора
        Calculator calculator = new Calculator();

        // добавление товара и его стоимости в калькулятор
        assistant.addProduct(calculator);

        // вывод результатов
        assistant.outputResult(calculator);
    }
}