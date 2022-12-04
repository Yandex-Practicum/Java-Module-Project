import java.util.Scanner;

public class Products {
    static String exit = "ЗАВЕРШИТЬ";

    public static void calc(int people) {
        String product;
        String allProducts = "";
        float costPrice;
        float sumForall = 0.00f;

        String close;
        while (true) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Введите название товара");
            product = scanner2.nextLine();
            System.out.println("Товар " + product + " добавлен в счёт");
            System.out.println("Введите стоимость товара в формате: 'рубли.копейки' [пример - 10.45, 11.40]");
            if (scanner2.hasNextFloat()) {
                costPrice = scanner2.nextFloat();
                if (costPrice > 0) {
                    sumForall = sumForall + costPrice;
                    allProducts = allProducts + product + "\n";
                    String sufForOne = Calculator.complete(costPrice);
                    String anotherOne = "Вы добавили: %s за %.2f%s\n";
                    System.out.printf(anotherOne, product, costPrice, sufForOne);
                    System.out.println("Введите любой символ, если хотите добавить товар. В противном случае введите:'ЗАВЕРШИТЬ'");
                    close = scanner2.next();
                    if (close.equalsIgnoreCase(exit)) {
                        break;
                    }
                } else {
                    System.out.println("Сумма указана неверно");
                }
            } else {
                System.out.println("Некорректный формат стоимости товара. Побробуйте ввести сумму ещё раз!");
            }

        }
        String suf = Calculator.complete(sumForall);
        float forOneguest = sumForall/ people;
        String lastSuf = Calculator.complete(forOneguest);

        System.out.println("Вы купили:\n" + allProducts + "За " + String.format("%.2f", sumForall) + suf);
        System.out.println("Каждый из гостей должен заплатить: " + String.format("%.2f", forOneguest) + lastSuf);
        System.out.println("Спасибо,что воспользовались нашим Калькулятором - счётчиком!");


    }
}