import java.util.Scanner;

public class Products {
    Scanner scanner = new Scanner(System.in);
    String name = scanner.next();
    String price = scanner.next();

    Products(String name, String price) {
        this.name = name;
        this.price = price;
    }

}
