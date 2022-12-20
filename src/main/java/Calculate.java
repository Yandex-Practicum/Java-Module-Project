import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        People.people();
    }
    public static class Calculate{
        public static double count = 0;
        public static double x;
        public static String product1;
        public static void calculate() {
            while(true){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите продукт ");
                String product = scanner.next();
                product1 = product1 + " " + product;
                System.out.println("Введите стоимость рубли и копейки");
                double cost = scanner.nextDouble();
                System.out.println(product + " добавлено:)");
                count = count + cost;
                System.out.println("Стоимость плюс " + count);
                System.out.println("Хотите добавить?");
                String stop = scanner.next();
                String stop1 = "Нет";

                x = count / People.quest;
                if (stop1.equalsIgnoreCase(stop)){
                    Result.result();
                    return;
                }
                else {
                    continue;
                }

            }
        }
    }
    public static class People{
        public static int quest;
        public static void people(){
            while (true){
                System.out.println("Как много у вас гостей?");
                Scanner scanner = new Scanner(System.in);
                quest = scanner.nextInt();
                if (quest<= 1){
                    System.out.println("Плати сам за все!");
                }
                else if (quest >= 2){
                    Calculate.calculate();
                    break;
                }
            }
        }
    }


    public static class Result{
        public static void result(){
            System.out.println("Всего блюд заказано: " + Calculate.product1);
            System.out.printf("Окончательный расчет: " +  ":%.2f.\n",Calculate.count);
            System.out.printf("Каждый должен заплатить: " + "%.2f",Calculate.x);

        }
    }

}
