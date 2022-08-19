import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        CountBuyers countBuyers = new CountBuyers(0);
        Calculate calculate = new Calculate(null,0);
        int number = countBuyers.countBuyers(0);
        calculate.calculate(null,0,number);


    }
}
