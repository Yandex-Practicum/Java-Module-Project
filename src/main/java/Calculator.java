import java.util.List;

public class Calculator {

    public static void calculate(int quantityOfGuests, List<Item> items) {
        printItemList(items);
        double sum = sumAllPrices(items);
        System.out.println("Итого = " + String.format("%.02f",sum));
        System.out.println("количество гостей: " + quantityOfGuests);
        System.out.println("каждый должен заплатить по: "+
                String.format("%.02f", (sum/quantityOfGuests))+
                getRightPadej(sum/quantityOfGuests));
    }

    private static String getRightPadej(double sumForOne) {
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

    private static double sumAllPrices(List<Item> items) {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    private static void printItemList(List<Item> items) {
        System.out.println("Добавленные товары:");
        items.forEach(System.out::println);
    }
}
