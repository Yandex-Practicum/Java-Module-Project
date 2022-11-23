import java.util.*;

public class Request {
    public static int askGuestCount() {
        System.out.println("Введите число гостей: ");
        int count;
        Scanner console = new Scanner(System.in);
        while (true) {
            if (!console.hasNextInt()) {  // Проверем, что это целое число
                System.out.println("Должно быть введено именно ЧИСЛО. Попробуем еще раз? )");
                console.next();

            } else {
                count = console.nextInt();
                if (count < 1)
                    System.out.println("Количество гостей должно быть больше 1 человека. Попробуем еще раз? )");
                else {
                    if (count == 1) {
                        System.out.println("Количество гостей должно быть больше 1 человека. Попробуем еще раз? )");
                    } else
                        break;
                }
            }
        }
        return count;
    }
}
