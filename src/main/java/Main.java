import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        BillCalculator calculator = new BillCalculator(scanner);
        calculator.inputParameters();
        calculator.addDishes();
        calculator.printResult();
    }
}
