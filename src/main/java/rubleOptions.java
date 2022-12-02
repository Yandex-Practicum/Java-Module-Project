public class rubleOptions {


    String rubles(double prise) {
       double rubles = prise;
        if (rubles == 1) {
            return " рубль";
        } else if (rubles >= 2 && rubles <= 4) {
            return " рубля";
        } else
            return " рублей";
        }

    }

