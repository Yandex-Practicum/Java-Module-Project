import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("Привет Мир");

        //считываем кол-во гостей
        System.out.println ("Введите колличество гостей");
        int visitor = -1;
        while (visitor != 0 ) {
            visitor = Scanner.nextInt();
            if (visitor <=1)
                System.out.println("Некорректное кол-во гостей");
            else
                if (visitor > 1) {
                    break;
                }
        }
        //считываем кол-во товаров
        boolean enough = true;
        int i = 0 ;
        String name = "";
        String receipt = "";
        double price = 0;

        while (enough) {
            System.out.println("Введите название ");
            name = Scanner.next();
            receipt = String.format("%s/n%s", receipt, name);
            System.out.println("Введите  цену");
            price = price + Scanner.nextInt();
            System.out.println(price);
            System.out.println(receipt);
            System.out.println("Хотите ввести ещё товар?");
            System.out.println("Eсли вы хотите ввести ещё товар, введите ДА");
            System.out.println("Eсли вы хотите ввести ещё товар, введите Завершить ");
            String answer = Scanner.next();

            if (String.equalsIgnoreCase(answer, "завершить")){
                enough = false;
                break;

            }
        }

        if (enough = false){
            System.out.println("Добавленные товары:");
            System.out.println(receipt);
            double pay = receipt/visitor;
            System.out.println(pay);
        }

    }
}
