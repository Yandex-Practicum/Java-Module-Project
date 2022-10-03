import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int guestsCount = guestsCount();
        float total = addProducts();
        float each = total/guestsCount;
        int intEach = (int) each;
        String formattedEach = String.format("%.2f", each);
        if(intEach >= 10 && intEach <= 20) {
            printed(formattedEach, "ей");
        }
        else if(intEach%10 == 1){
            printed(formattedEach, "ю");
        }
        else if(intEach%10 > 1 && intEach%10 < 5){
            printed(formattedEach, "я");
        }
        else{
            printed(formattedEach, "ей");
        }

    }
    public static void printed(String formattedEach, String stringEnd){
        System.out.println("С каждого по " + formattedEach + " рубл" + stringEnd);
    }

    public static float addProducts(){
        float total;
        Scanner scanner = new Scanner(System.in);

        List<Product>products = new ArrayList<Product>();
        while (true){
            System.out.println("Введите название товара или напишите \"Завершить\"");
            String productName = "";
                    String productName1 = scanner.nextLine();
            if(products.size() != 0) {
                 productName = scanner.nextLine();
            }
            if(productName.equalsIgnoreCase("Завершить")){
                break;
            }
            System.out.println("Теперь введите цену товара");
            double price; //любое отрицательное значение подойдет :)
            while (true){
                String input = scanner.next();
                try{
                    price = Double.parseDouble(input);
                    if(price < 0) {
                        System.out.println("Воу-воу, у вас там деньги дают за еду? Позовите меня! А пока вы это делаете, попрошу вас ввести еще раз!");
                    }
                    else{
                        break;
                    }
                }
                catch (Exception ParseException) {
                    System.out.println("Пожалуйта, введите цену в виде числа");
                }
            }
            String priceFormatted = String.format("%.2f", price);
            Product newProd = new Product("Abc", 0);
            if(products.size() != 0){
                newProd = new Product(productName, Float.parseFloat(priceFormatted));
            }
            else {
                newProd = new Product(productName1, Float.parseFloat(priceFormatted));
            }

            products.add(newProd);
            System.out.println("Товар успешно добавлен!");
            total = 0;
        for(int i = 0; i < products.size(); i++){

            total += products.get(i).price;
        }
            System.out.println("Текущая общая сумма - " + total);
        }
        total = 0;
        for(int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).name);
            total += products.get(i).price;
        }
            System.out.println("Текущая общая сумма - " + total);

        return total;

    }

    public static int guestsCount() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите количество человек, на которых будет разделен счет :)");
            int number; //и тут тоже подойдет любое отрицательное значение
            while(true){
                try{
                    String input = scanner.next();
                    number = Integer.parseInt(input);
                    if (number < 1) {
                        System.out.println("Некорректное значение! Пожалуйста, введите снова.");
                    } else if (number == 1) {
                        System.out.println("Вы не поверите! Если число делить на 1, то получится оно же, как и в случае со счетом! Пожалуйста, введите снова :)");
                    } else {
                        return number;
                    }
                }
                catch (Exception ParseException){
                    System.out.println("Некорректное значение! Пожалуйста, попоробуйте снова.");
                    break;
                }
            }

        }
    }
}



class Product{
    String name;
    float price;

    public Product(String prodName, float prodPrice){
        name = prodName;
        price = prodPrice;

    }

}
