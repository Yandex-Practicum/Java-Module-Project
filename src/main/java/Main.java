import java.util.Scanner;

public abstract class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите количество гостей: ");
            int numbersOfGuests = scanner.nextInt();
            if (numbersOfGuests > 1){
                System.out.println("сюда калькулятор");
                break;
            } else {
                System.out.println("Введите количество гостей больше, чем 1: ");
            }
        }

        ProductsList.productsLists();
    }
}



