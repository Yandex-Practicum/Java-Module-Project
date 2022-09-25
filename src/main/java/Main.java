import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    private static int numberOfGuests;

    public static void main(String[] args) {
        Calculation calculation = new Calculation();

        getNumberOfGuests();
        System.out.println("Число гостей: " + numberOfGuests);

        while(true) {
            calculation.add(getNextProduct());
            System.out.println("Товар успешно добавлен\nДобавить еще один товар? (Введите любой символ если ДА, или \"Завершить\" если НЕТ)");

            if(scan.next().equalsIgnoreCase("завершить")){
                break;
            }
        }
        String messageTemplate = "Добавленные товары:\n\n%s\nИТОГО: %s \nКаждый гость должен по: %s";
        System.out.println(String.format(messageTemplate, calculation.allProducts, sumInRubles(calculation.totalPrice), sumInRubles(calculation.calculate(numberOfGuests))));

    }
    public static void getNumberOfGuests(){

        while (true) {
            System.out.println("На сколько человек необходимо разделить счет?");
            if (scan.hasNextInt()) {
                numberOfGuests = scan.nextInt();
                if (numberOfGuests > 1){
                    break;
                } else {
                    System.out.println("Не верный ввод");
                    scan.nextLine();
                }
            } else {
                System.out.println("Не верный ввод");
                scan.nextLine();
            }
        }
    }

    public static Product getNextProduct() {
        Product product = new Product();
        System.out.println("Введите наименование товара");
        scan.nextLine();
        product.getNameOfProduct(scan.nextLine());

        while (true) {
            System.out.println("Введите стоимость товара в формате: \"рубли,копейки\". Пример: 10,45");
            if (scan.hasNextDouble()) {
                product.getPriceOfProduct(scan.nextDouble());
                if (product.addPriceOfProduct() > 0){
                    break;
                } else {
                    System.out.println("Не верный ввод");
                    scan.nextLine();
                }
            } else {
                System.out.println("Не верный ввод");
                scan.nextLine();
            }
        }
        return product;
    }

    public static String sumInRubles(double price) {
        double floor = Math.floor(price);
        int sum = (int) floor % 10;
        if ((floor > 5 && floor <= 20) || sum == 0 || sum > 4) {
            return String.format("%.2f рублей", price);
        } else if (sum == 1) {
            return String.format("%.2f рубль", price);
        } else {
            return String.format("%.2f рубля", price);
        }
    }
}
