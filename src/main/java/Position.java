import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Position {
    String positionName;
    double positionPrice;
    Position(String name, double price) {
        positionPrice = price;
        positionName = name;
    }
    Position() {}
    public double calculate(ArrayList<Position> positions) {
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
        switch ((int) (d % 20)) {
            case 1: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рубль"); break;
            case 2: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рубля"); break;
            case 3: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рубля"); break;
            case 4: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рубля"); break;
            default: System.out.println(this.positionName + ": " + String.format("%.2f",this.positionPrice) + " рублей"); break;
        }
    }
    public ArrayList<Position> counter() throws InputMismatchException, NoSuchElementException {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        ArrayList<Position> positions = new ArrayList();
        double price = 0;
        String closed = "";
        String name = "";
        Scanner scanner = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out); //коммент для коммита
        do {
            ps.println("Введите название товара и цену через Enter (дробные цены вводите через .)");
            name = scanner.nextLine();
            while (price<=0) {
                try {
                    price = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Введите цену!");
                }
            }
            Position buf = new Position(name,price);
            positions.add(buf);
            price = 0;
            System.out.println("Товар добавлен!");
            System.out.println("Добавить еще или завершить?");
            closed = scanner.nextLine();
            } while (!(closed.equalsIgnoreCase("завершить")));
            return positions;
    }

}