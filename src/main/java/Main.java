import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.inputPersons();
        calc.addProducts();
        calc.payPeople();
    }

    public static class Calculator {
        double totalPrice = 0;
        String names = "";
        int persons = 0;

        public void inputPersons() {
            while (true) {
                System.out.println("How many persons?");
                persons = scan.nextInt();
                if (persons <= 1) {
                    System.out.println("Amount of persons must be > 1. Try again.");
                    continue;
                } else {
                    break;
                }
            }
        }

        public void addProducts() {
            while (true) {
                System.out.println("Product name: ");
                String name = scan.next() + scan.nextLine();
                System.out.println("Price: ");
                if (scan.hasNextDouble()) {
                    double price = scan.nextDouble();
                    totalPrice += price;
                    names += name + "\n";
                } else {
                    System.out.println("Price must be double! Try again");
                    scan.nextLine();
                    continue;
                }

                System.out.println("Product " + name + " successfully added! Enough? (yes - any symbol/no - n): ");
                String answer = scan.next();
                if (answer.equalsIgnoreCase("n")) {
                    continue;
                } else {break;}
            }
        }

        public void payPeople() {
            System.out.println("You ordered following products:\n" + names + "for total price " + totalPrice);
            String result = String.format("%.2f", totalPrice/persons);
            System.out.println(String.format("Each of the " + persons + " people must pay for " + result));
        }
    }
}