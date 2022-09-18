public class Main {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Calculator calculator = new Calculator(sc);

        if (!calculator.getPeopleCount()) {
            return;
        }
        calculator.getFoodList();
        calculator.calculate();

        sc.close();







    }
}
