/**
 * Калькулятор счёта
 * @author Fandorina Polina
 * В данной задаче не вызываются несколько методов многократно,
 * поэтому нет смысла загружать JVM и создавать лишиние классы и функции,
 * хотя разделить на логические блоки можно. Программа линейная, где каждая операция выполняется последовательно.
 */

public class Main {


    public static void main(String[] args) {

        Calculate calculate = new Calculate();
        calculate.initDataPersons();
        calculate.addingProducts();
        calculate.endingOfRubles();
    }
}


