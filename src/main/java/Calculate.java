import java.util.Scanner;

public class Calculate{
    public static double count = 0;
    public static double money_for_everyone;
    public static String product1 = "";
    public static void calculate() {
        while (true) {
            System.out.println("enter product name: ");
            Scanner scanner = new Scanner(System.in);
            String product = scanner.next();
            product1 += product + "\n";
            System.out.println("enter the cost in the format 'rubles,kopecks' [XX,XX]");
            while(!scanner.hasNextDouble())
            {
                scanner.next();
                System.out.println("enter a number");
            }
            double cost = scanner.nextDouble();
            System.out.println(product + " successfully added :)");
            count += cost;
            System.out.printf("current price: " + "%.2f.\n", count);
            exit();
            break;
        }
    }
    private static void exit() {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("do you want to add a new item?");
            String stop = scanner.next();
            String stop1 = "завершить";
            String continuation = "yes";
            money_for_everyone = count / People.amount;
            if (stop1.equalsIgnoreCase(stop)){
                break;
            }
            else if (continuation.equalsIgnoreCase(stop)){
                calculate();
                break;
            }
            else{
                System.out.println("you entered the wrong value");

            }
        }
    }
}