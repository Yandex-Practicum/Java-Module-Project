import java.util.Scanner;

public class Calculator {

        static Scanner scanner = new Scanner(System.in);
        static String userInput = null;
        static String productName;
        static String allProductsList = "Добавленные товары:";
        static float productCost = 0.0F;
        static float allProductsCost = 0.0F;
        static String checkedNumber = null;

        static void printResult(int numberOfGuests) {
            while (!"ЗАВЕРШИТЬ".equalsIgnoreCase(userInput)){
                System.out.println("Введите название товара и его стоимость.\nТовар: ");
                productName = scanner.next();
                allProductsList = allProductsList + "\n" + productName;
                System.out.println("Введите стоимость: ");
                checkedNumber = scanner.next();

                while (true){
                    if (!isItaNumber(checkedNumber)){
                        System.out.println("Бип, ошибка. Это не число, либо вы в качестве делителя используете запятую вместо точки.\nПопробуйте ещё раз. Введите стоимость: ");
                        checkedNumber = scanner.next();
                    }else if (!isItPositive(productCost = Float.parseFloat(checkedNumber))){
                        System.out.println("Бип, ошибка. Стоимость не может быть отрицательной!\nПопробуйте ещё раз. Введите стоимость: ");
                        checkedNumber = scanner.next();
                    }else{

                        break;
                    }
                }

                allProductsCost += productCost;
                System.out.println("Вы успешно добавили " + productName + " за " + productCost + " рублей.\nЕсли хотите завершить, наберите \"Завершить\" и нажмите \"enter\".\nЕсли хотите добавить ещё один товар, введите любой символ или слово и нажмите \"enter\".");
                userInput = scanner.next();
            }
            System.out.println(allProductsList + "\nОбщая сумма: " + allProductsCost+ " рублей.");

        }

        private static boolean isItPositive(float productCost) {
            if (productCost>=0) {
                return true;
            }else{
                return false;
            }
        }

        private static boolean isItaNumber(String checkedNumber) {

            return checkedNumber.matches("-?\\d+(\\.\\d+)?");
        }

}
