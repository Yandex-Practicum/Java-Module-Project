import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        String products = "";
        String exit_word = "завершить";
        int persons = 1;
        double sum = 0;

        System.out.println("Калькулятор счёта");

        persons = Persons();
        if (persons>1) {
            System.out.println("Кол-во человек: " + persons);
        }


    }

    public static int Persons() {
        Scanner scanner = new Scanner(System.in);
        int persons = 1;
        while (persons<2) {
            System.out.println("Введите кол-во человек от 2 и более или 0 для выхода");
            persons = scanner.nextInt();
            if (persons==0) {
                System.out.println("Выход");
                break;
            } else if (persons>1) {
                break;
            }
        }
        return persons;
    }

    public static void Product() {
        String name = "";
        double price = 0;

    }



}
