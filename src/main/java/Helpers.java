public class Helpers {
    public static String getRuble(double number) {    // Определение окончания в зависимости от числа
        switch ((int)number) {
            case 1:
                return " рубль";
            case 2:
            case 3:
            case 4:
                return " рубля";
            default:
                return " рублей";
        }
    }

}

