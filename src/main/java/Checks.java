import java.util.Scanner;

public class Checks {

    String currencyAddition(double num) {

        // Вычисляем остаток
        double adds = num % 100;
        // Преобразовываем тип в int для использования в switch
        int addsInvert = (int) (Math.floor(adds));

        // Делаем проверку по последнему числу принятого значения (полученному остатку)
        switch (addsInvert) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";


        }

    }
}