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
            double price = scanner.nextDouble();
            totalPrice =totalPrice + price;
            System.out.println("Товар успешно добавлен!\nЕсли хотите добавить еще товар введите любой символ.\nДля завершения создания списка напините \"Завершить\".");
            String result = scanner.next();
            if(result.equalsIgnoreCase("Завершить")){
                break;
            }

        }


        }
    public static String whichRub(double num){
        int sum = (int)num;
        if(sum % 10 == 1 && sum != 11 && sum % 100 != 11){
            return "рубль";
        }
        else if(sum % 10 >= 2 && sum % 10 <= 4 ){
            return "рубля";
        }
        else{
            return "рублeй";
        }
    }
    public static void makeList() {
        double priceForOne = totalPrice / People.persons;
        String end = "Добавленные товары:\n%s%.2f %s должен заплатить каждый человек.";
        System.out.println(String.format(end, listProduct, priceForOne,whichRub(priceForOne)));
    }
}

