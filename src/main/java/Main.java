import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        byte friends;
        String result = "";



        while (true) {
            System.out.println("Введите числовое количество участников:");
            Scanner input = new Scanner(System.in);
            if (input.hasNextByte()) {
                friends = input.nextByte();
                if (friends <= 1) {
                    System.out.println("Нет смысла делить счёт. Попробуйте ещё раз.");
                } else if (friends > 1) {
                    break;
                }
            } else {
                System.out.println("Требуется указать числовое значение!");
            }
        }

        Dishes count = new Dishes();


        //Окончания рублей (oh no...)

        int num100 = (int) (Math.floor(count.total % 100));
        if (num100 > 4 && num100 < 21) {
            result = "Рублей";
        } else {
            int num10 = num100 % 10;
            if (num10 == 1) {
                result = "Рубль";
            } else if (num10 > 1 && num10 < 5) {
                result = "Рубля";
            } else{
                result = "Рублей";
            }
        }


        System.out.println("Вы заказали:\n" + count.table);
        System.out.println("Общая стоимость блюд: " + count.total);
        System.out.println("Сумма к оплате каждым участником:" + String.format("%.2f", count.total/friends) + " " + result);
    }
}
