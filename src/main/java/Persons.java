import java.util.Scanner;

public class Persons {
    int count;

    public void read() {
        System.out.println("Сколько гостей за столом ?");
        Scanner scanner = new Scanner(System.in); // Создаём новый объект класса Scanner
        int count = scanner.nextInt();           // Присваиваем переменной ввод с клавиатуры (Колличество гостей).
        while (count <= 1) {                  // Цикл проверки колличества гостей.
            System.out.println("Вы ввели не корректное колличество гостей. Введите значение больше 1");
            count = scanner.nextInt();
        }
        this.count = count;

    }
}
