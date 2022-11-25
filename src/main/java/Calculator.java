public class Calculator //получает на вход название и цену товара, сохраняет названия и общую сумму товаров, выводит в нужном формате

{

    private String tovarName = "Добавленные товары:";
    private float totalPrice = 0f;

    public void AddTovarName(String foodName)//добавить товар
    {
        tovarName = "\n" + tovarName + "\n" + foodName;
    }

    public void AddTovarPrice(float foodPrice)//добавить цену на товар
    {
        totalPrice = totalPrice + foodPrice;
    }

    public void totalOutput(int numberOfFriends)//вывод результата
    {

        System.out.println(tovarName + "\n"); //выводим список всех товаров

        System.out.println("Общая сумма к оплате: " + String.format("%.2f", totalPrice) + rubFormat(Math.floor(totalPrice)));
        System.out.println("Каждый друг должен " + String.format("%.2f", (totalPrice / numberOfFriends)) + rubFormat(Math.floor(totalPrice / numberOfFriends)));

    }

    private String rubFormat(double totalSum) {

        String rubleView;

        int totalIntBaseSum = (int) totalSum;//базовое число, не меняется
        int totalIntSum = totalIntBaseSum;

        if (totalIntBaseSum >= 100) {
            totalIntSum = totalIntBaseSum % 100;
            if (totalIntSum > 20) {
                totalIntSum = totalIntSum % 10;
            }
        } else if (totalIntBaseSum > 20) {
            totalIntSum = totalIntBaseSum % 10;
        }

        if (totalIntSum < 1) {
            rubleView = " рублей!";
        } else if (totalIntSum == 1) {
            rubleView = " рубль!";
        } else if (totalIntSum < 5) {
            rubleView = " рубля!";
        } else {
            rubleView = " рублей!";
        }

        return (rubleView);

    }
}
