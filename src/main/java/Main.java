/* Если консоль не отображает кирилицу

В Android Studio идем в меню Help - Edit Custom VM Options

Прописать:
-Dconsole.encoding=UTF-8
-Dfile.encoding=UTF-8

Перезапустить Android Studio
*/

public class Main {

    // Слово для выхода, можно изменить в одном месте
    public static final String exit_word = "завершить";

    public static void main(String[] args) {

        System.out.println("= КАЛЬКУЛЯТОР СЧЁТА =");

        // создаем объект класса Persons
        Persons persons = new Persons();
        // Вызываем метод запроса кол-ва человек
        persons.enterPersons();

        if (persons.countPersons>1) {

            // создаем объект класса Calculator
            Calculator calculator = new Calculator();
            // вызываем метод запроса товаров с ценами
            calculator.addProducts();

            if (calculator.countProducts>0) {
                // выводим результат передавая калькулятору кол-во персон
                calculator.printResult(persons.countPersons);
            } else {
                System.out.println("Продукты не добавлены");
            }
        }
    }

}

