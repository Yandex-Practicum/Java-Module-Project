import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = addPerson(scanner);
        Calculator calculator = new Calculator();
        for(int i = 0; i <= people; i++) {
            calculator.productsLists(scanner);
        }
    }

    public static int addPerson(Scanner scanner) {
        int people = 0;
        boolean hasPeople = false;
        while(!hasPeople) {
            System.out.println("Введите количество человек:");
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
                if (people > 1) {
                    hasPeople = true;
                } else {
                    System.out.println("Введено неверное количество. попробуйте еще раз.");
                }
            }else {
                System.out.println("Введено неверное количество! попробуйте ввести количество гостей в виде числа.");
                scanner.nextLine();
            }
        }
        return people;
    }
}