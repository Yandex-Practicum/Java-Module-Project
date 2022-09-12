public class Math {


    public static void floor() {
        double itog = 0;
        int v = Calculate.product(itog);

        if (v == 0) {
            System.out.println("рублей");
        } else if (v == 1) {
            System.out.println("рублю");
        } else if (v == 2 || v == 3 || v == 4) {
            System.out.println("рубля");
        } else if (v == 5 || v == 6 || v == 7 || v == 8 || v == 9) {
            System.out.println("рублей");
        }
    }
}

