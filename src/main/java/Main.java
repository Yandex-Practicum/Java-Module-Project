public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Привет! Я удобный калькулятор для разделения общего счета на несколько человек!");
        System.out.println("На сколько человек нужно поделить счет?");
        calculator.setNumberOfPeople();
        System.out.println("Окей! Делим счет на " +
                calculator.getNumberOfPeople() + " человек");

        while (true) {
            Product product = new Product();
            if (!product.setName()) {
                break;
            } else {
                product.setPrice();
            }
            calculator.addProduct(product);
        }
        calculator.printResults();
    }
}
