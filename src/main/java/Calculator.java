import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {
    private int numberOfPeople;
    private String productsList = "Список товаров: \n";
    private double totalCost = 0.0;

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople() {
        Scanner sc = new Scanner(System.in);
        int numberOfPeople;
        while (true) {
            try {
                numberOfPeople = sc.nextInt();
                if (numberOfPeople <= 1) {
                    System.out.println("Упс! Слишком мало людей! :с");
                } else {
                    this.numberOfPeople = numberOfPeople;
                    return;
                }
            } catch (NoSuchElementException exp) {
                System.err.print("Ой! Ошибочка! Попробуйте ввести количество человек еще раз: ");
                sc.nextLine();
            }
        }
    }

    public void addProduct(Product product) {
        this.productsList += product.getName();
        this.totalCost += product.getPrice();
    }

    private void printTotalCost() {
        System.out.printf("%sОбщая стоимость: %.2f \n", productsList, totalCost);
    }

    private double splitTheBill() {
        return totalCost / numberOfPeople;
    }

    public void printResults() {
        printTotalCost();
        System.out.printf("Ура! Мы поделили счет на %d человек! Получилось по %.2f %s с каждого!",
                numberOfPeople, splitTheBill(), rubleFormatter(splitTheBill()));
    }

    private String rubleFormatter(double price) {
        switch ((int) price % 10) {
            case 1:
                return "рублю";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
