public class Calculator {
    float priceForPerson;
    String outputCalculate;
    String rub;

    void calculate(int persons, float totalPrice) {
      priceForPerson = totalPrice/persons;
    }

    void correctOutput() {
        if (priceForPerson%10 == 1) {
            rub = "рубль";
        }
        else if (priceForPerson%10 == 2 && priceForPerson%10 == 3 && priceForPerson%10 == 4){
            rub = "рубля";
        }
        else {
            rub = "рублей";
        }
        outputCalculate = String.format("%.2f", priceForPerson);
        System.out.println("Каждый человек должен заплатить по: " + outputCalculate + " " + rub);
    }
}
