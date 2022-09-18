import java.util.Scanner;

public class Product{
    String productName;
    double price;



    Product(String productName, double price){
        this.productName = productName;
        this.price = price;
    }

    public static double calculate(int peopleNum){
        double check = 0;
        String commandStop = "завершить";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите товары и их стоимость по очереди. По завершению ввода введите ключевое слово 'завершить'");
//        scanner.close();
        do {
            System.out.println("Введите наименование товара");
            String userInputName = scanner.next();

            System.out.println("Введите стоимость товара в формате рубли.копейки");
            double userInputPrice = scanner.nextDouble();
            check += userInputPrice;
        }while(!commandStop.equalsIgnoreCase(productName.trim()));

        return check / peopleNum;
    }
}
