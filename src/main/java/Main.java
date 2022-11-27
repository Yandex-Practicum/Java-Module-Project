import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Persons persons = new Persons();  // Создаём новый объект класса Persons
        persons.read();      //  Вызываем метод read класса Persons.

        Calculator calculator = new Calculator(); // Создаём новый объект класса Persons
        calculator.calculate();  //  Вызываем метод calculate класса Calculator.

        for (Product product : calculator.products) {  // Из объекта calculator класса Calсulator в вытаскиваем список продуктов.
            System.out.println(String.format(Locale.US, "Добавленные товары: %s - %.2f Руб.", product.name, product.cost)); // Для каждого продукта из списка печатаем его имя и цену.
        }
        float averageCheck = (float) (calculator.total / persons.count); // Подсчитываем средний чек
        String rub = "ру";
        if (averageCheck < 2 && averageCheck >= 1) {
            rub = rub + "бль";
        } else {
            rub = rub + "бля";
        }
        System.out.println(String.format(Locale.US, "%.2f  %s  с каждого гостя.", averageCheck, rub));
    }

}
