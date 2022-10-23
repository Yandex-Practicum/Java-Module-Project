import java.util.Scanner;

public class Persons {

    int countPersons = 1;
    String exit_word;

    // метод запрашивает кол-во человек
    void enterPersons() {

        Scanner scanner = new Scanner(System.in);

        while (countPersons < 2) {

            System.out.println("Введите кол-во человек (целое число от 2 до 2147483647) или введите '"+exit_word+"' для выхода:");

            String consoleData = scanner.next();

            // команда Завершить
            if (consoleData.equalsIgnoreCase(exit_word)) {
                System.out.println(exit_word);
                break;
            }

            // проверяем ввод на int
            if (isInteger(consoleData)) {
                // преобразуем ввод в int
                countPersons = Integer.valueOf(consoleData);
                if (countPersons < 2) {
                    // введено целое число, но не соответсвует параметрам
                    System.out.println("Ошибка.");
                } else {
                    // введено правильное число
                    break;
                }
            } else {
                // Введены символы которые не преобразуются в int
                System.out.println("Ошибка.");
            }
        }
    }

    private static boolean isInteger(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    Persons(String exit_word) {
        this.exit_word = exit_word;
    }
}
