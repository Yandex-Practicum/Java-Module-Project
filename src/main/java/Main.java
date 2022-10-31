import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //метод определения количества человек на чек
        Calculator people = new Calculator();
        people.addPeople();

        //метод добавления товара
        Calculator check = new Calculator();
        check.addProduct();

        //метод отоброжения чека
        Calculator list = new Calculator();
        list.viewListProduct();
    }
 }