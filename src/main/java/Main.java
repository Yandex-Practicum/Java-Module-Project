public class Main {

    public static int persons;

    public static void main(String[] args) {

        Persons.enterPersons();

        Calculator calculator = new Calculator();
        calculator.consoleProducts();
    }
}