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
        int roundedPrice = (int)Math.floor(price);
        if (roundedPrice == 1) {
            return "рубль";
        } else if (roundedPrice >= 2 &&
                   roundedPrice <= 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}
