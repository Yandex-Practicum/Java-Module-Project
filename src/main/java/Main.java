
public class Main {


    public static void main(String[] args) {

       Calculator calculator = new Calculator();



        double people = calculator.countPeople();
        double sumProducts = calculator.addProduct();
        double result = sumProducts / people;
        String currency = calculator.endOfCurrency(sumProducts);
        String currency2 = calculator.endOfCurrency(result);

        String conclusion = "Cумма товаров %.2f %s\nНа одного человека %.2f %s";
        System.out.printf(conclusion,sumProducts,currency, result, currency2);
    }
}
