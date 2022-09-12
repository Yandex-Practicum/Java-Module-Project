import java.util.Scanner;

public class Calculat {
    public int people;
    public String foodList = "";
    public double value = 0.0;
    Scanner scanner;

    public Calculat (Scanner scanner) {
        this.scanner = scanner;
    }

    public void parameters () {
        System.out.println ("Сколько человек хотят оплатить счет?");
        int a;
        while (!scanner.hasNextInt()) {
            System.out.println("Введите целое число:");
            scanner.next();
        }
        while (true) {
            a = scanner.nextInt();
            if (a > 1) {
                System.out.println("Сейчас сормирую для вас счет...");
            }
            if (a == 1) {
                System.out.println("Ваш счет для оплаты!");
            }
            if (a < 1) {
                System.out.println("Некорректное значение, введите целое число больше нуля.");
            }
            else {
                people = a;
                break;
            }
        }
    }

    public void food () {
        while (true) {
            System.out.println ("Введите название блюда которое желаете добавить:");
            String name = scanner.next();
            if (name.equals("Завершить")) {
                break;
            }
            System.out.println ("Введите стоимость блюда в формате \"рубли.копейки\"");
            while (!scanner.hasNextDouble()) {
                System.out.println("Некорректный ввод цены, введите стоимость блюда в формате \"рубли.копейки\"");
                scanner.next();
            }
            double price = scanner.nextDouble();
            StringBuilder c = new StringBuilder();
            foodList = c.append("\n").append(name).toString();
            value = value + price;
        }
    }

    public void result () {

        double costPerPerson = value / people;
        String costText = "%.2f ";
        System.out.println("Добавленные блюда:"+foodList + "\nСумма на человека к оплате: " + String.format(costText,costPerPerson) + suffix(costPerPerson));
    }

    public String suffix (double value) {
        int b = (int) value;

        if(b > 100)
            b %= 100;

        if(b > 20)
            b %= 10;

        switch(b)
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