

public class Calculator {

    int numberOfGuests;
    String itemsToPrint;
    double totalPrice;

    Calculator(int numberOfGuests, String itemsToPrint, double totalPrice){

        this.numberOfGuests = numberOfGuests;
        this.itemsToPrint = itemsToPrint;
        this.totalPrice = totalPrice;
    }

    //fun to calculate and print result of how many each guest should pay
    void printResult() {
        System.out.println(itemsToPrint);

        double priceForEach = totalPrice / numberOfGuests;
        String shortenedPrice = String.format("%.2f", priceForEach);
        String resultMesTemplate = "Каждый гость должен заплатить " + shortenedPrice;

        int integerPrice = (int) Math.floor(priceForEach);
        int numberBeforeLast = integerPrice % 100 / 10;

        if (numberBeforeLast == 1) {
            System.out.println(resultMesTemplate + " рублей.");
            return;
        }

        switch (integerPrice % 10) {
            case 1:
                System.out.println(resultMesTemplate + " рубль.");
                break;
            case 2:
            case 3:
            case 4:
                System.out.println(resultMesTemplate + " рубля.");
                break;
            default:
                System.out.println(resultMesTemplate + " рублей.");
                break;
        }
    }


}
