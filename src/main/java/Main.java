import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        Scanner scanner = new Scanner(System.in);

        int countUsers = scanner.nextInt();

        while(true){
            if (countUsers < 1){
                System.out.println("Введите корректное число - 1 или больше");
            } else if (countUsers == 1){
                break;
            } else{
                Calculate calculate = new Calculate(countUsers);
                calculate.check();
                break;
            }
        }
    }
}
