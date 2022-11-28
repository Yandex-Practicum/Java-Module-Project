import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int countPeople;
        TotalAmountOutput currencyNameConverter = new TotalAmountOutput();

        Scanner scanner = new Scanner(System.in);
        boolean countPeopleIsCorrect;
        do
        {
            System.out.println("На какое количество человек разделить счёт?");
            countPeople = scanner.nextInt();
            // проверка введенного количества людей
            countPeopleIsCorrect = InputValueController.IsNumberOfPeopleCorrect(countPeople);
            if (!countPeopleIsCorrect){
                System.out.println("Количество должно быть больше 1");
            }
        } while (!countPeopleIsCorrect);


        SplitBillCalculator calculator = new SplitBillCalculator(countPeople);

        while (true) {
            System.out.println("Введите наименование товара или команду 'Завершить' для окончания ввода товаров");
            String goodsName = scanner.next();
            if  (goodsName.equalsIgnoreCase("завершить"))
                break;

            double price;
            System.out.println("Введите стоимость товара в формате 0,00");
            while (true){
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    boolean isCorrect = InputValueController.IsPriceCorrect(price);
                    if (isCorrect)
                        break;
                }
                System.out.println("Ошибка в формате числа. Повторите ввод");
                scanner.next();
            }

            Good good = new Good(goodsName, price);
            calculator.AddGoods(good);
            String rubString = currencyNameConverter.GetCorrectRubString(calculator.TotalAmount);
            System.out.printf("Товар добавлен. Текущая сумма счёта %.2f %s\n", calculator.TotalAmount, rubString);
        }

        System.out.println("Добавленные товары:");
        System.out.println(calculator.ListOfGoods);

        String rubString = currencyNameConverter.GetCorrectRubString(calculator.TotalAmount);
        System.out.printf("Общая сумма: %.2f %s\n", calculator.TotalAmount, rubString);

        double splitTotalAmount = calculator.SplitTotalAmount();
        String splitRubString = currencyNameConverter.GetCorrectRubString(splitTotalAmount);
        System.out.printf("Сумма с человека: %.2f %s\n", splitTotalAmount, splitRubString);

        System.out.println("Для завершения нажмите любую клавишу");
        scanner.next();
    }
}

