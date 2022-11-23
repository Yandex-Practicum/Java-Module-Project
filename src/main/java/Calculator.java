public class Calculator {
    private int peopleCounter;
    private String addedProducts = "Добавленные товары:\n";
    private double totalPrice;

    public Calculator(int peopleCounter){
        this.peopleCounter = peopleCounter;
    }

    public void addProduct(Product product){
        addedProducts = addedProducts + product.getName() + "\n";
        totalPrice += product.getPrice();
        System.out.println("Товар успешно добавлен.");
    }

    public void showAddedProducts(){
        System.out.println("\n" + addedProducts);
    }

    public void divide(){
        double dividedPrice = totalPrice / (double) peopleCounter;
        String formattedPrice = formatPrice(dividedPrice);
        String currency = getCurrencyWriting(dividedPrice);

        System.out.println("Каждый человек должен заплатить " + formattedPrice + " " + currency + ".");
    }

    private String formatPrice(double price){
        return String.format("%,.2f", price);
    }

    private String getCurrencyWriting(double price){
        double roundedPrice = Math.floor(price);
        double remainder = roundedPrice % 100.00;
        if (remainder >= 11 && remainder <= 14){
            return "рублей";
        } else {
            remainder = remainder % 10.00;
            if (remainder >= 1 &&
                    remainder < 2) {
                return "рубль";
            } else if (remainder >= 2 &&
                    remainder <= 4) {
                return "рубля";
            } else {
                return "рублей";
            }
        }

    }
}
