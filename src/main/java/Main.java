import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимость
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек нужно разделить счет ?");
        while (!scanner.hasNextInt()) {
            System.out.println("Введите корректное значение :");
            scanner.next();
        }
        int human = scanner.nextInt();


        while (human <= 1) {
            if (human < 1) {
                System.out.println("Колличество человек " + human);
                System.out.println("некоректное значение для подсчета.Введите колличество человек заного ");
                human = scanner.nextInt();
            }
            if (human == 1) {
                System.out.println("Колличество человек " + human);
                System.out.println("нет смысла ничего считать и делить.Введите колличество человек заного");
                human = scanner.nextInt();
            }
        }
        Calculate calculate = new Calculate();

            calculate.product();



        double check = calculate.sum / human;

        System.out.println("Счет нужно разделить на : " + human + " " + calculate.GetHumanAdddition(human));
        System.out.println("Список выбранных товаров: ");
        for (String str : calculate.menuList) {
            System.out.println(str);
        }
        System.out.println("Общая сумма заказа : " + String.format("%.2f", calculate.sum) + " " + calculate.GetRubleAddition(calculate.sum));
        System.out.println("Каждый должен заплатить :" + String.format("%.2f", +check) + " " + calculate.GetRubleAddition(check));


    }
}





