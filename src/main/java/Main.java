import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String DIGITS = "\\d+";
        System.out.println("Привет, сколько вас человек?");

        int countPeople = 0;
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        while (true) {

            String countPeople1 = sc.nextLine();

            if (countPeople1.matches(DIGITS)) {
                countPeople = Integer.parseInt(countPeople1);
                if (countPeople <= 1) {
                    System.out.println("Недостаточно человек");
                } else if (countPeople >= 2) {

                    //double sum = 0;
                    Calculator calculator  = new Calculator(countPeople);
                    calculator.start(sc);
                    calculator.result();
                    calculator.total();
                    break;
                }

            }
            else {
                System.out.println("Доступен ввод только числа");
            }




        }
    }
}
