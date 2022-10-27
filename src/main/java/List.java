import java.util.Scanner;

public class List {
   static double totalPrice = 0.00f;
   static String listProduct = "";
    public static void requestProduct() {
        Scanner scanner = new Scanner(System.in);

        while(true) {


            System.out.println("Введите название товара");
           String name = scanner.next();
            listProduct = listProduct.concat(name + ";\n");
            System.out.println("Введите цену товара");
            double price = checkFailPrice();
            totalPrice += price;
            System.out.println("Товар успешно добавлен!\nЕсли хотите добавить еще товар введите любой символ.\nДля завершения создания списка напините \"Завершить\".");
            String result = scanner.next();
            if(result.equalsIgnoreCase("Завершить")){
                break;
            }

        }


    }
    public static String whichRub(double num){
        int sum = (int)num;
        sum = sum % 100;
        if(10<sum && sum<15){
            return "рублeй";
        }
        int sum1 = sum % 10;
        switch(sum1){
            case 1: return "рубль";
            case 2:
            case 3:
            case 4: return "рубля";

        }
        return "рублeй";
    }
    public static void makeList() {
        double priceForOne = totalPrice / People.persons;
        String end = "Добавленные товары:\n%s%.2f %s должен заплатить каждый человек.";
        System.out.println(String.format(end, listProduct, priceForOne,whichRub(priceForOne)));
    }
    public static double checkFailPrice() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            boolean hasDouble = scanner.hasNextDouble();
            if(hasDouble) {
                double trueDouble = scanner.nextDouble();
                if (trueDouble > 0) {
                    return trueDouble;
                } else {
                    System.out.println("Ошибка! Введите корректную цену.");
                }
            }
            else {
                System.out.println("Ошибка! Введите корректную цену.");
            }
        }
    }
}

