import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Привет Мир");
        System.out.println("Вас приветствует Калькулятор - счётчик");
        Scanner scanner1 = new Scanner(System.in);
        int people;
        while (true) {
            System.out.println("На сколько людей разделить счет?");
            if (scanner1.hasNextInt()) {
                people = scanner1.nextInt();
                if (people == 1) {
                    System.out.println("Нет смысла делить счёт на одного. Введите корректное значение гостей.");
                } else if (people < 1) {
                    System.out.println("Вы ввели некоректное значение. Количество гостей должно быть больше одного. Попробуйте ещё раз.");
                } else {
                    break;
                }
            }
        }
        Products.calc(people);
    }
}

