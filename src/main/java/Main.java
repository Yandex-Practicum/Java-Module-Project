import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("На скольких человек необходимо разделить счёт?");

        Scanner scanner = new Scanner(System.in);

        int peopleCounter;

        while (true){

            if (scanner.hasNextInt()){
                peopleCounter = scanner.nextInt();
                if (peopleCounter == 1){
                    System.out.println("В этом случае нет смысла ничего считать и делить. Пожалуйста введите корректное значение для подсчёта.");
                } else if(peopleCounter < 1){
                    System.out.println("Количество человек меньше 1. Пожалуйста введите корректное значение для подсчёта.");
                } else {
                    break;
                }
            } else {
                System.out.println("Пожалуйста введите корректное значение для подсчёта.");
                scanner.next();
            }

        }


    }
}
