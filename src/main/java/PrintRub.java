class PrintRub {
    public static String getStringRub(int integer) {
        int remainder = integer % 100;
        if (remainder >= 11 && remainder <= 14) {
            return "рублей";
        }
        remainder = integer % 10;
        switch (remainder) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return "рублей";
            default:
                return "рубль";
        }

    }
}
