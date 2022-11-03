import java.util.Scanner;
public class Calculate {
    int guest;
    String totalName = "";
    double totalPrice = 0.00f;
    String rub = "";
    Scanner scanner = new Scanner(System.in);


    public void addGuests() {
        while (true) {
            System.out.println("Введите количество человек в вашей компании:");
            if (scanner.hasNextInt()) {
                guest = scanner.nextInt();
                if (guest > 1) {
                    System.out.println("Спасибо! Разделим счёт на " + guest + " человек(а)\nПриступим к заполнению заказа.");
                    break;//
                } else {
                    System.out.println("Некорректное значение гостей, попробуйте снова!");
                }
            } else {
                System.out.println("Ожидается ввод числового значения, попробуйте снова!");
                scanner.nextLine();
            }
        }
    }
    public void sumProducts() {
        while (true) {
            System.out.println("Введите название товара:");
            String name = scanner.next();
            String cancel = "Завершить";
            boolean check = cancel.equalsIgnoreCase(name);
            if (check) {
                System.out.println("Ваш заказ: " + "\n" + totalName);
                System.out.println("На общую стоимость: " +  totalPrice + " руб.");
                break;
            } else {
                totalName = totalName + name + "\n";
                System.out.println("Введите стоимость товара (рубли,копейки):");
                while (true) {
                    if (scanner.hasNextDouble()) {
                        double price = scanner.nextDouble();
                        if (price > 0) {
                        totalPrice = totalPrice + price;
                        System.out.println("Спасибо! Ваш товар добавлен в заказ!");
                        break;
                        } else {
                            System.out.println("Некорректное значение цены, попробуйте снова!");
                        }
                    } else {
                        System.out.println("Ожидается ввод числового значения, попробуйте снова!");
                        scanner.next();
                    }
                }
            }
        }
    }

    public void divTotalPrice() {
        int lastNum = (int) totalPrice % 10;
        if (totalPrice % 100 >= 11 && totalPrice % 100  <= 20) {
            rub =  "рублей";
        } else if (lastNum > 1 && lastNum < 5) {
            rub = "рубля";
        } else if (totalPrice % 10 == 1) {
            rub = "рубль";
        } else {
            rub = "рублей";
        }
        double guestSum = totalPrice / (double)guest;
        System.out.println("Сумма заказа на каждого гостя составила " + String.format("%.2f", guestSum) + " " + rub + ".\nЖдём Вас у нас снова!");
    }
}
