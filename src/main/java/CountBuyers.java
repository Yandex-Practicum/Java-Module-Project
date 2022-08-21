import java.util.Scanner;
class CountBuyers {
    int number;

    public int countBuyers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте!");
        System.out.println("На сколько человек необходимо разделить счёт?");
        while(true){
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 1) {
                    System.out.println("Отлично! Давайте посчитаем.");
                    break;
                } else if (number == 1){
                    break;
                } else {
                    System.out.println("Ноль и отрицательные числа недопустимы. Введите натуральное число.");
                }
            } else{
                    System.out.println("Для ввода количества используйте вместо букв цифры. Попробуйте еще раз.");
                }
                scanner.nextLine();
                }
        return number;
    }

}