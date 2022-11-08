import java.util.Scanner;

public class Products {


    String Name;//объявляем статическую переменную списка позиций для передачи в класс Main
    Double Price;
    static int count = 1;
    static String name1;
    static Double total=00.00;
    static Boolean finishOfList=true;

    //конструктор
    public Products(String Name, double Price) {
        this.Name = Name;
        this.Price = Price;

    }
    //метод составления списка товаров
    public static String inputOfProducts() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите наименование Товара:");
        String name1 = scanner.next();
        System.out.println("Укажите стоимость Товара в формате 'рубли.копейки' (пример:10.45 или 11.40):");
        String price1 = scanner.next();
        //преобразуем строковую переменную price1 в формат Double
        Double j=Double.parseDouble(price1);
        //записываем в  name1 наименование и цену товара
        name1=String.format( "Поз."+count+": "+name1+" "+ "%.2f"+" руб.",j);
        System.out.println("Товар добавлен в список "+ name1);
        count++;//количество позиций в списке
        total=total+j;//вычисляем общую стоимость всех введенных товаров
        return name1;//на выходе в name1 добавленный товар и его цена
    }

    //метод проверки выхода из процесса составления списка товаров
    public static Boolean exitOfList() {

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
        return finishOfList;
    }



}