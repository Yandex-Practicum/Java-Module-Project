import java.util.Scanner;

public class Persons {

    int countPersons = 1;

    // метод запрашивает кол-во человек
    void enterPersons() {

        Scanner scanner = new Scanner(System.in);

        while (countPersons < 2) {

            System.out.printf("Введите кол-во человек (целое число от 2 до 2147483647) или введите '%s' для выхода:%n", Main.exit_word);

            String consoleData = scanner.next();

            // команда Завершить
            if (consoleData.equalsIgnoreCase(Main.exit_word)) {
                System.out.println(Main.exit_word);
                break;
            }

            // проверяем ввод на int
            if (isInteger(consoleData)) {
                // преобразуем ввод в int
                countPersons = Integer.parseInt(consoleData);
                if (countPersons < 2) {
                    // введено целое число, но не соответсвует параметрам
                    System.out.println("Ошибка");
                } else {
                    // введено правильное число
                    System.out.printf("Кол-во человек: %d%n", countPersons);
                    break;
                }
            } else {
                // Введены символы которые не преобразуются в int
                System.out.println("Ошибка");
            }
        }
    }

    // проверка на преобраование строки в int
    private static boolean isInteger(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
