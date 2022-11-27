import java.util.Scanner;

public class People{
    public static int amount;
    public static void people(){
        while (true){
            System.out.println("How many people should the bill be divided into?");
            Scanner scanner = new Scanner(System.in);

            while(!scanner.hasNextInt()){
                System.out.println("enter a number");
                scanner.next();
            }
            amount = scanner.nextInt();
            if (amount <= 1){
                System.out.println("Enter more people");
            }
            else if(amount >= 2){
                Calculate.calculate();
                break;
            }
        }
    }
}
