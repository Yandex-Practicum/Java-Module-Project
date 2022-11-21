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

}
