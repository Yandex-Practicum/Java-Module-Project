import java.util.Scanner;
class CountBuyers {
    int number;
    CountBuyers (int number){
        this.number = number;
    }

    public static int countBuyers(int number) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте!");
        System.out.println("На скольких человек необходимо разделить счёт?");
        number = scanner.nextInt();
        while (number <= 1) {
            System.out.println("Вы ввели некорректное значение. \nПопробуйте еще раз ");
            number = scanner.nextInt();
        }
        System.out.println("Отлично, начинаем!");
        return number;
    }


}