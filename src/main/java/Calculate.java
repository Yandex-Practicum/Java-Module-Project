import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {
    static double total;
    int persons;
    public void qPerson() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек необходимо разделить счет?");
        int qPerson = scanner.nextInt();

        while (qPerson < 2) {
            System.out.println("Нет смысла делить счет меньше чем на двух человек!");
            System.out.println("На сколько человек необходимо разделить счет?");
            qPerson = scanner.nextInt();
        }
        persons=qPerson;
    }

    public void addProducts() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();

        while (true) {
            System.out.println("Введите название товара или напишите 'завершить'");
            String product = scanner.next();
            if (product.equalsIgnoreCase("завершить")) {
                break;
            } else {
                System.out.println("Введите цену товара в формате 'рубли,копейки'");
                double price = scanner.nextDouble();
                products.add(product);
                total = total + price;
                System.out.println("Товар " + product + " успешно добавлен по цене " + String.format("%.2f", price));
            }
        }

        System.out.println("Добавленные товары:" + "\n" + String.join("\n", products));
        System.out.println("Каждый человек должен заплатить: "+String.format("%.2f",total/persons) +" "+ endOfWord(total/persons));
    }

    public String endOfWord(double a){
        int tseloeA=(int)Math.floor(a);
        if (tseloeA % 100 >5 && tseloeA<=20){return "рублей";}
        else if (tseloeA % 10==1){ return "рубль";}
        else if (tseloeA % 10>1 && tseloeA % 10<5){return "рубля";}
        return "рублей";
    }
}





