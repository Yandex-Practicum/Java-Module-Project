public class rubleOptions {

    String rubles(added added) {
       double rubles = added.prise;
        if (rubles == 1) {
            return " рубль";
        } else if (rubles >= 2 && rubles <= 4) {
            return " рубля";
        } else
            return " рублей";
        }
    }

