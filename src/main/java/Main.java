import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

        GoodCalculator gc = new GoodCalculator();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int peopleNumber = 0;
        String contunieGoodAdding, resultSumPerPerson;

        System.out.println("На скольких человек разделить счет?");
        peopleNumber = scanner.nextInt();

        while (peopleNumber < 2) {
            System.out.println("Введите целое число больше 1:");
            peopleNumber = scanner.nextInt();

        }

        while (true) {
            System.out.println("Введите название товара:");
            gc.goodName = scanner.nextLine();
            gc.goodName = scanner.nextLine();

            System.out.println("Введите стоимость товара [копейки.рубли] (например, 40.25):");
            gc.goodPrice = scanner.nextDouble();

            gc.addGood(gc.goodName, gc.goodPrice);
            System.out.println("\n\nТовар успешно добавлен! Текущая общая сумма: " + gc.goodSumPrice + " " + gc.rubleEnding(gc.goodSumPrice));

            System.out.println("Хотите добавить еще товар? Чтобы завершить, введите \'Завершить\'");
            contunieGoodAdding = scanner.next();
            if (contunieGoodAdding.equalsIgnoreCase("Завершить")) {
                break;
            }


        }
        resultSumPerPerson = String.format("%.2f" ,gc.goodSumPrice/peopleNumber);
        System.out.println("\n\n" + gc.goodSumName + "\n\nОбщая сумма: " + gc.goodSumPrice + " " + gc.rubleEnding(gc.goodSumPrice) + "\nС каждого участника по " + resultSumPerPerson + " " + gc.rubleEnding(gc.goodSumPrice));












    }



}

