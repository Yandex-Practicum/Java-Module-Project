import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int guestAmount = numberOfGuestsQuestion();
        System.out.println("Количество гостей: " + guestAmount);
    }
     private static int numberOfGuestsQuestion(){
        Scanner scanner = new Scanner(System.in);
                int userInput = 0;
                while (true){
                    System.out.println("Введите количество гостей.");
                    userInput = scanner.nextInt();
                      if (userInput == 1){
                          System.out.println("Количество гостей дожно быть не менее 2-х человек. Найдите кого-нибудь, с кем можно разделить счёт.");
          }else if (userInput <2) {
                          System.out.println("Количество гостей не может быть меньше 1. В этом случае нет смысла ничего считать и делить.");
                      }else {
                          return userInput;
                      }

        }
    }
}
