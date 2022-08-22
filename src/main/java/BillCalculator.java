public class BillCalculator {
    void startBillCalculator() {
        Guests guests = new Guests();
        int countGuests = guests.defineCountGuests();

        Calculator calculator = new Calculator();
        calculator.addProducts();

        double priceForPerson = calculator.calcPriceForPerson(countGuests);
        String rubleAddition = calculator.getRubleAddition(priceForPerson);
        String conclusion = "Каждый должен заплатить по %.2f " + rubleAddition + ".";

        System.out.println(calculator.products);
        System.out.println(String.format(conclusion, priceForPerson));
    }
}
