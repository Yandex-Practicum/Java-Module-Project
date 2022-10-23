
import java.util.Scanner;

public class Calculator {

    String receipt = "";
    double summa = 0;

    public void addGood(String title, double price) {
        Good tovar = new Good(title, price);

        receipt = receipt.concat("\n").concat(tovar.title);
        summa = summa + tovar.amount;
    }

    public String getReceipt() {
        return receipt;
    }

    public double getSumma() {
        return summa;
    }

    public String getRubleAddition(int num)
    {
        int preLastDigit = num % 100 / 10;
        if (preLastDigit == 1)
        {
            return "рублей";
        }

        switch (num % 10)
        {
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
