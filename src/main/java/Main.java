import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //create Guests and Menu classes
        Guests guests = new Guests();
        Menu menu = new Menu();

        System.out.println("Здравствуйте, сколько будет человек?");

        //get guest number
        guests.getGuestsNumber();

        //show chosen number of guests
        System.out.println("Число гостей: " + guests.numberOfGuests);

        //add our menu items and show adding steps
        menu.addMenuItems();

        //create Calculator class, calculate and print the results
        Calculator calculator = new Calculator(guests.numberOfGuests, menu.itemsToPrint, menu.totalPrice);
        calculator.printResult();

    }
}

