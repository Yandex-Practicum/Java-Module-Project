import java.util.Locale;
import java.util.Scanner;

public class Product {
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    static int numberOfPeople;

    // подсчет количество человек
    public void calculatePersons() {
        System.out.println("На скольких гостей необходимо разделить счёт ?");
        //количество человек
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("Ошибка. Введите 'ЧИСЛО' гостей !");
                sc.next();
                continue;
            }
            numberOfPeople = sc.nextInt();
            if (numberOfPeople <= 1) {
                System.out.println("Ошибка. Введите корректное 'ЧИСЛО' !");
            } else {
                System.out.println("Поздравляем вам есть с кем разделить счет !");
                break;
            }
        }
    }

    // добавление товара и его стоимости в калькулятор
    public void addProduct(Calculator calculator) {
        System.out.println("Введите название товара:");
        String product = sc.next();


        System.out.println("Введите стоимость товара: 'рубли.копейки' [10.45, 11.40] ");

       String addOne = "";
        while (true) {
            if (!sc.hasNextDouble()) {
                System.out.println("Ошибка. Товар не добавлен. Введите корректное значение стоимости товара. ");
                sc.next();
                continue;
            }
            double price = sc.nextDouble();
            if (price <= 0) {
                System.out.println("Ошибка.Введите положительное значение. ");
                calculator.setProducts(product);
            }
            if (price >= 0) {


                calculator.setTotalPrice(price);

                System.out.println("Товар успешно добавлен.\nДобавить ещё один товар? нажмите - 'Y'\nЕсли все товары добавлены нажмите  - 'N' ! ");
                while (true) {
                    addOne = sc.next();

                    if (addOne.equalsIgnoreCase("Y")) {
                        addProduct(calculator);




                    } if (addOne.equalsIgnoreCase("N")) {
                        outputResult(calculator);
                    }
                          else {
                        System.out.println("Ошибка. Введите корректное количество гостей!");
                        continue;
                    }

                }
            }
        }
    }

        // вывод результатов
        public void outputResult (Calculator calculator){

            System.out.print("Добавленные товары:");
            // вывод товаров
            System.out.println(calculator.getProducts());
            System.out.println("Общий счет: " + calculator.getTotalPrice() + " разделим его на " +numberOfPeople + " гостей. ");
            // счет каждого посетителя

            // склонение в зависимости от целочисленной части счета
            double scoreVisitor = calculator.getTotalPrice() / numberOfPeople;

            String currency = "";
            // округление значения


            int roundScore = (int) Math.floor(scoreVisitor);
            if (roundScore == 1 || (roundScore % 10 == 1 && (roundScore / 10) % 2 == 0)) {
                currency = "рубль";
            } else if ((roundScore > 1 && roundScore <= 4) || ((roundScore % 10 > 1 && roundScore % 10 <= 4) && (roundScore / 10) % 2 == 0)) {
                currency = "рубля";
            } else if (roundScore > 4) {
                currency = "рублей";
            }
            // вывод счета клиента


            String formatAnswer = String.format("%.2f %s", scoreVisitor, currency);
            System.out.println("Сумма к оплате каждого гостя : " + formatAnswer);

        }
    }













