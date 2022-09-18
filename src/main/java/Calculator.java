public class Calculator {
    private final java.util.Scanner sc;
    private String food = "";
    private double price = 0;
    public int peopleCount = 0;

    Calculator (java.util.Scanner scanner) {
        this.sc = scanner;
    }

    public boolean getPeopleCount() {
        /*
        Запрашивает у пользователя количество человек для разделения счета.
        Возвращает true, если количество получено, false, если пользователь отказался от ввода.
         */
        int count = 0;

        System.out.println("На скольких человек необходимо разделить счёт?");
        while (sc.hasNextInt()) {
            count = sc.nextInt();
            if (count <= 1) {
                System.out.println("Укажите, пожалуйста, более одного человека.");
            }
            else {
                break;
            }
        }

        if (count >= 1) {
            this.peopleCount = count;
            return true;
        }
        else {
            return false;
        }
    }

    public void getFoodList() {
        /*
        Запрашивает у пользователя список заказанных блюд.
         */
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Теперь заполним список заказнных блюд.");
        while (true) {
            String foodName;
            double foodPrice;

            System.out.println("Введите название блюда:");
            while (!sc.hasNext()) {
                sc.next();
            }
            foodName = sc.next();

            System.out.println("Введите стоимость товара в формате 'рубли.копейки':");
            while (true) {
                if (sc.hasNextDouble()) {
                    foodPrice = sc.nextDouble();
                    if (foodPrice > 0) {
                        break;
                    }
                    else {
                        System.out.println("Пожалуйста введите число больше 0.");
                    }
                }
                else {
                    System.out.println("Пожалуйста, введите значение в требуемом формате.");
                    sc.next();
                }
            }

            this.addFood(foodName, foodPrice);

            System.out.println("Хотите добавить следующий товар? Или введите \"Завершить\".");

            while (!sc.hasNext()) {
                sc.next();
            }
            if (sc.next().equalsIgnoreCase("завершить")) {
                break;
            }
        }
    }

    public void calculate() {
        System.out.println("Добавленные товары:");
        System.out.println(this.food);
        System.out.println(String.format("Итоговая сумма %.2f\n", this.price));

        double amount = this.price / (double) this.peopleCount;

        System.out.println(String.format("Нужно скинуться по %.2f %s", amount,
                pluralFormRuble(amount)));
    }

    private void addFood(String foodName, double foodPrice) {
        this.price += foodPrice;
        this.food += String.format("%s, цена %.2f\n", foodName, foodPrice);
        System.out.println("Товар успешно добавлен.");
    }

    private static String pluralFormRuble(double amount) {
        if ((int) amount % 100 / 10 == 1) {
            return "рублей";
        }

        switch ((int) amount % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
