import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Получаем входные параметры для счета в ресторане
        byte count;
        count = askPersonCount();

        // Добавляем блюда к счету
        Receipt tonightParty = new Receipt();
        Scanner dishScan1 = new Scanner(System.in);
        Scanner dishScan2 = new Scanner(System.in);
        String dishTitle;
        float dishCost;

        while (true) {
            System.out.println("\nХотите добавить еще одно блюдо в счет? Нет - наберите \"завершить\"; Да - введите наименование блюда: ");
            dishTitle = dishScan1.nextLine();

            if (dishTitle.equalsIgnoreCase("ЗАВЕРШИТЬ"))
                break;

            System.out.println("Введите стоимость блюда (руб,коп): ");
            dishCost = dishScan2.nextFloat();

            tonightParty.addDish(dishTitle);
            tonightParty.addSum(dishCost);
        }

        printOut( count );

    }

    public static byte askPersonCount() { // Метод входных параметров для счетчика
        byte personCount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте! Введите число гостей: ");

        while (true) {
            if (!scanner.hasNextByte()) {  // Проверем, что это целое число
                System.out.println("Требуется числовое значение количества гостей от 1 до 127: ");
                scanner.next(); // Пропускаем шум вместо нужного ввода

            } else {
                personCount = scanner.nextByte();
                if (personCount < 1)
                    System.out.println("Требуется положительное значение. Введите число гостей от 1 до 127: ");
                else {
                    if (personCount == 1) {
                        System.out.println("Для одного гостя нет смысла ничего считать и делить. Введите число гостей от 2 до 127: ");
                    } else
                        break;
                }
            }
                   }
        return personCount;
    }

    public static void printOut(int persons) {    // Выводим результаты
        String ending;

        switch ( (int)((Math.floor(Receipt.totalPrice / persons)) % 10)) {
            case 1:
                ending = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                ending = "рубля";
                break;
            case 0:
                case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                ending = "рублей";
                break;
            default:
                ending = "рублей";
                break;
        }

        System.out.println("\n\nВаш заказ сегодня:\n" + Receipt.totalDishes);
        System.out.println("\nОбщая сумма к оплате: " + String.format("%.2f", Receipt.totalPrice));
        System.out.println("\n\nКоличесво гостей: " + persons);
        System.out.println("\nСумма для оплаты каждым гостем: " + String.format("%.2f", Receipt.totalPrice / persons) + " " + ending + "\n\n");
    }

}