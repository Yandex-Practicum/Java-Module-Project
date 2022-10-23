import java.util.ArrayList;

public class Calculator {

    private final ArrayList<Product> products;
    private final int numberOfPersons;

    public Calculator(ArrayList<Product> products, int numberOfPersons) {
        this.products = products;
        this.numberOfPersons = numberOfPersons;
    }

    public void outputResult() {
        System.out.println("Добавленные товары:");
        for (Product product : products) {
            System.out.println(product.name);
        }
        double sumProduct = 0.0;
        for (Product product : products) {
            sumProduct = sumProduct + product.price;
        }
        double avgSum = sumProduct / numberOfPersons;
        String avgSumString = String.format("%.2f", avgSum);
        int floorAvgSum = (int) Math.floor(Double.parseDouble(avgSumString));

        System.out.println(avgSumString + caseRub(floorAvgSum));
    }

    private String caseRub(int floorAvgSum) {
        String rub;
        if((floorAvgSum % 100) >= 11 && (floorAvgSum % 100) <= 19) {
            rub = " рублей";
        } else {
            switch (floorAvgSum % 10) {
                case 1: rub = " рубль";
                    break;
                case 2:
                case 3:
                case 4: rub = " рубля";
                    break;
                default: rub = " рублей";
            }
        }
        return rub;
    }
}
