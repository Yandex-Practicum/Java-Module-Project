import java.util.Scanner;

public class Product {
    private String name;
    private double price;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return String.format("%s\n", name);
    }

    public boolean setName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название товара или \"завершить\", чтобы закончить ввод");
        while (true) {
            if (sc.hasNextLine()) {
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("завершить")) {
                    System.out.println("Окей, заканчиваем добавление!");
                    return false;
                } else {
                    this.name = input;
                    System.out.printf("Добавлен новый товар %s!%n", this.name);
                    return true;
                }
            }
        }
    }

    public void setPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите цену товара в формате РУБЛИ.КОПЕЙКИ [12.34]");

        while (true) {
            String input = sc.next();
            try {
                double price = Double.parseDouble(input);
                if (price <= 0.0) {
                    System.out.println("Ой! Таких маленьких цен не бывает! Попробуйте еще: ");
                } else {
                    this.price = price;
                    return;
                }
            } catch (Exception a) {
                System.out.println("Ой! Нужно вводить цену в формате РУБЛИ.КОППЕЙКИ [12.34]");
            }
        }
    }
}
