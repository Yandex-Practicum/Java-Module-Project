public class Main {
    public static void main(String[] args) {
        CountBuyers countBuyers = new CountBuyers();
        Calculate calculate = new Calculate();
        int number = countBuyers.countBuyers();
        calculate.calculate(number);
    }
}
