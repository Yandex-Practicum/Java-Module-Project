import java.util.Scanner;

public class Check {

    String currencyAddition(double num){
        double adds = num % 100;
        int addsInvert = (int) (Math.floor(adds));

        switch (addsInvert){
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}