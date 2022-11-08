
import java.util.Scanner;

public class People {

    static Short numberOfPeople;//объявляем статическую переменную число участников для передачи в класс Main

    public static void countPeople() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Добрый день");


        while (true) {
            System.out.println("На сколько человек разделить счёт?");

            if (scanner.hasNext()){
                numberOfPeople = scanner.nextShort();
                if (numberOfPeople > 1) {
                    System.out.println("Делим счёт на "+ numberOfPeople+ " гостей");//получили число участников
                    break;
                }

                if (numberOfPeople <= 1) {
                    System.out.println("Неправильный ввод. Попробуйте ввести число участников ещё раз.");
                }
            }else{
                System.out.println("Неправильный ввод. Попробуйте ввести число участников в числовом формате.");
                scanner.nextLine();
            }

        }

    }
}