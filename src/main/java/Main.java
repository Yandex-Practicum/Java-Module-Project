import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Calculator.inputPersons();
        Calculator.addProducts();
        Calculator.payPeople();
    }

    public static class Calculator {
        static double totalPrice = 0;
        static String names = "";
        static int persons = 0;

        public static void inputPersons() {
            while (true) {
                System.out.println("How many persons?");
                if (scan.hasNextInt()) {
                    persons = scan.nextInt();
                    if (persons <= 1) {
                        System.out.println("Amount of persons must be integer > 1. Try again.");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Amount of persons must be integer > 1. Try again.");
                    scan.nextLine();
                    continue;
                }
            }
        }

        public static void addProducts() {
            while (true) {
                System.out.println("Product name: ");
                String name = scan.next() + scan.nextLine();
                System.out.println("Price: ");
                if (scan.hasNextDouble()) {
                    double price = scan.nextDouble();
                    if (price < 0) {
                        System.out.println("Price must be positive double! Try again");
                        continue;
                    }
                    totalPrice += price;
                    names += name + "\n";
                } else {
                    System.out.println("Price must be positive double! Try again");
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

        public static void payPeople() {
            int ruble = (int) Math.floor(totalPrice);
            int payPeople = (int) Math.floor(totalPrice/persons);
            System.out.println("Вы заказали следующие продукты:\n" + names + "на сумму: " + totalPrice + " " + Calculator.payPeoples(ruble));
            System.out.println("Каждый из " + persons + " человек заплатит по " + String.format("%.2f", totalPrice/persons) + " " + Calculator.payPeoples(payPeople));
        }

        static String payPeoples(int ruble) {
            if (ruble % 100 / 10 == 1) {
                return "рублей";
            } else {
                switch (ruble % 10) {
                    case 1 :
                        return "рубль";
                    case 2:
                    case 3:
                    case 4:
                        return "рубля";
                    default: return "рублей";
                }
            }
        }
    }
}