

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

        if (Math.floor(priceForEach) < 1) {
            System.out.println("Каждый гость должен заплатить " + shortenedPrice + " рубля.");
        }
        if (Math.floor(priceForEach) == 1) {
            System.out.println("Каждый гость должен заплатить " + shortenedPrice + " рубль.");
        }
        else if(Math.floor(priceForEach)==2){
            System.out.println("Каждый гость должен заплатить " + shortenedPrice + " рубля.");
        }
        else if(Math.floor(priceForEach)==3){
            System.out.println("Каждый гость должен заплатить " + shortenedPrice + " рубля.");
        }
        else if(Math.floor(priceForEach)==4){
            System.out.println("Каждый гость должен заплатить " + shortenedPrice + " рубля.");
        }
        else if (Math.floor(priceForEach)>4){
            System.out.println("Каждый гость должен заплатить " + shortenedPrice + " рублей.");
        }
    }

}
