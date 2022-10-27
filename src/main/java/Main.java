public class Main {

    public static void main(String[] args) {
        BillSplitCalculator calculator = new BillSplitCalculator();
        calculator.askForNumberOfPersons();
        calculator.createProductFromInput();
        calculator.showFinalBill();
    }
}
