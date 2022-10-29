import java.util.Scanner;

public class ProductsList {
    static String products; //атрибуты
    static float amount;
    static String answer;

    ProductsList productsList = new ProductsList();


    public static void main(String[] args) {


    }

    public static void productsLists() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название товара: ");
            products = scanner.next();
            System.out.println("Введите цену товара: ");
            amount = scanner.nextFloat(); //мб тут нужен будет try catch

            System.out.println("Товар успешно добавлен!\nХотите добавить ещё товар?");
            answer = scanner.next();
            switch (answer){
                case "Да":
                    productsLists();

                case "Завершить":
                    break;
            }
        }
    }
}
