import java.util.Scanner;

public class InputNumUsers {
    int finnumber  ; //


    public int getNumUsers() { // Метод для возвращения значения(количество человек)

        return this.readFromConsol();

    }




    public int readFromConsol() {  //

        int number; //проверка ввода

        Scanner sc = new Scanner(System.in); //  Сканер для ввода кол-ва человек


        /*
        System.out.println("Ведите количество человек : ");

        while (true) { // Цикл чтения проврки ввода
            int i = sc.nextInt();
            if (i>0) {
                this.finnumber = i;
                break;
            }
            else {
                System.out.println("Please input correct nuber");

            }

        }
 */

        // Вставка для контроля вводимых значений (цены)
        do {
            System.out.println("Введите Количество человек: ");

            while (!sc.hasNextInt()) {
                System.out.println("Это ошибка, нужно ввести число больше 0");
                sc.next(); // this is important!
            }
            number = sc.nextInt(); // Ввод цены в массив

        } while (number <= 0);

        this.finnumber = number;

        // Конец проверки


        return this.finnumber;
    }// Конец метода чтения с клавиатуры


}