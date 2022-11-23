import java.util.*;
public class Main {

    public static void main(String[] args) {

        System.out.println("Привет! Это программа Калькулятор счёта");
        int guestCount = Request.askGuestCount(); // Метод запроса и проверки корректности количества гостей
        System.out.println("Итак, количество гостей - " + guestCount+ " чел.");

        float sum = Calculator.calculate(); // Сбор позиций и цен чека, возврат суммы
        String formSum = FormOfCurrency.defineTheForm((int)Math.floor(sum)); //определение окончания рубля
        String formSumOne = FormOfCurrency.defineTheForm((int)Math.floor(sum/guestCount));

        System.out.println(String.format("Общая сумма товаров - " + "%.2f", sum)+" " +formSum);
        System.out.println(String.format("Сумма покупок на одного человека - " + "%.2f", (sum/guestCount))+ " " +formSumOne);
    }


}
