import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int people;
        String rubles;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Сколько Вас человек");
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
                if (people == 1) {
                    System.out.println("Нет смысла считать, для одного человека");
                }
                if (people <= 0){
                    System.out.println("Некорректное значение");
                }
                if (people > 1) {
                    break;
                }
            }
            else {
                System.out.println("Некорректное значение");
            }

        }

        Calculator calculate = new Calculator();
        calculate.counting();

            if (Math.floor(calculate.cost / people) == 1) {
                rubles = "рубль";
            }
            else if (calculate.cost / people >= 2 && calculate.cost / people < 5) {
                rubles = "рубля";

            } else {
                rubles = "рублей";

        }
        String str = String.format(calculate.productList + '\n' + "Итоговая стоимость всех продуктов %.2f" + '\n' + "Каждый заплатит %.2f " + rubles, calculate.cost, calculate.cost/people );
        System.out.println(str);

    }

}
