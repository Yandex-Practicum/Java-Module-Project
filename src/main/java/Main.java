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
        if(intEach%10 == 1 && intEach != 11){
            printed(formattedEach, "ю");
        }
        else if(intEach%10 > 1 && intEach%10 < 5 && (11 >intEach || intEach > 15)){
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
        List<Product>products = new ArrayList<Product>();
        while (true){
            String productName = nameInput(products);
            if(productName.equalsIgnoreCase("Завершить")){
                break;
            }
            double price = priceInput();
            String priceFormatted = String.format("%.2f", price);
            Product newProd;
            newProd = new Product(productName, Float.parseFloat(priceFormatted));
            products.add(newProd);
            System.out.println("Товар успешно добавлен!");
            currentSummary(products, false);
        }
        return currentSummary(products, true);}

    public static float currentSummary(List<Product> products, boolean printProducts){
        float total = 0;
        for(int i = 0; i < products.size(); i++){
            if(printProducts) {
                System.out.println(products.get(i).name);
            }
            total += products.get(i).price;}
        System.out.println("Текущая общая сумма - " + total);
        return total;
    }

    public static String nameInput(List<Product> products){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название товара или напишите \"Завершить\"");
        String productName = "";

        if(products.size() != 0) {
            productName = scanner.nextLine();
            return productName;
        }else {
            return scanner.nextLine();
        }

    }

    public static double priceInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Теперь введите цену товара");
        double price;
        while (true){
            String input = scanner.next();
            try{
                price = Double.parseDouble(input);
                if(price < 0) {
                    System.out.println("Воу-воу, у вас там деньги дают за еду? Позовите меня! А пока вы это делаете, попрошу вас ввести еще раз!");
                }
                else{
                    return price;
                }
            }
            catch (Exception ParseException) {
                System.out.println("Пожалуйта, введите цену в виде числа");}}}

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
