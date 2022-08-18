public class Product {
    String name;
    double price;
    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void info(){
        System.out.println("Товар "+ name + " цена "+ price + " " + GetRubleAddition(price));
    }
    public static String GetRubleAddition(Double value) {

        int num = value.intValue();

        int preLastDigit = num % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }

        return switch (num % 10) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
    }

}

