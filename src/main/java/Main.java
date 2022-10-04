import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь

        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("Привет Мир");
        Scanner scanner = new Scanner(System.in);
        //считываем кол-во гостей
        int visitor = -1;

        System.out.println ("Введите колличество гостей");
        while (visitor != 0 ) {
            visitor = scanner.nextInt();
            if (visitor <=1) {
                System.out.println("Некорректное кол-во гостей");
                System.out.println("Введите колличество гостей");
            }
            else
                if (visitor > 1) {
                        break;
                    }
        }
        //считываем кол-во товаров
        boolean enough = true;

        Product list = new Product();
        Calculate menu_list = new Calculate();
        while (enough) {
            System.out.println("Введите название ");
            list.name = scanner.next();
            System.out.println("Введите  цену");
            String str = scanner.next();
            while (!isNumeric(str)) {
                System.out.println("Введите цену с разделителем \".\" ");
                str = scanner.next();
            }
            list.price = Double.parseDouble(str);
            menu_list.getAddList(list.name, list.price);
            menu_list.getListPrice(list.price);
            System.out.println("Хотите ввести ещё товар?");
            System.out.println("Eсли вы хотите ввести ещё товар, введите ДА");
            System.out.println("Eсли вы хотите ввести ещё товар, введите Завершить ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("завершить")) {
                enough = false;
                break;
            }
        }

        if (!enough){
            System.out.println("Добавленные товары:");
            System.out.println(menu_list.receipt);
            float pay = (float) (menu_list.pay/visitor);
            String rubString = "";
            int rub = (int) (pay % 10);

            if ((rub == 0 ) || (rub == 5) || (rub == 6) || (rub == 7 ) || (rub == 8 ) || (rub == 9)){
                rubString = "рублей";
            } else if ((rub == 2) || (rub == 4) || (rub == 3) ){
                rubString = "рубля";
            } else if (rub == 1) {
                rubString = "рубль";
            }

            String message = "Каждый должен заплатить %.2f %s";

            System.out.println(String.format(message, pay, rubString));
        }
    }
    public static class Calculate{
        String receipt = "";
        double pay = 0;

        public void getAddList (String name, double price) {
             receipt = receipt  + String.format("%s %.2f \n",
                    name,
                    price);
             System.out.println("Товар успешно добавлен");
        }

        public void getListPrice(double price){
             pay = pay + price;
        }
    }

    public static class Product {
        String name;
        double price;
    }

    public static boolean isNumeric(String string) {
        double value;

        if(string == null || string.equals("")) {
            return false;
        }
        try {
            value = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }
}
