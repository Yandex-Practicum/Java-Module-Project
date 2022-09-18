import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int guestsCount;
        GetTheNumberOfGuests getNumber = new GetTheNumberOfGuests();
        GetProductsAndTheirPrices getProductsAndTheirPrices = new GetProductsAndTheirPrices();
        GetProductsListAndAmountPerPerson getProductsListAndAmountPerPerson =
                new GetProductsListAndAmountPerPerson();

        System.out.println("How many people should the bill be divided into?");
        guestsCount =   getNumber.execute();

        System.out.println("Enter product's name , example \"Milk\"");
        Calculator calculator = getProductsAndTheirPrices.execute();

        getProductsListAndAmountPerPerson.execute(calculator,guestsCount);

        scanner.close();

    }
}
