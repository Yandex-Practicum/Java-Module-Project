import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int quantityPeople = 0;

    public static void main(String[] args) {

        System.out.println("Здравствуйте! Введите количество человек для разделения счета.");
        checkQuantityPeople();
        System.out.println("Введите название и стомость товара.");
        Calculator calculator = new Calculator();
        addProduct(calculator);
        calculator.returnNameProduct();
        calculator.returnDebtForOne(quantityPeople);
    }

    //Чтение и сохранение количества гостей
    static void checkQuantityPeople(){
        while (true) {
            //Проверка ввода пользователя на пустое значение или не целое число до его чтения
            if (scanner.hasNext() && scanner.hasNextInt())
            {
                quantityPeople = scanner.nextInt();
            // Проверка введенного пользователем целого числа
                if (quantityPeople <= 1){
                    System.out.println("Некорректный ввод.\n" +
                            "Введите количество человек больше 1.");
                }
                else {
                    break;
                }
            }
            else{
                System.out.println("Некорректиный ввод.\n" +
                        "Введите количество человек целым положительным числом.");
                scanner.next();
            }
        }
    }

    //Чтение данных о товаре, введенных пользователем
    static Product readProduct(){
        Product product = new Product();
        scanner.nextLine();
        product.nameProduct = chekNameProduct();
        product.price = chekPrice();
        return product;
    }

    //Сохранение данных о товаре, введенных пользователем
    static void addProduct(Calculator calculator){
        do {
            calculator.addProduct(readProduct());
            System.out.println("Хотите еще добавить товар?\n" +
                    "Для завершения введите 'Завершить'.\n" +
                    "Для продолжения введите любой символ.");
        } while (!scanner.next().equalsIgnoreCase("Завершить"));
    }

    //Чтение и сохранение стоимости товара
    static double chekPrice(){
        double price;

        System.out.println("Цена:");
        while (true){
            if (scanner.hasNext() && scanner.hasNextDouble()){
                price = scanner.nextDouble();
                if (price < 0){
                    System.out.println("Некорректный ввод.\n" +
                            "Введите положительное число в формате 'рубли,копейки'.");
                }
                else break;
            }
            else {
                System.out.println("Некорректный ввод. Введите стоимость товара в формате 'рубли,копейки'\n" +
                        "Цена:");
                scanner.next();
            }
        }
        return price;
    }

    //Чтение и сохранение наименования товара
    static String chekNameProduct(){
        String nameProduct;

        System.out.println("Название товара:");
        //Проверка на пустой ввод названия товара
        while (true){
            if (scanner.hasNext()){
                nameProduct = scanner.nextLine();
                break;
            }
            else {
                System.out.println("Некорректный ввод. Введите название товара.\n" +
                        "Название товара:");
                scanner.next();
            }
        }
        return nameProduct;
    }
}