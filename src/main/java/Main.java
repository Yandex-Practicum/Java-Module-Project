
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
   // public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
       // System.out.println("Привет Мир");


