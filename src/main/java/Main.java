import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        InputNumberOfPersons inputNumberOfPersons = new InputNumberOfPersons(scanner);
        int numberOfPersons = inputNumberOfPersons.inputNumberOfPersons();

        InputProducts inputProducts = new InputProducts(scanner);
        ArrayList<Product> products = inputProducts.productArrayList();

        Calculator calculator = new Calculator(products, numberOfPersons);
        calculator.outputResult();
    }
}
