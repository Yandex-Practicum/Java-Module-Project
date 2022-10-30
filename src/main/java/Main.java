import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (!scanner.hasNextInt()){ // Проверяем, ввели ли значение типа int
            scanner.next();
            System.out.println("Вы ввели неверное значение, попробуйте еще раз: ");
        }
        int amountOfPersons = scanner.nextInt();
        while (amountOfPersons < 2) { // если значенние 0,1 или отрицательное, запрашиваем ввод снова
            System.out.println("В таком случае нет смысла считать :\nВведите значение еще раз: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            amountOfPersons = scanner.nextInt();
        }
        System.out.println("Кол-во персон: " + amountOfPersons);

        Product products = new Product();
        products.saveProducts();
        Calculator calculator = new Calculator();
        calculator.calculate(amountOfPersons, products.totalSumOfProducts);
        calculator.correctOutput();

        }

    }



