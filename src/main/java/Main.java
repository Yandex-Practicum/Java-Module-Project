import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int visitorsNumber = 0;
        System.out.print("Привет!");
        while (visitorsNumber <= 1) {
            System.out.println("На сколько человек нужно поделить счёт?");
            visitorsNumber = scanner.nextInt();
            if (visitorsNumber < 1)
                System.out.println("Что-то пошло не так, " +
                        "кажется на такое количество людей поделить счёт не выйдет");
            else if (visitorsNumber == 1)
                System.out.println("Если вы один то как не дели, а платить вам");
        }
        Calculate calculate = new Calculate();
        calculate.getProducts();
        calculate.printBill();
        calculate.divideBill(visitorsNumber);
    }

}