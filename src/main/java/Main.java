import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        out.println("How many people should the bill be divided into?");
        int persons = in.nextInt();
        while (persons<=1){
            out.println("Non-correct value for counting, the number of people must be more than one");
            out.println("Please enter the correct value");
            persons = in.nextInt();
        }
        Positions[] pos = new Positions[100];
        double sum = 0;
        out.println("Enter the name of the dish");
        String nextPosition = in.next();
        out.println("Enter the price of the dish in the format rub.kop");
        double nextPrice = in.nextDouble();
        sum+= nextPrice;
        int i = 0;
        while (!nextPosition.equalsIgnoreCase("Завершить")) {
            out.println("The dish has been added successfully\nDo you want to add one more");
            pos[i] = new Positions(nextPosition, nextPrice);
            out.println("Enter the name of the dish");
            nextPosition = in.next();
            if(!nextPosition.equalsIgnoreCase("Завершить")) {
                out.println("Enter the price of the dish in the format rub.kop");
                nextPrice = in.nextDouble();
            }
            sum+=nextPrice;
            i+=1;
        }
        for (int j=0; j<i; j++)
        out.println();
    }
}
