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
        System.out.print(rublesName(checkCostPerson));


    }

    public static boolean rublesName(double checkCostPerson) {
        if (checkCostPerson <= 20) {
            if (checkCostPerson == 1) {
                System.out.println(" рубль.");
            } else if (checkCostPerson >= 2 && checkCostPerson <= 4) {
                System.out.println(" рубля.");
            } else if (checkCostPerson >= 5 && checkCostPerson <= 20) {
                System.out.println(" рублей.");
            } else if (checkCostPerson > 20) {
                double checkCostPersonOver20 = checkCostPerson % 10;
                if (checkCostPersonOver20 == 1) {
                    System.out.println(" рубль.");
                } else if (checkCostPersonOver20 >= 2 && checkCostPersonOver20 <= 4) {
                    System.out.println(" рубля.");
                } else if (checkCostPersonOver20 >= 5 && checkCostPersonOver20 <= 20) {
                    System.out.println(" рублей.");
                } else if (checkCostPersonOver20 > 20) {
                }
            } else {
                return false;
            }
        }
        return false;
    }

}
