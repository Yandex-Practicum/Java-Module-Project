import java.util.ArrayList;
import java.util.Scanner;

class equally {

    public static void main (String[] args) {
        firstBlock();

    }
    public static void firstBlock() {
        System.out.println("Добрый день. На сколько человек нужно разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        String members = scanner.nextLine();
        try {
            Integer.parseInt(members.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("Введено не корректное значение. Требуется ввести числовое значение: ");
            members = scanner.nextLine();
        }

        int membersCount = Integer.parseInt(members);

        while (true) {
            if (membersCount > 1) {
                System.out.println("Отлично. Количество персон: " + membersCount);
                break;
            } else {
                System.out.println("Введено не корректное значение(числовое значение от двух и выше): ");
                members = scanner.nextLine();
                try {
                    Integer.parseInt(members.trim());
                    membersCount = Integer.parseInt(members);
                    if (membersCount > 1) {
                        System.out.println("Отлично. Количество персон: " + membersCount);
                        break;
                    } else {
                        System.out.println("Введено не корректное значение(числовое значение от двух и выше): ");
                        scanner.nextLine();
                    }
                } catch (NumberFormatException nfe) {
                    if (membersCount > 1) {
                        System.out.println("Отлично. Количество персон: " + membersCount);
                        break;
                    } else {
                        System.out.println("Введено не корректное значение(числовое значение от двух и выше): ");
                        membersCount = scanner.nextInt();
                    }
                }
            }
        }

        // Ввод товара

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
            amount = scanner.nextDouble();
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

        double sum2 = 0;
        for (Prices g : sum) {
            sum2 = sum2 + g.getAmount();
        }

        double sumTotal = sum2 / membersCount;
        String sumTotal2 = String.format("%.2f", sumTotal);

        if (Math.floor(sumTotal) == 1) {
            System.out.println("Счёт на каждого: " + sumTotal2 + " рубль.");
        } else if (Math.floor(sumTotal) == 2 || Math.floor(sumTotal) == 3 || Math.floor(sumTotal) == 4) {
            System.out.println("Счёт на каждого: " + sumTotal2 + " рубля.");
        } else {
            System.out.println("Счёт на каждого: " + sumTotal2 + " рублей.");
        }
    }
}


