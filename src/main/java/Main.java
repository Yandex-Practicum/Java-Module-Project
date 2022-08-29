import java.util.Scanner;

public class Main {
    //обработка количества гостей
    public static void main(String[] args) {
        System.out.println("Vvedite kolichestvo gostey: ");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int guests = 0;
            // условие проверки ввода текста при запросе количества гостей
            try {
                guests = scanner.nextInt();
            } catch (Exception ex) {
                System.out.println("Vvedeno nekorektnoe znachenie gostey, vvedite cifru");
                continue;
            }
            if (guests <= 0) {
                System.out.println("Vvedite nekorrektnoe znachenie,vvedite znachenie bolshe 1: ");
            } else if (guests == 1) {
                System.out.println("A zachem togta schitat? vvedite znachenie bolshe 1: ");
            } else {
                System.out.println("Seyachas pschitaem!");
                Calculator calculator = new Calculator();
                calculator.calculate(guests);

                break;
            }
        }

    }
}

