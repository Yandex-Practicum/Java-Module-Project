import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static Scanner scanner = new Scanner (System.in );
    public static void main(String[] args) {
        System.out.println("Привет, на скольких человек необходимо разделить счёт?");
        int peopleCount = getCountOfPeople();
        ProductCalculator productCalculator = new ProductCalculator(peopleCount);
        productCalculator.inputProducts();
    }

    public static int getCountOfPeople() {
        int peopleCount = 0;
        while (true) {
            try {
                peopleCount = scanner.nextInt();
                if (isCorrectPeopleCount(peopleCount)) {
                    break;
                }
            } catch (InputMismatchException er) {
                System.out.println("Введено некоректное значение, повторите ввод количества человек.");
                scanner.next();
            }
        }
        return peopleCount;
    }

    public static boolean isCorrectPeopleCount(int peopleCount){
        if(peopleCount<=0) {
            System.out.println("Количество человек меньше 1. Это некорректное значение для подсчёта. Введите новое значение.");
            return false;
        } else if(peopleCount==1) {
            System.out.println("Количество человек,введеных пользователем равно 1.Нет смысла делить счет,введите новое значение.");
            return false;
        }else {
            return true;
        }
    }
}