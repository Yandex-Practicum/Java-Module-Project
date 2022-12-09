public class rubleOptions {


    String rubles(double value) {
        double rubles = Math.floor(value);
        if (rubles == 1) {
            return " рубль";
        } else if (rubles == 12 || rubles == 13 || rubles == 14  ) {
            return " рублей";
        } else if (rubles%10 >= 2 && rubles%10 <= 4) {
            return " рубля";
        } else if (rubles%100 >= 2 && rubles%100 <= 4) {
            return " рубля";
        } else {
            return " рублей";
        }
    }
}

