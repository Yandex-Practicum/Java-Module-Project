import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    private List<String> goodsList = new ArrayList<>();
    private float total = 0;
    private int personQuantity = 0;
    Calculator(){

    }

    public void enterProductAndPrice(){
        String userChoice = "";
        while (!userChoice.equalsIgnoreCase("завершить")) {
            enterProductName();
            enterProductPrice();
            System.out.println("Добавить ещё один товар?");
            userChoice = scanner.nextLine();
        }
    }
    public void enterProductName(){
        String productName = "";
        while (productName.isEmpty()) {
            System.out.println("Введите название товара: ");
            productName = scanner.nextLine();
            goodsList.add(productName);
        }
    }

    public void enterProductPrice(){
        float productPrice = -1;
        while (productPrice < 0){
            System.out.println("Введите стоимость товара. Стоимость товара должна быть неотрицательным числом:");
            try {
                productPrice = scanner.nextFloat();
                if (productPrice < 0) continue;
                total += productPrice;
            }
            catch(InputMismatchException e){
                System.out.println("Неверный формат числа. Попробуйте снова.");
            }
            scanner.nextLine();
        }
    }

    public void showResults(){
        System.out.println("Добавленные товары:");
        for (String s : goodsList) {
            System.out.println(s);
        }
        String declination = checkDeclension();
        String format = String.format("Каждый человек должен заплатить %.2f %s", total/personQuantity, declination);
        System.out.println(format);
    }

    private String checkDeclension(){
        int integer = (int) Math.floor(total/personQuantity);
        if (integer == 1) return "рубль";
        else if (integer > 1 && integer < 5) return "рубля";
        else return "рублей";
    }

    public void howManyUsers() {
        personQuantity = enterQuantity();
        while (personQuantity <= 1) {
            System.out.println("Введено некорректное количество человек (меньше или равно 1). Повторите, пожалуйста ввод.");
            personQuantity = enterQuantity();
        }
    }
    private int enterQuantity(){
        try {
            System.out.println("На сколько человек необходимо разделить счёт?");
            personQuantity = scanner.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Неверный формат числа. Попробуйте снова.");
            scanner.nextLine();
        }
        scanner.nextLine();
        return personQuantity;
    }
}
