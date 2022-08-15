import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
class Position {
    String positionName;
    double positionPrice;
    Position(String name, double price) {
        positionPrice = price;
        positionName = name;
    }
    public static double calculate(ArrayList<Position> positions) {
        int i = 0;
        double result = 0;
        while (i < positions.size()) {
            result += positions.get(i).positionPrice;
            i++;
        }
        return result;
    }
    public void printPosition() {
        double d = Math.floor(this.positionPrice);
        switch ((int) (d % 10)) {
            case 1: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рубль"); break;
            case 2: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рубля"); break;
            case 3: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рубля"); break;
            case 4: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рубля"); break;
            case 5: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рублей"); break;
            case 6: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рублей"); break;
            case 7: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рублей"); break;
            case 8: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рублей"); break;
            case 9: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рублей"); break;
            case 0: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рублей"); break;
        }
    };
}

public class Main {

    public static ArrayList<Position> counter() {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        ArrayList<Position> positions = new ArrayList();
        int i = 0;
        double price = -1;
        String close = "";
        String name = "";
        final Scanner scanner = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out); //коммент для коммита
        do {
            ps.println("Введите название товара и цену через пробел (дробные цены вводите через ,)");
            name = scanner.next();
            price = scanner.nextDouble();
            while (price <= 0) {
                ps.println("Введите положительную цену, имя заново вводить не нужно");
                price = scanner.nextDouble();
            }
            Position buf = new Position(name, price);
            positions.add(buf);
            i++;
            ps.println("Товар успешно добавлен");
            ps.println("Добавить еще товар или завершить ввод?");
            close = scanner.next();
        } while (!(close.equalsIgnoreCase("завершить")));
        return positions;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out);
        double result = 0;
        ps.println("Введите количество персон, более 1:");
        int amountPeople = 0;
        amountPeople = scanner.nextInt();
        while (amountPeople < 2) {
            System.out.println("Введите количество персон, более 1:");
            amountPeople = scanner.nextInt();
        }
        ArrayList<Position> resultPositions = counter();
        ps.println("Добавленные товары:");
        int j = 0;
         do {
            resultPositions.get(j).printPosition();
            j++;
        } while (j < resultPositions.size());
         ps.println();
         result = Position.calculate(resultPositions) / amountPeople;
         ps.print("Каждый должен заплатить: ");
         switch ((int) (result % 10)) {
             case 1: ps.println(String.format("%.2f", result)+" рубль"); break;
             case 2: ps.println(String.format("%.2f", result)+" рубля"); break;
             case 3: ps.println(String.format("%.2f", result)+" рубля"); break;
             case 4: ps.println(String.format("%.2f", result)+" рубля"); break;
             case 5: ps.println(String.format("%.2f", result)+" рублей"); break;
             case 6: ps.println(String.format("%.2f", result)+" рублей"); break;
             case 7: ps.println(String.format("%.2f", result)+" рублей"); break;
             case 8: ps.println(String.format("%.2f", result)+" рублей"); break;
             case 9: ps.println(String.format("%.2f", result)+" рублей"); break;
             case 0: ps.println(String.format("%.2f", result)+" рублей"); break;
         }
    }
}
