

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

        if (Math.floor(priceForEach) < 1) {
            System.out.println(resultMesTemplate + " рубля.");
        }
        if (Math.floor(priceForEach) == 1) {
            System.out.println(resultMesTemplate + " рубль.");
        }
        else if(Math.floor(priceForEach)==2){
            System.out.println(resultMesTemplate + " рубля.");
        }
        else if(Math.floor(priceForEach)==3){
            System.out.println(resultMesTemplate + " рубля.");
        }
        else if(Math.floor(priceForEach)==4){
            System.out.println(resultMesTemplate + " рубля.");
        }
        else if (Math.floor(priceForEach)>4){
            System.out.println(resultMesTemplate + " рублей.");
        }
    }

}
