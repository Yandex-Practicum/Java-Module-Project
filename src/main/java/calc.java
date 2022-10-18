import java.util.Scanner;

public class calc {

    public static double calculator() {
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);
        for (String i = "Добавленные товары:"; 1 != 0; i = i) {
            for (double j = 0; j >= 0; j = j) {
                System.out.println("Пожалуйста, введите название товара.");
                String itemName = scan2.nextLine();
                System.out.println("Пожалуйста, введите цену товара в формате 'рубли.копейки' [10.45, 11.40]");
                double itemCost = scan3.nextDouble();
                System.out.println("Товар добавлен в список.");
                i = i + "\n" + itemName + " " + itemCost + ending(itemCost);
                j = j + itemCost;
                System.out.println("Хотите ли бы вы завершить покупки?");
                String answer = scan4.nextLine();
                String stopWord = "Завершить";
                if (answer.equalsIgnoreCase(stopWord)) {
                    System.out.println(i);
                    System.out.println("Общая сумма покупок: " + j + ending(j));
                    return j;
                }
            }
        }
    }
    public static String ending(double j){
        if(Math.floor(j) % 100 == 11 ^ Math.floor(j) % 100 == 12 ^ Math.floor(j) % 100 == 13 ^ Math.floor(j) % 100 == 14){
            String stringe = " рублей";
            return stringe;
        }
        else {
            double summ = Math.floor(j) % 10;
            int remainder = (int) summ;
            switch (remainder) {
                case 1:
                    String string1 = " рубль";
                    return string1;
                case 2:
                    String string2 = " рубля";
                    return string2;
                case 3:
                    String string3 = " рубля";
                    return string3;
                case 4:
                    String string4 = " рубля";
                    return string4;
                default:
                    String stringdef = " рублей";
                    return stringdef;
            }
        }
    }
}