public class rubleOptions {


    String rubles(double value) {
        double rubles = Math.floor(value);
        if (rubles == 1) {
            return " рубль";
        } else if (rubles %100 == 11 || rubles%100 == 12 || rubles%100 == 13 || rubles%100 == 14) {
            return " рублей";
        } else if (rubles % 10 == 1) {
            return " рубль";
        } else if (rubles % 10 >= 2 && rubles % 10 <= 4) {
            return " рубля";
        } else {
            return " рублей";
        }
    }
}




//