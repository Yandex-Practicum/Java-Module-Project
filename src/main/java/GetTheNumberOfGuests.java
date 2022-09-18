import java.util.Scanner;

public class GetTheNumberOfGuests {

    public int execute() {
        int numberOutsidetheloop = 1;
        while (Main.scanner.hasNext()) {
            String str = Main.scanner.next();
            try {
                int number = Integer.parseInt(str);
                if (number == 1)
                    System.out.println("You entered one guest, please type valid number");
                else if (number < 1)
                    System.out.println("You entered less then one guest, please type valid number");
                else {
                    numberOutsidetheloop = number;
                    break;
                }
            } catch (Exception e) {
                System.out.println("You typed wrong entry, please type number");
            }

        }
        return numberOutsidetheloop;

    }
}
