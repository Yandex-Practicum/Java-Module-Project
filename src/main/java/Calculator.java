import java.util.Scanner;

public class Calculator {
//класс и метод подсчета общей стоимости товара
    public void calculate(int guests) {
        String food = "Dobavlennie tovari: \n";
        Double price = 0.0;
        while (true) {
            System.out.println("Vvedite nazvanie produkta ili zavershit: ");
            Scanner scanner = new Scanner(System.in);
            String inputFood = scanner.next();
//если ничего не добавлено и введено "завершить"
            if (inputFood.equalsIgnoreCase("Zavershit") && food.equals("Dobavlennie tovari: \n")) {
                break;
            } else if (inputFood.equalsIgnoreCase("Zavershit")) {
                System.out.println(food);
                System.out.println("Kagdiy chelovek zaplatit: " + String.format("%.2f", price / guests) + " " + getRubleAddition(price / guests));
                break;

            } else {

                System.out.println("Vvedite cenu tovara [rub.cop]");
                Double inputPrice = scanner.nextDouble();
                if (inputPrice>0) {

                    food = food + inputFood + "\n";
                    price = price + inputPrice;
//                System.out.println("Tovar " + inputFood + " Dobavlen uspeshno, ego cena sostavlaet: " + inputPrice);
                    System.out.println("Tovar " + inputFood + " Dobavlen uspeshno, ego cena sostavlaet: " + inputPrice + " " + getRubleAddition(inputPrice));
                }
                else {
//случай когда цена товара меньше 0
                    System.out.println("Cena tovara ne mozhet bit menshe 0!");
                }
            }
        }
    }
//метод для написания рублей в правильном падеже
    public String getRubleAddition(Double num) {
        int preLastDigit = (int) (num % 100 / 10);
        if (preLastDigit == 1) {
            return "rubley";
        }

        switch ((int) (num % 10)) {
            case 1:
                return "rubl";
            case 2:
            case 3:
            case 4:
                return "rublya";
            default:
                return "rubley";
        }
    }

}