import java.util.Scanner;

public class Calculator {

    private final int numberOfPerson; // количество человек, на которых нужно делить счёт
    private String goods = ""; // список товаров в заказе
    private double sum = 0; // сумма по счёту

    public Calculator(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public void addGood(Good good) {
        this.sum += good.getCost();
        String addedGood = String.format("%s\n", good.getName());
        System.out.printf("Товар %s стоимостью %.2f успешно добавлен в счёт\n",
                                                good.getName(), good.getCost());
        this.goods = this.goods + addedGood;
    }

    public void operate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название товара или ЗАВЕРШИТЬ для окончания ввода: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("завершить")) {
                printGoods();
                printSumPerPerson();
                break;
            } else {
                String name = input;
                System.out.println("Введите стоимость товара в формате [руб.коп]:");
                // проверка на корректный double
                while (true) {
                    input = scanner.nextLine();
                    try {
                        double cost = Double.parseDouble(input);
                        if (cost < 0) {
                            System.out.println("Стоимость должна быть неотрицательной," +
                                    "введите корректную стоимость в формате [руб.коп]");
                            continue;
                        }
                        addGood(new Good(name, cost));  // добавляем товар в счет
                        break;
                    } catch (Exception e) {
                        System.out.println("Введите корректную стоимость товара в формате [руб.коп]");
                    }
                }
            }
        }
    }

    public void printGoods() {
        System.out.println("Добавленные товары:");
        System.out.println(goods);
    }

    public void printSumPerPerson() {
        double sumPerPerson = sum / numberOfPerson;
        System.out.printf("Сумма на человека: %.2f %s\n", sumPerPerson, rublesDeclination(sumPerPerson));
    }

    public String rublesDeclination(double number) {
        int floorNumber = (int)Math.floor(number);
        String result = "рублей";
        if (floorNumber % 100 >= 11 && floorNumber % 100 < 20) result = "рублей";
        else switch (floorNumber % 10) {
            case 1:
                result = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                result = "рубля";
                break;
        }
        return result;
    }
}
