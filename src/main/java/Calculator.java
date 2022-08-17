import java.util.List;

public class Calculator {
    private int quantityOfGuests;
    private List<Item> items;

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void setQuantityOfGuests(int quantityOfGuests){
        this.quantityOfGuests = quantityOfGuests;
    }

    public Calculator(int quantityOfGuests, List<Item> items){
        this.quantityOfGuests = quantityOfGuests;
        this.items = items;
    }

    public void calculate() {
        printItemList();
        double sum = sumAllPrices();
        System.out.println("Итого = " + String.format("%.02f",sum));
        System.out.println("количество гостей: " + quantityOfGuests);
        System.out.println("каждый должен заплатить по: "+
                String.format("%.02f", (sum/quantityOfGuests))+
                getRightPadej(sum/quantityOfGuests));
    }

    private String getRightPadej(double sumForOne) {
        int roundedSum = (int) Math.floor(sumForOne);
        if (roundedSum % 100 / 10 == 1){
            return " рублей";
        }else {
            switch (roundedSum % 10) {
                case 1:
                    return " рубль";
                case 2:
                case 3:
                case 4:
                    return " рубля";
                default:
                    return " рублей";
            }
        }
    }

    private double sumAllPrices() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    private void printItemList() {
        System.out.println("Добавленные товары:");
        items.forEach(System.out::println);
    }
}
