import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        Scanner scanner = new Scanner(System.in);

        int guests = 0; //количество человек
        System.out.print("Введите количество гостей (2+): ");

        while (guests < 2) {

            if (scanner.hasNextInt()) { // это условие сработает, если в консоль введены цифры
                guests = Integer.parseInt(scanner.nextLine());

                if (guests < 2) {
                    System.out.print("Ввод не соответствует требованиям.\n\nПовторите ввод: ");
                }
            } else { // это условие сработает, если в консоль введен текст или символы
                System.out.print("Ввод не соответствует требованиям.\n\nПовторите ввод: ");
                scanner.nextLine();
            }
        }

        Products product = new Products("", "", 0, 0); // класс продукта

        String exitName = "Завершить"; // переменная необходимая для выхода из цикла


        while (true) {


            System.out.print("Введите название товара: ");

            product.name = scanner.nextLine().trim(); // название товара с удалением пробелов

            if (exitName.equalsIgnoreCase(product.name)) { // это условие сработает, если в консоль ввести "завершить" в любом регистре
                break;
            }
            product.finalProductList(product.name); // метод, который формирует список товаров

            System.out.print("Введите стоймость товара: ");

            while (product.price <= 0) {

                if (scanner.hasNextDouble()) { // это условие сработает, если в консоль введены цифры
                    product.price = Double.parseDouble(scanner.nextLine());

                    if (product.price <= 0) {
                        System.out.print("Ввод не соответствует требованиям.\n\nПовторите ввод: ");
                    }
                } else { // это условие сработает, если в консоль введен текст или символы
                    System.out.print("Ввод не соответствует требованиям.\n\nПовторите ввод: ");
                    scanner.nextLine();
                }
            }

            product.finalPrice(product.price); //метод, который формирует общую стоймость товаров
            System.out.println("Товар: " + product.name + " на сумму: " + product.price + " - успешно добавлен в счет.\n");
        }


        System.out.println("\nДобавленные товары:\n" + product.finalList);

        System.out.println("На общую сумму: " + product.finalPrice + " руб.");


        double check = product.finalPrice / guests;// переменная суммы счета
        double finalCheck = Math.floor(check); // переменная суммы счета с методом округления дробной части


        String finalMessage = "\nКаждому гостю необходимо заплатить: %.2f %s";

        System.out.println(String.format(finalMessage, finalCheck, currency(finalCheck)));

    }
    public static String currency(double finalCheck) { //метод выбора окончания


        double preLastDigit = (finalCheck % 100) / 10; // переменная предпоследнего числа

        if (Math.floor(preLastDigit) == 1) {
            return "Рублей";
        }

        double lastDigit = finalCheck % 10; // переменная последнего числа
         if (lastDigit == 1) {
        return "Рубль";
    }
         else if (lastDigit == 2 || lastDigit == 3 || lastDigit == 4) {
            return "Рубля";
        }
         else {
            return "Рублей";
        }
    }
    }



