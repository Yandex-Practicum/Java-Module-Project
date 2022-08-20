import static java.lang.Math.floor;

import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in).useLocale(Locale.ROOT);

    public void result(){

        double people = countPeople();
        double sumProducts = addProduct();
        double result = sumProducts/people;
        String currency;
        String currency2;

        switch ((int) (floor(sumProducts)%10)) {

            case 1:
                currency = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                currency = "рубля";
                break;
            default:
                currency = "рублей";
                break;
        }
        switch ((int) (floor(result)%10)) {

            case 1:
                currency2 = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                currency2 = "рубля";
                break;
            default:
                currency2 = "рублей";
                break;
        }
        String conclusion = "Cумма товаров %.2f %s\nНа одного человека %.2f %s";
        System.out.printf(conclusion,sumProducts,currency, result, currency2);
    }
    public int countPeople() {
        System.out.println("На скольких человек разделить счет?");
        int people;
        while (true) {
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
                if (people > 1) {
                    System.out.println("Количество человек " + people);
                    break;
                } else {
                    System.out.println("Это некорректное значение для подсчёта! Нет смысла делить счет, если вы только один. Введите корректное значение =)");
                }
            } else {
                System.out.println("У нас ошибка! Попробуй ввести цифру=)");
            }
            scanner.nextLine();
        }
        return people;
    }
    public double addProduct(){

        String product;
        String allProduct = "Добавленные товары:\n";
        double price;
        double sumPrice = 0;

        while (true){

            System.out.println("Введите товар или 'Завершить', чтобы выйти");
            product = scanner.next();
            if (product.equalsIgnoreCase("Завершить")){
                System.out.println(allProduct);
                break;

            }else {
                System.out.println("Вы успешно добавили товар " + product);
                allProduct += product + "\n";
                System.out.println("Введите стоймость товара в формате 'рубли.копейки'[10.45, 11.40]");
                while (true){
                    price = scanner.nextDouble();
                    if(price < 0){
                        System.out.println("Цена не может быть с минусом, введите заново!");
                    }else {
                        break;
                    }
                }

                sumPrice = sumPrice + price;

            }
        }
        return sumPrice;
    }
}

