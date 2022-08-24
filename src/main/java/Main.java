import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        while (true) {
            Scanner in = new Scanner(System.in);  //считывает, сколько человек написал пользователь
            System.out.println("На сколько человек необходимо разделить счёт?");

            if (in.hasNextInt()) { //проверяем ввёл ли пользователь целое число. Без букв, дробей и символов.
                int numberOfPeople = in.nextInt(); //получаем и сохраняем в переменную количество человек введённое пользователем

                if (numberOfPeople == 1) { //пользователь вводит 1 человека
                    System.out.println("Введите больше 1 человека, если внутри вас не сидит второе Я!");
                } else if (numberOfPeople < 1) { //пользователь вводит число меньше 1
                    System.out.println("Дабы программа заработала... Введите больше 1 человека!");
                } else { //мы гордимся пользователем и продолжаем работу
                    System.out.println("Сейчас всё посчитаем!");
                    calc.addProduct();
                    calc.printInfo(numberOfPeople);
                    break;
                }
            } else {
                System.out.println("Извините, но это явно не число! Введите цифру больше 1.");
            }
        }
    }
}
