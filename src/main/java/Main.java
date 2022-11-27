import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int howManyPeople;
        while (true) {
            System.out.println("На сколько человек необходимо разделить счет?");
            Scanner scFirst = new Scanner(System.in);
            if (scFirst.hasNextInt()) {
                howManyPeople = scFirst.nextInt();
                if (howManyPeople > 1) {
                    break;
                }
                System.out.println("Извините, но необходимо ввести число гостей, которое больше 1!");// Убрал один if, который был, как оказалось, не нужен
            } else {
                System.out.println("Извините, но необходжмо ввести целочисленное значение больше 1");
            }
        }
        Calculator.calc(howManyPeople);
    }

}


