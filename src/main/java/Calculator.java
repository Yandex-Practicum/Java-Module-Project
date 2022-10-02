public class Calculator {
    String orderAll = "";
    double priceAll = 0;

    void calculate(String order, double price) {
    orderAll = orderAll + "\n" + order; // Промежуточный список блюд в заказе
    priceAll = priceAll + price; // Промежуточная итоговая сумма
    }

    void resultsOrder() {
        System.out.println(orderAll);
    }

    void resultsPrice(int peopleNumberBill) {
        double resultsPrice2f = priceAll/peopleNumberBill; // Сколько должен заплатить каждый гость с копейками
        System.out.printf("%.2f", resultsPrice2f);

        // Определение окончания рубль/рубля/рублей
        int resultsPriceInt = (int) Math.floor(resultsPrice2f);

        if (resultsPriceInt > 100) {
            resultsPriceInt %= 100;
        }
        if (resultsPriceInt > 20) {
            resultsPriceInt %= 10;
        }

        switch (resultsPriceInt) {
            case 1:
                System.out.println(" рубль");
                break;
            case 2:
            case 3:
            case 4:
                System.out.println(" рубля");
                break;
            default:
                System.out.println(" рублей");
        }

    }
}
