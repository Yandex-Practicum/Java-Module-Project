import java.util.Scanner;

public class Calculator {


        static Scanner scanner = new Scanner(System.in);
        String userInput;
        static String productName;
        static String allProductsList;
        static float productCost = 0.0F;
        static float allProductsCost = 0.0F;

    public static void addingProducts() {
            String userInput = null;
            while (userInput.toUpperCase() != "ЗАВЕРШИТЬ"){
                System.out.println("Введите название товара и его стоимость.\nТовар: ");
                productName = scanner.next();
                allProductsList = allProductsList + " " + productName;
                System.out.println("Введите стоимость: ");
                productCost = scanner.nextFloat();
                allProductsCost = allProductsCost + productCost;

                System.out.println("Вы успешно добавили" + productName + "за" + productCost + "рублей.\nХотите добавить ещё один товар?");
                userInput = scanner.next();
            }
        }
    }

