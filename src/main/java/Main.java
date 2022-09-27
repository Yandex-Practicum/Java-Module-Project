import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int guestsCount = count();
        float total = addProducts();
        float each = total/guestsCount;
        int intEach = (int) each;
        String formattedEach = String.format("%.2f", each);
        if(intEach%10 == 1){
            System.out.println("С каждого по " + formattedEach + " рублю");
        }
        else if(intEach%10 > 1 && intEach%10 < 5){
            System.out.println("С каждого по " + formattedEach + " рубля");
        }
        else{
            System.out.println("С каждого по " + formattedEach + " рублей");
        }

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
            double price= -1.7;
            while (price < 0){
                String input = scanner.next();
                try{
                    price = Double.parseDouble(input);
                    if(price < 0) {
                        System.out.println("Воу-воу, у вас там деньги дают за еду? Позовите меня! А пока вы это делаете, попрошу вас ввести еще раз!");
                        break;
                    }
                }
                catch (Exception ParseException){
                    System.out.println("Пожалуйта, введите цену в виде числа");
                }
            }
            String price2 = String.format("%.2f", price);
            Product newProd = new Product("Abc", 0);
            if(products.size() != 0){
                newProd = new Product(productName, Float.parseFloat(price2));
            }
            else {
                newProd = new Product(productName1, Float.parseFloat(price2));
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

    public static int count() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите количество человек, на которых будет разделен счет :)");
            int number = -1;
            while(number < 0){
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
