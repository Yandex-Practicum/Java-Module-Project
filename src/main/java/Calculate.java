
import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {
    static Const aConst=new Const();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> product = new ArrayList<>();
    static ArrayList<Double> price = new ArrayList<>();
    static double score = 0;

    public static void calculate() {
        int count;
        while (true){
            while (true)//проверка ввода целого числа
            {
                System.out.println("На сколько человек разделить заказ?");
                System.out.println("Введите целое больше 1");
                if (scanner.hasNextInt())
                {
                    count = Integer.parseInt(scanner.nextLine());
                    System.out.println("Вы ввели: " + count);
                    break;
                }
                else
                {
                    System.out.println("Вы ввели не целое число");
                    scanner.nextLine();
                }}
            if (count<=1) {
                System.out.println("Оглянись! Ты тут один наел на 15 тысяч");
            } else {
                //блок заполнения листа и подсчета счета
                System.out.println(aConst.ADD_PRODUCT_AND_PRICE);
                String nameProduct = scanner.next();//название продукта
                Double priceProduct = scanner.nextDouble();//цена
                addProduct(nameProduct);
                addPrice(priceProduct);
                System.out.println(aConst.ADD_MESSAGE_PRODUCT);
                while (true) {
                    System.out.println(aConst.QUESTION_MESSAGE);
                    String question = scanner.next();
                    if (question.equalsIgnoreCase("Да")) {
                        System.out.println(aConst.ADD_PRODUCT_AND_PRICE);
                        String addNameProduct = scanner.next();
                        double addPriceProduct = scanner.nextDouble();
                        addProduct(addNameProduct);
                        addPrice(addPriceProduct);
                        System.out.println(aConst.ADD_MESSAGE_PRODUCT);
                    } else if (question.equalsIgnoreCase("Завершить")) {
                        printProductAndPrice();
                        score = score / count;
                        printResult(score);
                        break;
                    }
                }
                break;
            }
        }


    }

    private static void addProduct(String addProduct) {
        product.add(addProduct);
    }
    private static void addPrice(Double addPrice) {
        price.add(addPrice);
    }

    //ввывод товаров и стоимость каждого продукта
    private static void printProductAndPrice() {
        System.out.println("Добавленные товары:");
        for (double price : price) {
            score = score + Math.abs(price);
        }
        for (int i=0;i<product.size();i++){
            System.out.println("Продукт: "+ product.get(i)+ " стоимость: "+ Math.abs(price.get(i)));
        }
    }

    //метод для вывода окончания рубля
    private static void printResult(double score1) {
        if ( Math.floor(score1) % 100 >= 11 &&  Math.floor(score1) % 100 <= 19) {
            System.out.printf("Каждый должен заплатить: %.2f Рублей%n",score1);
        } else {
            switch ((int) (Math.floor(score1) % 10)) {
                case 1:
                    System.out.printf("Каждый должен заплатить: %.2f Рубль%n",score1);
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.printf("Каждый должен заплатить: %.2f Рубля%n",score1);
                    break;
                default:
                    System.out.printf("Каждый должен заплатить: %.2f Рублей%n",score1);
                    break;
            }
        }
    }
}

