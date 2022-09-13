import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
inputParameters();

    }
    public static void inputParameters(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько персон делить чек?");
        int person = 0;

        while (!scanner.hasNextInt()) {
                   System.out.println("Некорректное значение для подсчёта, попробуйте еще раз");
                   scanner.next();
               }
        while (true) {
            person = scanner.nextInt();
            if (person > 1) {
                System.out.println("Давайте посчитаем!");
                Calculate.product(person);
            }
            if (person == 1) {
                System.out.println("Вы оплачиваете счет сами");
                Calculate.product(person);
            }
            if (person < 1) {
                System.out.println("Некорректное значение для подсчёта, попробуйте еще раз");


            }
        }
    }
}