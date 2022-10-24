import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    short person = 0;
    String food = "";
    float totalCoast = 0.00F;
    String rightWord = getRightWord(totalCoast);

    public void addPersons() {
        short number;
        do {
            System.out.println("Сколько вас человек:");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите корректное значение:");
                scanner.next();
            }
            number = scanner.nextShort();
        } while (number <= 1);
        person = number;
    }

    public void addFood() {
        System.out.println("Введите название товара или введите \"Завершить\"");
        while (true) {
            String name = scanner.next();
            if (name.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                food = food + name + "\n";
                System.out.println("Введите цену в формате \"Рубли,Копейки\"");
                float coast = scanner.nextFloat();
                while (coast <= 0) {
                    System.out.println("Введите корректное значение:");
                    coast = scanner.nextFloat();
                }
                totalCoast = totalCoast + coast;
                System.out.println("Добавлено. \nЧтобы продолжить введите название товара. Чтобы завершить введите \"Завершить\"");
            }
        }
    }

    private String getRightWord (float n) {
        n = (int) Math.floor(n);
        n = Math.abs(n) % 100;
        int n1 = (int) (n % 10);
        if (n > 10 && n < 20) return "рублей";
        if (n1 > 1 && n1 < 5) return "рубля";
        if (n1 == 1) return "рубль";
        return "рублей";
    }

    public void printResult () {
        String template = "Каждый должен заплатить %.2f " + rightWord;
        float moneyForPerson = totalCoast / person;
        System.out.println("Добавленные товары:" + "\n" + food);
        System.out.println(String.format(template, moneyForPerson));
    }
}