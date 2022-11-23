import java.util.*;
public class Main {

    public static void main(String[] args) {

        System.out.println("Привет! Это программа Калькулятор счёта");
        int guestCount = Request.askGuestCount(); // Метод запроса и проверки корректности количества гостей
        System.out.println("Итак, количество гостей - " + guestCount+ " чел.");

        float sum = Calculator.calculate(); // Сбор позиций и цен чека, возврат суммы
        String newline = "*********************************************";

        System.out.println(newline);
        System.out.println(String.format("Общая сумма товаров - " + "%.2f", sum)+" " +FormOfCurrency.defineTheForm((int)Math.floor(sum)));
        System.out.println(String.format("Сумма покупок на одного человека - " + "%.2f", (sum/guestCount))+ " " +FormOfCurrency.defineTheForm((int)Math.floor(sum/guestCount)));
        System.out.println(newline);
    }


}