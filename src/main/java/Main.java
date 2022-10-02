import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    private static String nounForm(double num)
    {
        String numStr = Double.toString(num);
        numStr = numStr.substring(0, numStr.indexOf("."));
        if (num > 10) {
            for (int i = 11; i < 15; i++) {
                if (i == Integer.parseInt(numStr.substring(numStr.length() - 2))) {
                    return "рублей";
                }
            }
        }
        switch (numStr.charAt(numStr.length() - 1))
        {
            case '0':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return "рублей";
            case '1':
                return "рубль";
            case '2':
            case '3':
            case '4':
                return "рубля";
            default:
                return "ERROR";
        }
    }

    private static int askNumOfPeople()
    {
        Scanner sc = new Scanner(System.in);
        int numOfPeople = 0;
        System.out.println("На какое количство людей поделить чек?");
        while (numOfPeople <= 1) {
            while (true) {
                try {
                    numOfPeople = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.err.println("Невозможное значение. Введите натуральное число:");
                    sc.nextLine();
                }

            }
            if (numOfPeople < 1) {
                System.out.println("Значение меньше единицы. Введите натуральное число:");
            } else if (numOfPeople == 1) {
                System.out.println("Не имеет смысла считать");
            }
        }
        return numOfPeople;

    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        Scanner sc = new Scanner(System.in);

        int numOfPeople = askNumOfPeople();
        System.out.println("Теперь давайте выберем товары!");

        while(true)
        {
            String prodName = null;
            System.out.println("Введите название товара или 'завершить':");
            prodName = sc.nextLine();
            if (prodName.equalsIgnoreCase("завершить"))
            {
                System.out.println("Все товары добавлены!\n");
                break;
            }
            System.out.println("Введите стоимость товара:");
            double price = 0;
            while(true)
            {
                try{
                    price = sc.nextDouble();
                    if (price > 0){
                        break;
                    }
                    else{
                        System.err.println("Невозможное значение. Введите значение больше нуля:");
                    }
                } catch (Exception e){
                    System.err.println("Невозможное значение. Введите коректное значение (дробные значения пишите с запятой):");
                    sc.nextLine();
                }

            }
            sc.nextLine();
            calc.riseAmount(price);
            calc.addProduct(prodName);
            System.out.println("Товар добавлен!\n");
        }

        System.out.println(calc._listOfProducts);
        System.out.println(String.format("\nС каждого человека по %.2f %s", calc._amount / numOfPeople, nounForm(calc._amount / numOfPeople)));
    }
}
