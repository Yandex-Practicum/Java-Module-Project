import java.util.Scanner;

public class Calculate {

    private static final Scanner scanner = new Scanner(System.in);

    int count;
    String allProducts = "";
    double totalPrice = 0.00f;
    double productPrice;
    String rubles = "";


    public void initDataPersons() {
        System.out.println("Здравствуйте!\nНа скольких гостей разделить счет?");

        while (true) {
            count = scanner.nextInt();
            if (count > 1) {
                break;
            }
            if (count == 1) {
                System.out.println("Разделение счета рассчитывается на большее кол-во гостей. Пожалуйста, введите число заново.");
            } else {
                System.out.println("Неверное кол-во гостей. Пожалуйста, введите число заново.");
            }
        }

    }

    // Добавление товаров в калькулятор

    public void addingProducts() {
            while (true) {
            System.out.println("Введите название товара или введите команду \"Завершить\".");
            try {
                String productName = scanner.next();
                if (productName.equalsIgnoreCase("finish")) {
                    System.out.println("Добавленные товары: " + "\n" + allProducts);
                    break;
                } else {
                    allProducts = allProducts + productName + "\n";
                    while (true) {
                        System.out.println("Введите стоимость товара в формате \"рубли,копейки\".");
                        productPrice = scanner.nextDouble();
                        if (productPrice <= 0) {
                            System.out.println("Некорректное значение.");
                        } else {
                            break;
                        }
                    }
                    this.totalPrice = totalPrice + productPrice;
                    System.out.println("Товар добавлен в чек.");
                }
            }
            catch(Exception e){
                System.out.println("Некорректное название товара. Попробуйте снова.");
            }
        }

    }



    //Подсчет рублей для каждого гостя

    public void endingOfRubles() {
        int lastNum = (int) totalPrice % 10;

        if (totalPrice % 100 >= 11 && totalPrice % 100  <= 20) {
            rubles =  "рублей rublei";
        } else if (lastNum > 1 && lastNum  < 5) {
            rubles = "рубля rublya";
        } else if (totalPrice % 10  == 1) {
            rubles = "рубль rubl";
        }
        else {
            rubles = "рублей rublei";
        }

        double OnePersonSum = totalPrice / (double)count;
        System.out.println("Сумма на каждого гостя составляет " + String.format("%.2f", OnePersonSum) + " " + rubles + ".\nВсего доброго!");

    }

}