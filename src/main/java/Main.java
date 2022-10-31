import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

        GoodCalculator gc = new GoodCalculator();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int peopleNumber;
        String contunieGoodAdding, resultSumPerPerson;

        System.out.println("На скольких человек разделить счет?");

        while (true) {
            if (scanner.hasNextInt()) {
                peopleNumber = scanner.nextInt();
                if (peopleNumber > 1) {
                    break;
                }
                else {
                    System.out.println("Введите целое число больше 1:");
                    scanner.nextLine();
                }
            }
            else {
                System.out.println("Введите целое число больше 1:");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.println("Введите название товара:");
            scanner.nextLine();
            gc.goodName = scanner.nextLine();

            System.out.println("Введите стоимость товара [копейки.рубли] (например, 40.25):");
            while (true) {
                if (scanner.hasNextDouble()) {
                    gc.goodPrice = scanner.nextDouble();
                    if (gc.goodPrice > 0) {
                        break;
                    }
                    else {
                        System.out.println("Введите число больше 0:");
                        scanner.nextLine();
                    }
                }
                else {
                    System.out.println("Введите число больше 0:");
                    scanner.nextLine();
                }
            }

            gc.addGood(gc.goodName, gc.goodPrice);
            System.out.println("\n\nТовар успешно добавлен! Текущая общая сумма: " + gc.goodSumPrice + " " + gc.rubleEnding(gc.goodSumPrice));

            System.out.println("Хотите добавить еще товар? Чтобы завершить, введите \'Завершить\'");
            contunieGoodAdding = scanner.next();
            if (contunieGoodAdding.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        resultSumPerPerson = String.format("%.2f" ,gc.goodSumPrice/peopleNumber);
        System.out.println("\n\n" + gc.goodSumName + "\n\nОбщая сумма: " + gc.goodSumPrice + " " + gc.rubleEnding(gc.goodSumPrice) + "\nС каждого участника: " + resultSumPerPerson + " " + gc.rubleEnding(gc.goodSumPrice/peopleNumber));












    }



}

