import java.util.Scanner;

public class BillCalculator {

    public int numberOfPeople = 0;
    public String dishesList = "";
    public double billAmount = 0.0;
    Scanner scanner;

    public BillCalculator (Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputParameters () {
        System.out.println ("Введите количество человек, на которых нужно поделить счет");
        int i;
        while (true) {
            i = scanner.nextInt();
            if (i < 2) {
                System.out.println("Количество человек не должно быть меньше двух");
            }
            else {
                numberOfPeople = i;
                break;
            }
        }
    }

    public void addDishes () {
        while (true) {
            System.out.println ("Введите название блюда");
            String name = scanner.next();
            if (name.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.println ("Введите цену блюда");
            double price = scanner.nextDouble();
            dishesList = dishesList + name + "\n";
            billAmount = billAmount + price;
        }
    }

    public void printResult () {
        System.out.println("Добавленные товары:\n"+dishesList);
        double costPerPerson = billAmount / numberOfPeople;
        String costText = "%.2f ";
        System.out.println("Сумма на человека: " + String.format(costText,costPerPerson) + addCorrectRubleString(costPerPerson));
    }

    public String addCorrectRubleString (double billAmount) {
        int amount = (int) billAmount;

        if(amount > 100)
            amount %= 100;

        if(amount > 20)
            amount %= 10;

        switch(amount)
        {
            case 1:
                return "Рубль";
            case 2:
            case 3:
            case 4:
                return "Рубля";
            default:
                return "Рублей";
        }
    }
}
