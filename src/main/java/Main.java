/* Если консоль не отображает кирилицу

В Android Studio идем в меню Help - Edit Custom VM Options

Прописать:
-Dconsole.encoding=UTF-8
-Dfile.encoding=UTF-8

Перезапустить Android Studio
*/

public class Main {

    // Слово для выхода, можно изменить в одном месте
    static String exit_word = "завершить";

    public static void main(String[] args) {

        System.out.println("= КАЛЬКУЛЯТОР СЧЁТА =");

        // создаем объект класса Persons, передаем ему слово для выхода
        Persons persons = new Persons(exit_word);
        // Вызываем метод запроса кол-ва человек
        persons.enterPersons();

        if (persons.countPersons>1) {
            System.out.println("Кол-во человек: " + persons.countPersons);

            // создаем объект класса Calculator, передаем ему слово для выхода
            Calculator calculator = new Calculator(exit_word);
            // вызываем метод запроса товаров с ценами
            calculator.addProducts();

            if (calculator.countProducts>0) {
                // выводим результат
                calculator.printResult(persons.countPersons);
            } else {
                System.out.println("Продукты не добавлены.");
            }
        }
    }

}

