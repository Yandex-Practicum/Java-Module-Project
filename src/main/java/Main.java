import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        int numberOfPersons;
        String productName;
        String listOfProducts;
        double productPrice;
        double finishPrice;

        Calculation calculator = new Calculation();

        Scanner scanner = new Scanner(System.in);

        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true){
            numberOfPersons = trueValue();
            if (numberOfPersons > 1){
                System.out.println("Значение принято");
                break;
            }else{
                System.out.println("Введено не коректное значение.\nКоличество человек должно быть введено цифрой и должно быть целым значением больше 1.");
                System.out.println("Попробуйте еще раз");
                System.out.println("На скольких человек необходимо разделить счёт?");
            }
        }

        while (true){
            System.out.println("Добавьте название продукта.");
            scanner.hasNextLine();
            productName = scanner.next();
            listOfProducts = calculator.calcName(productName);

            System.out.println("Добавьте стоимость продукта в формате 'рубли.копейки' [10.45, 11.40].");

            while (true){
                if (scanner.hasNextDouble()) {
                    productPrice = scanner.nextDouble();

                    if (productPrice > 0){
                        finishPrice = calculator.calcPrice(productPrice);
                        break;
                    } else {
                        System.out.println("Стоимость товара не может быть отрицательной или равна 0.");
                    }

                } else {
                    System.out.println("Ошибка ввода стоимости. Попробуйте ввести стоиомсть еще раз");
                    scanner.nextLine();
                }
            }
            System.out.println("Товар успешно добавлен.");
            System.out.println("Хотите добавить еще один продукт?");
            System.out.println("Для продолжения нажмите любой символ, для завершения введите: Завершить");
            String status = scanner.next();
            if (status.equalsIgnoreCase("Завершить")) {
                break;
            }
        }

        System.out.println (listOfProducts);
        System.out.println ("Общая стоимость вашего заказа: " + finishPrice + calculator.RubEnding(finishPrice));
        System.out.println ("Стоимость заказа на человека: " + String.format("%.2f",(finishPrice/numberOfPersons)) + calculator.RubEnding(finishPrice/numberOfPersons));

    }

    public static int trueValue(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int numberOfPersons = scanner.nextInt();
            return numberOfPersons;
        } else{
            return 0;
        }
    }


}