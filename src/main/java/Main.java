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

    }
}
