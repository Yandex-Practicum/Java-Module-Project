import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    static double total;
    int persons;
    public void qPerson() {
        int qPerson =1;
    System.out.println("На сколько человек необходимо разделить счет?");
    Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод! Введите целое число больше единицы");
                scanner.next();
                continue;
            } else {
                qPerson = scanner.nextInt();
            }
            if (qPerson > 1) {
                break;
            } else {
                System.out.println("Нет смысла делить счет меньше чем на двух человек!");
            }
        }
        persons = qPerson;
        }

    public void addProducts() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        Double price;
        while (true) {
            System.out.println("Введите название товара или напишите 'завершить'");
            String product = scanner.next();
            if (product.equalsIgnoreCase("завершить")) {
                break;
            } else {
                System.out.println("Введите цену товара в формате 'рубли,копейки'");
                while (true) {
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Некорректный ввод! Введите цену товара в формате 'рубли,копейки'");
                        scanner.next();
                        continue;
                    } else {
                        price = scanner.nextDouble();
                    }
                    if (price > 0) {
                        break;
                    } else {
                        while (price<0){
                        System.out.println("Любой каприз за ваши деньги , но не за счет заведения!"+"\n"+"Цена товара должна быть больше 0! Веедите цену товарав формате 'рубли,копейки'");
                        scanner.next();
                        continue;}
                    }
                }
                products.add(product);
                total += price;
                System.out.println("Товар " + product + " успешно добавлен по цене " + String.format("%.2f", price));
            }
        }

        System.out.println("Добавленные товары:" + "\n" + String.join("\n", products));
        System.out.println("Каждый человек должен заплатить: "+String.format("%.2f",total/persons) +" "+ endOfWord(total/persons));
    }

    public String endOfWord(double a){
        int tseloeA=(int)Math.floor(a);
        if (tseloeA % 100 >5 && tseloeA % 100<=20){return "рублей";}
        else if (tseloeA % 10==1){ return "рубль";}
        else if (tseloeA % 10>1 && tseloeA % 10<5){return "рубля";}
        return "рублей";
        }

}





