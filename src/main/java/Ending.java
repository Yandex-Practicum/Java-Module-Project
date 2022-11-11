public class Ending {

    String end(float num) {
        int num100 = (int) (Math.floor(num % 100));
        if (num100 > 4 && num100 < 21) {
            return "Рублей";
        } else {
            int num10 = num100 % 10;
            if (num10 == 1) {
                return "Рубль";
            } else if (num10 > 1 && num10 < 5) {
                return "Рубля";
            } else {
                return "Рублей";
            }
        }
    }
}