import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out);
        double result = 0;
        ps.println("Введите количество персон, более 1:");
        int amountPeople = 0;
        amountPeople = scanner.nextInt();
        while (amountPeople < 2) {
            System.out.println("Введите количество персон, более 1:");
            amountPeople = scanner.nextInt();
        }
        ArrayList<Position> resultPositions = new Position().counter();
        ps.println("Добавленные товары:");
        int j = 0;
         do {
            resultPositions.get(j).printPosition();
            j++;
        } while (j < resultPositions.size());
         ps.println();
         result = new Position().calculate(resultPositions) / amountPeople;
         ps.print("Каждый должен заплатить: ");
         switch ((int) (result % 20)) {
             case 1: ps.println(String.format("%.2f", result)+" рубль"); break;
             case 2: ps.println(String.format("%.2f", result)+" рубля"); break;
             case 3: ps.println(String.format("%.2f", result)+" рубля"); break;
             case 4: ps.println(String.format("%.2f", result)+" рубля"); break;
             default: ps.println(String.format("%.2f", result)+" рублей"); break;
         }
    }
}
