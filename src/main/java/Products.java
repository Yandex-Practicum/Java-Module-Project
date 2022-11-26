import java.util.Scanner;

public class Products {


    String name;// объявляем статическую переменную списка позиций для передачи в класс Main
    Double price;
    static int count = 1;
    static String nameOfgoods;
    static Double total=00.00;
    static Boolean finishOfList=true;

    //конструктор
    public Products(String name, double price) {
        this.name = name;
        this.price = price;

    }
    //метод составления списка товаров
    public static String inputOfProducts() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите наименование Товара:");
        String nameOfgoods = scanner.next();
        System.out.println("Укажите стоимость Товара в формате 'рубли.копейки' (пример:10.45 или 11.40):");
        String priceOfgood = scanner.next();
        //преобразуем строковую переменную priceOfgood в формат Double
        Double j=Double.parseDouble(priceOfgood);
        //записываем в  nameOfgoods наименование и цену товара
        nameOfgoods=String.format( "Поз."+count+": "+nameOfgoods+" "+ "%.2f"+" руб.",j);
        System.out.println("Товар добавлен в список "+ nameOfgoods);
        count++;//количество позиций в списке
        total+=j;//вычисляем общую стоимость всех введенных товаров
        return nameOfgoods;//на выходе в name добавленный товар и его цена
    }

    //метод проверки выхода из процесса составления списка товаров

        public static void exitOfList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите добавить что нибудь ещё?"+" Если да, введите любой символ или слово :");
        System.out.println("Если добавить нечего введите 'завершить':");
        String add = scanner.next();
        if(add.equalsIgnoreCase("завершить")) {
            finishOfList=false;
            //break;

        }  else{
            finishOfList=true;
        }
        return;
    }



}