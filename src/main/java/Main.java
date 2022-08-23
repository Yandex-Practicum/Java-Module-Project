import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

        int x;
        while (true) { //Цикл ввода количества персон, на которое делится счет
            System.out.println("На сколько человек нужно разделить счёт?\nВведите целым числом");
            Scanner scanner = new Scanner(System.in); // Ввод числа людей
            x = scanner.nextInt();// Запоминаем число
            System.out.println(x);//проверка 1 - вывод числа
            if (x < 1) {
                System.out.println("Круто, но платить некому\nВведите реальное количество людей"); // Проверка на 0 и отрицательность
            } else if (x == 1) {
                System.out.println("Придется оплачивать самостоятельно\nВведите реальное количество людей"); // Проверка на 1
            } else{
                break;
            }
            }
            Calculator calc = new Calculator();
            while (true) {
                System.out.println("Введите название товара или напишите \"завершить\"");
                Scanner scanner = new Scanner(System.in);// Ввод
                String pos = scanner.next();//Считывание названия товара
                if (pos.equalsIgnoreCase("завершить") == false) {// проверяем, что "не завершить"
                    calc.getTheName(pos);//Добавляем товар в наш перечень
                    System.out.println("товар добавлен");
                    while (true) {
                        System.out.println("введите стоимость товара в формате рубли.копейки [10.45, 11.40]");
                        double price;//Считывание цены товара
                        price = scanner.nextDouble();
                        if (price > 0) { //Проверяем, что число положительное
                            calc.addition(price);
                            break;
                        }
                        else {System.out.println("введено неправильное значение");}
                        // если отрицательное или 0, ввод ещё раз
                    }
                }
                else{
                 break;}// пользователь ввел "завершить"
            }
            calc.addedGoods();// Выводим перечень товаров
            calc.totalSum(x); // Вывод суммы, которую каждый должен заплатить

        }
    }

