import java.util.Scanner;
import java.util.ArrayList;

public class ProductsList {
    static Scanner scanner = new Scanner(System.in);
    static String products; //Для названия товара
    static double price;    //Для цены
    static ArrayList<String> listString = new ArrayList<>();   //Список для String
    static ArrayList<Double> listDouble = new ArrayList<>();   //Список для Double
    static int numbersOfGuests;


    //**********************************************************************************************
    //Метод для подсчёта гостей
    public static int menuChoice() {
        while (true) {          //Проверка
            System.out.println("Введите количество гостей: ");

            if (scanner.hasNextInt()) {
                numbersOfGuests = scanner.nextInt();
                if (numbersOfGuests > 1) {
                    System.out.println("сюда калькулятор");
                    productsChoice();
                    break;
                } else if (numbersOfGuests == 1) {
                    System.out.println("И зачем я тогда писал калькулятор? " +
                            "Введите от 1-го, Христа ради: ");
                } else if (numbersOfGuests == 0) {
                    System.out.println("Если у нас 0 гостей, тогда кого считаем то? " +
                            "Попытка №2: ");
                } else {
                    System.out.println("Там умер кто?! " +
                            "Или почему кол-во гостей отрицательное? " +
                            "Давай ещё раз попробуем: ");
                }

            } else if (scanner.hasNextDouble()) {
                System.out.println("Вы пришли с детьми! " +
                        "Как мило! " +
                        "Посчитайте их как взрослого человека: ");
                scanner.nextLine();

            } else {
                System.out.println("Введите хотя-бы число: ");
                scanner.nextLine();
            }
        }
        return numbersOfGuests;
    }

    //**********************************************************************************************
    //Метод для добавления названия и цены товарам
    public static void productsChoice() {

        String answer;

        while (true) {
            System.out.println("Введите название товара: ");
            products = scanner.next();
            System.out.println("Введите цену товара: ");

            while (true) {
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    if (price < 0) {
                        System.out.println("По-моему наш ресторан не так работает. " +
                                "Это не мы должны платить нам, а наоборот." +
                                "\nПрошу: ");
                    } else {
                        listString.add(products);   //Добавляем в список название продукта
                        listDouble.add(price);      //Добавляем в список цену продукта
                        System.out.println("Кушанье добавлено! ");
                        break;
                    }

                } else {
                    System.out.println("Надо числами! Числами!!! " +
                            "Например 10.50 or 11.00, you know?: ");
                    scanner.nextLine();
                }
            }
            //Спрашиваем хочет или не хочет, а может хочет и молчит? Хочет и молчит?
            System.out.println("Не желаете ли вы добавить ещё товаров, мой господин?" +
                    "\nЕсли хотите, то шлёпните по клавиатуре ладонью и пусть будет что будет. " +
                    "\nКоли желаете завершить сей процесс, то так и напишите - \"Завершить\". " +
                    "\nНу либо же введите \"Да\", чтобы мне засчитали это в ТЗ: ");

            answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить")) {     //Приводим всё к одному регистру и сверяем ввод с "Завершить"
                //Показать продукты
                System.out.println("Добавленные товары: ");
                for (String s : listString) {
                    System.out.println("Кушанье: " + s);     //Вывод всех товаров
                }
                break;

            } else if (answer.equalsIgnoreCase("Да")) {
                System.out.println("Молодец! Продолжаем: ");
            } else {
                System.out.println("Okay let's goooooooooo: ");
            }
        }
    }

    //**********************************************************************************************
    //Соклько кто должен + окончания
    public static Double debt() {
        double sum = 0;
        for (double d : listDouble) {    //Считаем сумму
            sum += d;
        }
        System.out.println("Всего накушали: " + endingRUB(sum));
        System.out.println("Если по-чесноку, то с каждого: " + endingRUB(sum / numbersOfGuests));
        return null;
    }
    //окончания
    public static String endingRUB(double sum){
        int ending = (int)sum % 10;
        String formatEnding = String.format("%.2f", sum);
        if (ending == 1){
            return formatEnding + " рубль";
        }
        else if (ending >=2 && ending <= 4){
            return formatEnding + " рубля";
        }
        else if (ending >= 5 && ending <= 20){
            return  formatEnding + " рублей";
        }
        else {
            return formatEnding + " рублей";
        }
    }
}


