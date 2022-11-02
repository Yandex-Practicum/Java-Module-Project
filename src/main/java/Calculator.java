public class Calculator {
    static String listProduct = "";
    double priceProduct;
    static double sumPriceProduct = 0.00;
    static int payer;

    //количество человек на чек (первый способ проверки ввода символов)
    void addPeople(){
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true) {
            try {
                payer = Main.scanner.nextInt();
                if (payer <= 1) {
                    System.out.println("Количество человек меньше или равно одному.\nВведите число заново:");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Вы ввели символ, а не число.\nПопробуйте ещё раз ввести количество человек");
                Main.scanner.next();
            }
        }
    }

    //количество человек на чек (второй способ проверки ввода символов)
    void addPeople2(){
        System.out.println("На скольких человек необходимо разделить счёт?");

        while (true) {
            //вначале проверим число ли ввели вовсе
            if (Main.scanner.hasNextInt()) {
                payer = Main.scanner.nextInt();
                if (payer <= 1) {
                    System.out.println("Количество человек меньше или равно одному.\nВведите число заново:");
                    break;
                }
            } else {
                System.out.println("Вы ввели символ, а не число.\nПопробуйте ещё раз ввести количество человек");
                Main.scanner.next();
            }
        }
    }


    //ввод товара
    void addProduct() {
        while (true) {
            System.out.println("Наименование товара");
            String product = Main.scanner.next();

            //проверка на завершение цикла добавление товара
            if (product.equalsIgnoreCase("Завершить")) {
                break;
            }

            //вводим стоимость товара
            System.out.println("Введите стоимость товара в руб.");

            //вначале проверим число ли ввели вовсе
            if (Main.scanner.hasNextDouble()) {
                priceProduct = Main.scanner.nextDouble();

                //проверяем отрицательную стоимость
                while (priceProduct < 0) {
                    System.out.println("У товара не может быть отрицательная стоимсть.\nВведите стоимость товара заново:");
                    priceProduct = Main.scanner.nextDouble();
                }

                //сохраняем список товаров с ценой в виде текста чтобы потом вывести список
                listProduct = listProduct + (product + (String.format(" - %.2f", priceProduct)) + " руб.\n");

                //суммируем стоимость товара
                sumPriceProduct = sumPriceProduct + priceProduct;

                System.out.println("Товар добавлен успешно.\nВведите новый товар или введите \"Завершить\", чтобы прекратить ввод товара.\n");
            } else {
                System.out.println("Некорректный ввод числа.\nПопробуйте ещё раз.\n");
                Main.scanner.next();
            }
        }
    }

    //вывод чека
    void viewListProduct() {
        System.out.println("Добавленные товары:");
        System.out.println(listProduct);
        System.out.println(String.format("Общая сумма чека - %.2f", sumPriceProduct) + GetRubleAddition() + "\n");
        //выводим результаты рачсчёта счёта на каждого
        System.out.println("Каждый должен заплатить - " + Math.floor(Calculator.sumPriceProduct / Calculator.payer) + GetRubleAddition());
    }

    //метод определения склонения падежа
    public static String GetRubleAddition() {
        double amountForEach = Math.floor(Calculator.sumPriceProduct / Calculator.payer);
        //с 10 по 19 всегда "рублей"
        if (amountForEach % 100 >= 10 || amountForEach % 100 < 20) {
                return " рублей";
        }
        //остальные склонения по последней цифре
        switch ((int) (amountForEach % 10)) {
            case 1:
                return " рубль";
            case 2:
            case 3:
            case 4:
                return " рубля";
            default:
                return " рублей";
        }
    }
}


