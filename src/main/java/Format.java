public class Format {
    String padeg(double price) {
        double padeg = Math.floor(price);
        if (padeg == 1) {
            return "рубль";
        } else if (padeg == 11 || padeg == 12 || padeg == 13 || padeg == 14) {
            return "рублей";
        } else if (padeg % 10 == 1) {
            return "рубль";
        } else if (padeg % 10 >= 2 && padeg % 10 <= 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
        String round( final double result){
            return String.format("%.2f", result);
        }
    }


