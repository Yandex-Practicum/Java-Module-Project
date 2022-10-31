public class Calculator {
    static String listProduct = "";
    double priceProduct;
    static double sumPriceProduct = 0.00;
    static int payer;

    //количество человек на чек
    void addPeople(){
        System.out.println("На скольких человек необходимо разделить счёт?");
        payer = Main.scanner.nextInt();

        //проверка условий валидности плательщиков по чеку
        while (payer <= 1) {
            System.out.println("Количество человек меньше или равно одному.\nВведите число заново:");
            payer = Main.scanner.nextInt();
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
            System.out.println("Введите стоимость товара в руб.");
            priceProduct = Main.scanner.nextDouble();

                //проверяем отрицательную стоимость
                while (priceProduct < 0) {
                    System.out.println("У товара не может быть отрицательная стоимсть.\nВведите стоимость товара заново:");
                    priceProduct = Main.scanner.nextDouble();
                }

            //сохраняем список товаров с ценой в виде текста чтобы потом вывести список
            listProduct = listProduct + (product + (String.format(" - %.2f", priceProduct)) +" руб.\n");

            //суммируем стоимость товара
            sumPriceProduct = sumPriceProduct + priceProduct;

            System.out.println("Товар добавлен успешно.\nВведите новый товар или введите \"Завершить\", чтобы прекратить ввод товара.\n");
            }
        }

    //вывод чека
    void viewListProduct() {
        System.out.println("Добавленные товары:");
        System.out.println(listProduct);

        //выводим результаты рачсчёта счёта на каждого + склонение падежа для руб.
        double sum = Math.floor(Calculator.sumPriceProduct / Calculator.payer);
        //вычисляем количество символом у суммы и проверяем падеж
        String l = "" + sum;
        String rub;
            if (sum >= 10){
                rub = " рублей.";
            } else {
                int num = (int) (sum % l.length());
                if (num == 1) {
                    rub = " рубль.";
                } else if (num == 2 || num == 3 || num == 4) {
                    rub = " рубля.";
                }
                else {
                    rub = " рублей.";
                }
            }
        System.out.println(String.format("Общая сумма чека - %.2f", sumPriceProduct) + rub + "\n");
        System.out.println("Каждый должен заплатить - " + sum + rub);
    }
}


