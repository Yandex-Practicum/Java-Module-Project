public class CaseEnding {

    static String roubleCase = " рублей";
    static double remainder;

    static String setEnding(double price) {
        if (Math.floor(price) >= 11 && Math.floor(price) <= 14) {
            return roubleCase = " рублей";
        } else {
            remainder = Math.floor(price) % 10;
            if (remainder == 1) {
                return roubleCase = " рубль";
            } else if (remainder >= 2 && remainder <= 4) {
                return roubleCase = " рубля";
            } else {
                return roubleCase = " рублей";
            }
        }
    }
}
