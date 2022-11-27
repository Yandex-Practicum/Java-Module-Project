import java.util.Scanner;

public class Calculator {
    static String exit = "Завершить"; // Вынес в статическую константу "Завершить"

    public static void calc(int people) {
        String dish;
        String allDishes = "";
        float price;
        float sumOfOrder = 0.0f;
        String close;
        while (true) {
            Scanner scSecond = new Scanner(System.in); // Оставил один сканнер
            System.out.println("Введите название блюда!");
            dish = scSecond.nextLine();
            System.out.println("Введите стоимость этого блюда в формате 'руб.коп'");
            if (scSecond.hasNextFloat()) {
                price = scSecond.nextFloat();
                if (price > 0) {
                    sumOfOrder = sumOfOrder + price;
                    allDishes = allDishes + dish + "\n";
                    String sufForOne = Finish.finish(price);
                    String anotherOne = "Вы добавили: %s за %.2f%s\n";
                    System.out.printf(anotherOne, dish, price, sufForOne);
                    System.out.println("Хотите добавить блюдо? Введите любую букву или напишите:'Завершить', если блюд больше не осталось");
                    close = scSecond.next();
                    if (close.equalsIgnoreCase(exit)) {
                        break;
                    }
                } else {
                    System.out.println("Сумма указана неверно");
                }
            } else {
                System.out.println("Сумма указана неверно, попробуйте внести блюдо снова");
            }

        }
        String suf = Finish.finish(sumOfOrder);
        float forThePerson = sumOfOrder / people;
        String lastSuf = Finish.finish(forThePerson);

        System.out.println("Вы купили:\n" + allDishes + "За " + String.format("%.2f", sumOfOrder) + suf);
        System.out.println("Каждый должен заплатить по: " + String.format("%.2f", forThePerson) + lastSuf);


    }
}
