import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

        int friendsNumber;
        while (true) { //Цикл ввода количества персон, на которое делится счет
            System.out.println("На сколько человек нужно разделить счёт?\nВведите целым числом");
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US); // Ввод числа людей
            if (scanner.hasNextInt()) {
                friendsNumber = scanner.nextInt();// Запоминаем число

                //System.out.println(friendsNumber);//проверка 1 - вывод числа
                if (friendsNumber < 1) {
                    System.out.println("Круто, но платить некому\nВведите реальное количество людей"); // Проверка на 0 и отрицательность
                } else if (friendsNumber == 1) {
                    System.out.println("Придется оплачивать самостоятельно\nВведите реальное количество людей"); // Проверка на 1
                } else {
                    break;
                }
            } else {
                System.out.println("Неправильный ввод");
            }
        }
        Calculator calc = new Calculator();
        while (true) {
            System.out.println("Введите название товара или напишите \"завершить\"");
            Scanner scanner = new Scanner(System.in);// Ввод
            String pos = scanner.next();//Считывание названия товара
            if (!pos.equalsIgnoreCase("завершить")) {// проверяем, что "не завершить"
                calc.getTheName(pos);//Добавляем товар в наш перечень
                System.out.println("товар добавлен");
                while (true) {
                    System.out.println("введите стоимость товара в формате рубли.копейки [10.45, 11.40]");
                    double price;//Считывание цены товара
                    Scanner scanner1 = new Scanner(System.in).useLocale(Locale.US);// Ввод
                    if (scanner1.hasNextDouble()) {
                        price = scanner1.nextDouble();
                        if (price > 0) { //Проверяем, что число положительное
                            calc.addition(price);
                            break;
                        } else {
                            System.out.println("введено неправильное значение");
                        }
                        // если отрицательное или 0, ввод ещё раз
                    }
                    System.out.println("Неправильный ввод");
                }
            } else {
                break;
            }// пользователь ввел "завершить"
        }
        calc.addedGoods();// Выводим перечень товаров
        calc.totalSum(friendsNumber); // Вывод суммы, которую каждый должен заплатить

    }
}

