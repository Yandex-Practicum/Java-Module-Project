import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int quantity;
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true) {
            quantity = scanner.nextInt();
            if (quantity<=1){
                System.out.println("Введено не корректное число человек.");
            } else{
                break;
            }
        }
            while (true) {
                scanner.nextLine();
                System.out.println("Введите название товара.");
                String name = scanner.nextLine();
                System.out.println("Введите стоимость товара в формате: \"рубли,копейки\" [10,45]");
                if (scanner.hasNextDouble()) {
                    double cost = scanner.nextDouble();
                    calculator.nameOfProduct(name, cost);
                    System.out.println("Хотите ли добавить еще один товар? \n" +
                            "(Если да,напишите любой символ ,если нет,напишите \"Завершить\". )");
                } else {
                    System.out.println("Введено не корректное значение.Повторите ввод.");
                }
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("завершить")) {
                    calculator.finalAccount(quantity);
                    System.out.println(calculator.price());
                    break;
                }
            }

    }
}
