public class ResultСount{
    public static void result_count(){
        double x = Math.floor(Calculate.count);
        String format;
        if( x % 10 == 5 | x % 10 == 6 | x % 10 == 7 | x % 10 == 8 | x % 10 == 9 | x % 100 == 10 | x % 100 == 11 | x % 100 == 12 | x % 100 == 13 | x % 100 == 14 | x % 100 == 15 | x % 100 == 16 | x % 100 == 17 | x % 100 == 18 | x % 100 == 19 | x % 100 == 20){
            format  = String.format("%.2f",Calculate.count);
            System.out.println("total price: " + format + " рублей");
        }
        else if (x % 10 == 1)
        {
            format  = String.format("%.2f",Calculate.count);
            System.out.println("total price: " + format + " рубль");
        }
        else if (x % 10 == 2 | x % 10 == 3 | x % 10 == 4)
        {
            format  = String.format("%.2f",Calculate.count);
            System.out.println("total price: " + format + " рубля");
        }

        }
}
