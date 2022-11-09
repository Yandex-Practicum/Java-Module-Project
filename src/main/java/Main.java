import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Получаем входные параметры для счета в ресторане
        byte count;
        count = askPersonCount();

        // Добавляем блюда к счету
        Receipt tonightParty = new Receipt();
        Scanner menuTitle = new Scanner(System.in);
        Scanner menuTitlePrice = new Scanner(System.in);
        String dishTitle;
        float dishCost;

        while (true) {
            System.out.println("\nХотите добавить еще одно блюдо в счет? Нет - наберите \"завершить\"; Да - введите наименование блюда: ");
            dishTitle = menuTitle.nextLine();

            if (dishTitle.equalsIgnoreCase("ЗАВЕРШИТЬ"))
                break;

            System.out.println("Введите стоимость блюда (руб,коп): ");
            while (true) {
                if (!menuTitlePrice.hasNextFloat()) {  // Проверем, что это дробное число
                    System.out.println("Требуется числовое значение цены блюда: ");
                    menuTitlePrice.next(); // Пропускаем шум вместо нужного ввода
                } else {
                    dishCost = menuTitlePrice.nextFloat();
                    if (dishCost < 0)
                        System.out.println("Требуется положительное значение цены блюда: ");
                  else
                      break;
                    }
                }
            tonightParty.addDish(dishTitle);
            tonightParty.addSum(dishCost);
            }


        printOut( count );  // Печатаем результаты
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
        String ending = "";

        int average = (int) Math.floor(Receipt.totalPrice / persons);
        int averageTens = average % 100;
        int averageUnits = average % 10;

        if ((10 < averageTens) && (averageTens < 20)) {
            switch ( averageTens ) {
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    ending = "рублей";
                    break;
            }   // no default
        } else {

            switch (averageUnits) {
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
                    ending = "рублей";
                    break;
                default:
                    ending = "рублей";
                    break;
            }
        }
        System.out.println("\n\nВаш заказ сегодня:\n" + Receipt.totalDishes);
        System.out.println("\nОбщая сумма к оплате: " + String.format("%.2f", Receipt.totalPrice));
        System.out.println("\n\nКоличесво гостей: " + persons);
        System.out.println("\nСумма для оплаты каждым гостем: " + String.format("%.2f", Receipt.totalPrice / persons) + " " + ending + "\n\n");
    }

}