import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        byte friends;



        while (true) {
            System.out.println("Введите числовое количество участников:");
            Scanner input = new Scanner(System.in);
            if (input.hasNextByte()) {
                friends = input.nextByte();
                if (friends <= 1) { System.out.println("Нет смысла делить счёт. Попробуйте ещё раз.");}
                else if (friends > 1) {
                    break;
                }
            }
            else {
                System.out.println("Требуется указать числовое значение!");
            }
        }

        //Вызов Dishes


        //Окончания рублей (oh no...)
        String result = "";
        float total;

        int num100 = (int) (Math.floor(total % 100));
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


        System.out.print("Добавленные товары: " + storeProducts);
        System.out.println("Сумма к оплате каждым гостем:" + String.format("%.2f", finalResult) + " " + ending);
    }
}
