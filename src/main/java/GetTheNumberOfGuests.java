

public class GetTheNumberOfGuests {

    public static int execute() {
        int numberOutsidetheloop = 1;
        while (Main.scanner.hasNext()) {
            String input = Main.scanner.next();
            try {
                int numberOfGuests = Integer.parseInt(input);
                if (numberOfGuests == 1)
                    System.out.println("You entered one guest, please type valid number");
                else if (numberOfGuests < 1)
                    System.out.println("You entered less then one guest, please type valid number");
                else {
                    numberOutsidetheloop = numberOfGuests;
                    break;
                }
            } catch (Exception e) {
                System.out.println("You typed wrong entry, please type number");
            }

        }
        return numberOutsidetheloop;

    }
}
