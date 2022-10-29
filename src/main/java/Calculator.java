import java.util.Scanner;

public class Calculator {

        static Scanner scanner = new Scanner(System.in);
        static String userInput = null;
        static String productName;
        static String allProductsList = "Добавленные товары:";
        static float productCost = 0.0F;
        static float allProductsCost = 0.0F;
        static float personalAmount = 0.0F;
        static String checkedNumber = null;

        static void printResult(int numberOfGuests) {
            while (!"ЗАВЕРШИТЬ".equalsIgnoreCase(userInput)){
                System.out.println("Введите название товара и его цену.\nТовар: ");
                productName = scanner.next();
                allProductsList = allProductsList + "\n" + productName;
                System.out.println("Введите стоимость: ");
                checkedNumber = scanner.next();

                while (true){
                    if (!isItaNumber(checkedNumber)){
                        System.out.println("Бип, ошибка. Это не число, либо вы в качестве делителя используете запятую вместо точки.\nПопробуйте ещё раз. Введите цену: ");
                        checkedNumber = scanner.next();
                    }else if (!isItPositive(productCost = Float.parseFloat(checkedNumber))){
                        System.out.println("Бип, ошибка. Цена не может быть отрицательной!\nПопробуйте ещё раз. Введите цену: ");
                        checkedNumber = scanner.next();
                    }else{

                        break;
                    }
                }

                allProductsCost += productCost;
                System.out.println("Вы успешно добавили " + productName + " за " + String.format("%.2f", productCost) + " рублей.\nЕсли хотите завершить, наберите \"Завершить\" и нажмите \"enter\".\nЕсли хотите добавить ещё один товар, введите любой символ или слово и нажмите \"enter\".");
                userInput = scanner.next();
            }
            String rubleEnding = getRubleEnding((int) Math.floor(allProductsCost));
            System.out.println(allProductsList + "\nОбщая сумма: " + String.format("%.2f",allProductsCost) + rubleEnding);
            personalAmount = allProductsCost / numberOfGuests;
            String personalRubleEnding = getRubleEnding((int) Math.floor(personalAmount));
            System.out.println("Каждому гостю необходимо заплатить: " + String.format("%.2f", personalAmount) + personalRubleEnding);

        }


        private static boolean isItPositive(float productCost) {// проверяем не является ли число отрицательным
            return productCost >= 0;
        }

        private static boolean isItaNumber(String checkedNumber) {// проверяем число ли ввёл пользователь

            return checkedNumber.matches("-?\\d+(\\.\\d+)?");
        }
    public static String getRubleEnding(int wholeRubles) {
        int preLastDigit = wholeRubles % 100 / 10;
        if (preLastDigit == 1) {
            return " рублей.";
        } else {

            switch (wholeRubles % 10) {
                case 1:
                    return " рубль.";
                case 2:
                case 3:
                case 4:
                    return " рубля.";
                default:
                    return  " рублей.";
            }
    }
}
}
