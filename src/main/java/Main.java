import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int amountFreinds;
        while (true){
            System.out.println("Наскольких человек необходимо разделить счет");
            amountFreinds=scanner.nextInt();
            if(amountFreinds > 1) {
                break;
            }else if (amountFreinds == 1) {
                System.out.println("На одного человека нет смысла делить,приведите друзей,проведите хорошо время и разделите с ними счет.");
            }else{
                System.out.println("Неверное количество друзей,введите другое значение,т.к,значение не может быть меньше единицы.");
            } // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        }
        Сalculator calculator = new Сalculator (amountFreinds);
        while (true) {
            System.out.println("Введите название товара");
            String name = scanner.next();
            System.out.println("Введите название товара и его стоимость в формате: 'рубли.копейки' [10.45, 11.40].");
            double price = scanner.nextDouble();
            calculator.addItem(new Iteam(name, price));
            System.out.println("Хотите ввестии еще товары?Если нет,то напишите 'Завершить'.");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        double result = calculator.divideSum();
        Conclusion conclusion = new Conclusion();
        System.out.println(calculator.cart);
        System.out.println("Каждому человеку к оплате: " + conclusion.roundResult(result)) ;
    }
    }
