import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
//        while (true){
//            String input = scanner.nextLine();
//            if (input.equals("exit"))
//                break;
//            System.out.println("test");
//            String secondInput = scanner.next();
//
//        }
//
        System.out.println("How many people should the bill be divided into?");
        int guestsCount = TheNumberOfGuests.execute();

        System.out.println("Enter product's name , example \"Milk\"");
        Calculator calculator = ProductPriceCalculator.execute();

        ProductsListAndAmountPerPerson.execute(calculator, guestsCount);

        scanner.close();

    }
}
