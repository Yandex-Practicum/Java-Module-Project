public class Main {
    static String end = "Завершить"; // проверка для завершения ввода продуктов

    public static void main(String[] args) {
        People.howPeople();
        Product.calculate();

        // Вывод результата
        double costPerson = Product.cost / People.countPeople;
        double checkCostPerson = Math.floor(costPerson);

        System.out.println("Добавленные товары:\n" + Product.name);
        System.out.printf("%.2f", costPerson);
        rublesName(checkCostPerson);
    }

    public static void rublesName(double cost) {
        if (cost % 10 == 1 && cost != 11 && cost % 100 != 11) {
            System.out.println(" рубль.");
        } else if (cost % 10 >= 2 && cost % 10 <= 4) {
            System.out.println(" рубля.");
        } else {
            System.out.println(" рублей.");
        }
    }
}



