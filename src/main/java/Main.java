import java.util.Locale;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    private final static Calculate calculate = new Calculate();;

    public static void main(String[] args) {

        System.out.println("Введите кол-во гостей");
        while(true){
            int countUsers = calculate.usersRightNumber();

            if (countUsers < 1){
                System.out.println("Введите корректное число: 1 или больше");
            } else if (countUsers == 1){
                System.out.println("Нет смысла в пересчете");
                break;
            } else{
                addItem();
                System.out.println("Добавленные товары:\n" + calculate.menu);

                System.out.println("Каждый должен заплатить: " + calculate.check(countUsers) + " " + calculate.formatRuble());
                break;
            }
        }
    }

    // добавление продукта
    private static void addItem(){
        String answerForAdd;
        while(true){
            System.out.println("Хотите добавить товар? Если нет, напишите \"Завершить\"");
            answerForAdd = scanner.next();
            if (answerForAdd.equalsIgnoreCase("завершить")){
                return;
            } else {
                System.out.println("Введите наименование товара");
                String nameItem = scanner.next();
                System.out.println("Введите стоимость товара в формате 'рубли.копейки' [10.45, 11.40]");
                double priceItem = calculate.countRightNumber();

                Item item = new Item(nameItem, priceItem);

                calculate.sumPrice(priceItem);
                calculate.recordItems(item);

                System.out.println("Товар успешно добавлен");
            }
        }

    }
}
