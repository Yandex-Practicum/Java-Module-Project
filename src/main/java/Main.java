import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count=0;
        Goods purchases = new Goods ("",0.0);
        System.out.println ("For how many people do you need to split the bill?");
        count = countOfPeople();
        System.out.println (count);
        Scanner scanner = new Scanner(System.in);
        boolean trigger = true;

        do {
            Goods product = new Goods("", 0.0);
            System.out.println("Enter good`s name");
                product.name = scanner.nextLine();
                System.out.println("Enter good`s price in format ruble.penny. For example: 0.00");
                while (true) {
                    if (scanner.hasNextDouble()) {
                        product.price = scanner.nextDouble();
                        if (product.price > 0) {
                            break;
                        } else {
                            System.out.println("Wrong format, pleas try again");
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println("Wrong format, pleas try again");
                        scanner.nextLine();
                    }
                }
                purchases = Summoning.Calculate(product, purchases);
                System.out.println("Do you want to add next product? If no, write \"complete\", else any phrase.");
                scanner.nextLine();
                String chek = scanner.nextLine();
            trigger = !chek.equalsIgnoreCase("complete");

        } while (trigger);

        System.out.println("Purchased products:\n"+purchases.name);
        double bill = purchases.price/count;
        String finalPhrase1 = "%.2f рубля";
        String finalPhrase2 = "%.2f рублей";
        if (bill <2 && bill>=1){
            System.out.println(String.format(finalPhrase1, bill));
        } else{
            System.out.println(String.format(finalPhrase2, bill));
        }


    }


    public static int countOfPeople (){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                if (x > 1) {
                    return x;
                } else {
                    System.out.println("Invalid quantity entered, please try again.");
                }
            } else{
                System.out.println("Invalid quantity entered, please try again.");
                scanner.nextLine();
            }
        }
    }

}
