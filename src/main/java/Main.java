import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();
    static Guest guests;
    static ProdCalc prodCalc;

    public static void main(String[] args) {
        prodCalc = new ProdCalc();
        addGuests();
        addProd();
        runSum();
        runDivide();
        printResult();
    }

    public static void addGuests() {
        int person;
        do {
            System.out.println("Сколько вас человек?");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите корректное значение: ");
                scanner.next();
            }
            person = scanner.nextInt();
        } while (person <= 1);
        guests = new Guest(person);
    }

    public static void addProd() {
        String food;
        double price;
        while (true) {
            System.out.println("Ведите название товара или 'Завершить'");
            food = scanner.next();
            if (food.equalsIgnoreCase("завершить")) {
                break;
            } else {
                System.out.println("Стоимость товара в формате 'рубли.копейки' (XX.XX): ");
                price = scanner.nextDouble();
                while (price <= 0) {
                    System.out.println("Введите корректное значение");
                }
                products.add(new Product(food, price));
                System.out.println("Добавлено");

            }
        }
    }

    public static double runSum() {
        for (int i = 0; i < products.size(); i++) {
            prodCalc.sum(products.get(i).coast);
        }
        return prodCalc.summaryCoast;
    }

    public static double runDivide() {
        return prodCalc.divide(guests.guests);
    }

    public static void printResult() {
        String template = "Каждый должен заплатить %.2f %s";
        System.out.println("Добавленные товары: ");

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
        System.out.println(String.format(template, prodCalc.moneyForPerson, getRightWord(prodCalc.moneyForPerson)));
    }

    private static String getRightWord(double n) {
        n = (int) Math.floor(n);
        n = Math.abs(n) % 100;
        int n1 = (int) (n % 10);
        if (n > 10 && n < 20) return "рублей";
        if (n1 > 1 && n1 < 5) return "рубля";
        if (n1 == 1) return "рубль";
        return "рублей";
    }
}






