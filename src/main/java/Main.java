import java.util.Scanner;

public class Main {
//обработка количества гостей
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vvedite kolichestvo gostey: ");
        while (true) {
            int guests = scanner.nextInt();
            if (guests <= 0) {
                System.out.println("Vvedite nekorrektnoe znachenie,vvedite znachenie bolshe 1: ");
            }
            if (guests == 1) {
                System.out.println("A zachem togta schitat? vvedite znachenie bolshe 1: ");
            }
            if (guests > 1) {
                System.out.println("Seyachas pschitaem!");
                Calculator calculator = new Calculator();
                calculator.calculate(guests);

                break;
            }
        }

    }
}

