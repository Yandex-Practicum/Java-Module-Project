public class Calculator {
    public static String complete(float costGeneral) {
        String suffix;
        int hundred = (int) Math.floor(costGeneral % 100);
        if (hundred <= 14 && hundred >= 11) {
            suffix = " рублей ";
        } else {
            int ten = hundred % 10;
            if (ten == 1) {
                suffix = " рубль ";
            } else if (ten >= 2 && ten <= 4) {
                suffix = " рубля ";
            } else {
                suffix = " рублей ";
            }

        }
        return suffix;
    }
}