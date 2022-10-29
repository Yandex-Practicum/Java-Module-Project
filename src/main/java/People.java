import java.util.Scanner;
public class People {
    int number = 0;

    // Добавление количества человек, на которых необходимо разделить всю сумму
    public void numberOfPeople(){

        while (true){
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()){
                int count = scanner.nextInt();
                if (count > 1){
                    number = count;
                    break;
                }else if (count == 1){
                    System.out.println("Количество человек, введенное вами, равно 1. Пожалуйста, введите значение больше 1.");
                }else{
                    System.out.println("Вы ввели некорректное значение. Пожалуйста, введите значение больше 1.");
                }

            }else{
                System.out.println("Вы ввели некорректное значение. Пожалуйста, введите значение больше 1.");


            }


        }
    }
}