public class ProductsListAndAmountPerPerson {

    //перехожу на русский из-за условий задачи
    public static void execute(Calculator calculator, int guestsCount) {
        if (calculator.totalSum == 0) {
            System.out.println("Ничего не купили, все по домам");
            return;
        }
        System.out.println(calculator.products);
        double doubleRuble = calculator.totalSum / guestsCount;
        int integerRuble = ((int) doubleRuble) % 100;
        String resultStr = String.format("Каждый должен по счету %1.2f ", doubleRuble);
        if (integerRuble < 21) {
            switch (integerRuble) {
                case 1:
                    resultStr += "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    resultStr += "рубля";
                    break;
                default:
                    resultStr += "рублей";
                    break;
            }
        } else {
            integerRuble %= 10;
            switch (integerRuble) {
                case 1:
                    resultStr += "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    resultStr += "рубля";
                    break;
                default:
                    resultStr += "рублей";
                    break;
            }
        }


        System.out.println(resultStr);
    }
}
