import java.util.ArrayList;
import java.util.Scanner;

class equally {

    public static void main (String[] args) {
        getAmountOfPeople();
    }
    public static void getAmountOfPeople() {
        System.out.println("Добрый день. На сколько человек нужно разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        String members = scanner.nextLine();
        int membersCount = 0;

        try {
            Integer.parseInt(members.trim());
            membersCount = Integer.parseInt(members);
            if (membersCount > 1) { // если всё ок, сразу переходим к другому блоку.
                System.out.println("Отлично. Количество персон: " + membersCount);
                membersCount = Integer.parseInt(members);
            } else {
                System.out.println("Введите числовое значение от двух и выше: ");
                membersCount = getMembersCount(scanner, membersCount); // если сложности с числом, то перекидываем в цикл.
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Введите числовое значение от двух и выше: "); // на случай ввода текстового значения.
            membersCount = getMembersCount(scanner, membersCount);// перекидываем в цикл.
        }

        ArrayList<Prices> sum = getDishesAndPrices(scanner);

        getResult(membersCount, sum);
    }

    private static int getMembersCount(Scanner scanner, int membersCount) {
        String members;
        boolean success = false;
        while (!success) {
            members = scanner.nextLine();
            membersCount = Integer.parseInt(members);
            if (membersCount > 1) {
                System.out.println("Отлично. Количество персон: " + membersCount);
                membersCount = Integer.parseInt(members);
                success = true;
            } else {
                System.out.println("Введите числовое значение от двух и выше: ");
            }
        }
        return membersCount;
    }

    private static ArrayList<Prices> getDishesAndPrices(Scanner scanner) {
        ArrayList<Dishes> hadEaten = new ArrayList<>();
        ArrayList<Prices> sum = new ArrayList<>();

        double amount;
        while (true) {
            System.out.println("Введите наименование товара (для завершения работы введите \"Завершить\"): ");
            String name = scanner.next();
            if (name.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.println("Введите стоимость товара (формат ввода \"рубли.копейки [10.45, 11.40]\": ");
            String amount2 = scanner.next();
            try {
                Double.parseDouble(amount2.trim());
            } catch (Exception nfe) {
                System.out.println("Введено не корректное значение. Требуется ввести стоимость товара (формат ввода \"рубли.копейки [10.45, 11.40]\": ");
                amount2 = scanner.next();
            }
            amount = Double.parseDouble(amount2.trim());
            String result = String.format("%.2f", amount);
            Dishes a = new Dishes(name, result);
            hadEaten.add(a);
            System.out.println("Товар успешно добавлен.");
            Prices b = new Prices(amount);
            sum.add(b);

        }

        for (Dishes t : hadEaten) {
            System.out.println("Наименование товара: " + t.getNameOfDish() + "\nСтоимость: " + t.getAmount() + " руб.");
        }
        return sum;
    }

    private static void getResult(int membersCount, ArrayList<Prices> sum) {
        double sum2 = 0;
        for (Prices g : sum) {
            sum2 += g.getAmount();
        }

        double sumTotal = sum2 / membersCount;
        double sumTotalRound = Math.floor(sumTotal);
        String sumTotal2 = String.format("%.2f", sumTotal);
        String result2;
        if (sumTotalRound == 1) {
            result2 = " рубль.";
        } else if (sumTotalRound >= 2 && sumTotalRound <=4) {
            result2 = " рубля.";
        } else {
            result2 = " рублей.";
        }
        System.out.println("Счёт на каждого: " + sumTotal2 + result2);
    }
}
