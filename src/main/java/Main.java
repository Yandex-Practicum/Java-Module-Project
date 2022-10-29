import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Здравствуйте! На сколько человек разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        while (true) {
            try {
                x = scanner.nextInt();
                if (x >= 2) { // если пользователь вводит корректное значение
                    System.out.println();
                    break;
                }
            } catch (Exception e) {
                scanner.next();
            }
            System.out.println("Введено некорректное значение, попробуйте еще.");
        }
        Calculator.calculator(x);
    }

//
//
//    public static void calculator(int delitel) {
//
//        Scanner scannerProduct = new Scanner(System.in);
//        String allProduct = "";
//        Float allPrice = 0.0f;
//        while (true) {
//            System.out.println("Введите название товара");
//            String product = scannerProduct.next();
//            String and = "Завершить";
//            if (product.equalsIgnoreCase(and)) {
//                break;
//            }
//
//            System.out.println("Введите стоимость товара (рубли.копейки)");
//            Float price = cost();
//            allProduct = allProduct + "\n" + product + ": " + price;
//            allPrice = allPrice + price;
//            System.out.println("Товар добавлен, хотите добавить еще товар ?  \n Если нет, введите команду \"Завершить\"");
//            String answer = scannerProduct.next();
//            if (answer.equalsIgnoreCase(and)) {
//                break;
//            }
//
//        }
//        float personPrice = allPrice / delitel;
//        String personPriceString = String.format("%.2f", personPrice);
//        int personPriceInteger = (int) personPrice;
//        String rub = conjugation(personPriceInteger);
//        System.out.println("Добавленные товары:" + "\n" + allProduct + "\n" + "Сумма к оплате для каждого человека - " + personPriceString + rub);
//
//    }
//
//    //введение цены
//    public static float cost() {
//        Scanner scanner = new Scanner(System.in);
//        float price = 0.0f;
//        try {
//            String value = scanner.next().trim();
//            price = Float.parseFloat(value);
//            int pointPosition = value.indexOf('.');
//            if (!(pointPosition == -1 || value.length() - 1 - pointPosition <= 2)) {
//                System.out.println("Введено некорректное значение, попробуйте еще.");
//                price = cost();
//            }
//            if (price > 0) {
//                System.out.println("Введено некорректное значение, попробуйте еще.");
//                price = cost();
//            }
//        } catch (Exception e) {
//            System.out.println("Введено некорректное значение, попробуйте еще.");
//            price = cost();
//        }
//
//        return price;
//    }

//    public static String conjugation(int integer) {
//        int remainder = integer % 100;
//        if (remainder >= 11 && remainder <= 14) {
//            return "рублей";
//        }
//        remainder = integer % 10;
//        switch (remainder) {
//            case 1:
//                return "рубль";
//            case 2:
//            case 3:
//            case 4:
//                return "рубля";
//            case 0:
//            case 5:
//            case 6:
//            case 7:
//            case 8:
//            case 9:
//                return "рублей";
//            default:
//                return "рубль";
//        }
//
//    }
}

