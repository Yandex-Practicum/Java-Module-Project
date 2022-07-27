public class Resultmoneyforeveryone {
    public static void result_money_for_everyone() {
        String format;
        double c = Math.floor(Calculate.money_for_everyone);
        if (c % 10 == 5 | c % 10 == 6 | c % 10 == 7 | c % 10 == 8 | c % 10 == 9 | c % 100 == 10 | c % 100 == 11 | c % 100 == 12 | c % 100 == 13 | c % 100 == 14 | c % 100 == 15 | c % 100 == 16 | c % 100 == 17 | c % 100 == 18 | c % 100 == 19 | c % 100 == 20) {
            format  = String.format("%.2f",Calculate.money_for_everyone);
            System.out.println("each person has to pay: " + format + " рублей");
        }
        else if (c % 10== 1)
        {
            format  = String.format("%.2f",Calculate.money_for_everyone);
            System.out.println("each person has to pay: " + format + " рубль");
        }
        else if (c % 10 == 2 | c % 10 == 3 | c % 10 == 4) {
            format  = String.format("%.2f",Calculate.money_for_everyone);
            System.out.println("each person has to pay: " + format + " рубля");
        }
    }
}