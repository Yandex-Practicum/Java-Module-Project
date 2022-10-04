import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count=0;
        System.out.println ("For how many people do you need to split the bill?");
        count = countOfPeople();
        System.out.println (count);
        System.out.println ("Enter goods name and it price in format: 'title' [ruble.penny]  ");
        System.out.println("Hello world!");
    }
    public static int countOfPeople (){
        Scanner scanner = new Scanner(System.in);
        while (true){
            int x = scanner.nextInt();
                if (x>1) {
                return x;
                 }
                else {
                System.out.println ("Invalid quantity entered, please try again.");
                }
        }
    }
    public static Goods sumOfGoods () {
        String listOfGoods;
        double sumPrice;
        Scanner scanner = new Scanner(System.in);
        while (true){
        Goods finalBasketOfGoods = new Goods ("",0.0);
        System.out.println ("Enter goods name and it price in format");


        }
    }
}
