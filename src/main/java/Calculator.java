import java.lang.Math;
public class Calculator {
    Product product;
    double fullPrice = 0;
    String listOfProducts = "";
    double fullPriceSharing = 0;
    String rubles = "";

    Calculator(Product product) {
        this.product = product;
    }

    void addProduct (Product product) {
        fullPrice += product.getPrice();
        listOfProducts += product.getName() + "\n";
    }

    double everyonePays (int persons){
        fullPriceSharing = fullPrice / persons;
        return fullPriceSharing;
    }

    String ending (double fullPriceSharing){
        if (Math.floor(fullPriceSharing) >= 11 && Math.floor(fullPriceSharing) <=19){
            rubles = "Рублей";
        }
        else {
            switch ((int) Math.floor(fullPriceSharing % 10)) {
                case 1:
                    rubles = "Рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rubles = "Рубля";
                    break;
                default:
                    rubles = "Рублей";
                    break;
            }
        }
        return rubles;
    }
}