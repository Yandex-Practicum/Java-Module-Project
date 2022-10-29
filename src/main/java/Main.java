import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numberOfGuests = getNumberOfGuests();
        Calculator.printResult(numberOfGuests);

    }
    static int getNumberOfGuests(){
        Scanner scanner = new Scanner(System.in);
                while (true){
                    System.out.println("Введите количество гостей.");
                    int number = scanner.nextInt();
                      if (number == 1){
                          System.out.println("Количество гостей дожно быть не менее 2-х человек. Найдите кого-нибудь, с кем можно разделить счёт.");
          }else if (number <2) {
                          System.out.println("Количество гостей не может быть меньше 1. Вероятно вы ошиблись.");
                      }else {
                          return number;
                      }

        }
    }
}
