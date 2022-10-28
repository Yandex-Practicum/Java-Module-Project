import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numberOfGuests = 0;
        numberOfGuestsQuestion();
        Calculator.printResult(numberOfGuests);

        //Calculator calculator = new Calculator();
    }
    static int numberOfGuestsQuestion(){
        Scanner scanner = new Scanner(System.in);
                int numberOfGuests = 0;
                while (true){
                    System.out.println("Введите количество гостей.");
                    numberOfGuests = scanner.nextInt();
                      if (numberOfGuests == 1){
                          System.out.println("Количество гостей дожно быть не менее 2-х человек. Найдите кого-нибудь, с кем можно разделить счёт.");
          }else if (numberOfGuests <2) {
                          System.out.println("Количество гостей не может быть меньше 1. Вероятно вы ошиблись.");
                      }else {
                          return numberOfGuests;
                      }

        }
    }
}
