import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько персон делить чек?");
        int person = scanner.nextInt();
        while (true) {

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
                break;
            }
        }
    }
}






