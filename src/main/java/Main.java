import java.util.InputMismatchException;
import java.util.Scanner;

//прописал два класса, вытащил в отдельные методы все что можно было, писал и тестировал у себя в VS code.
public class Main {

    public static void main(String[] args) {

        double finalPrice = 0;
        int peopleNum;
        String productList = "";
        String productName;

        peopleNum = PeopleNum.getPersonNum();

        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Введите название продукта: ");
            productName = sc.nextLine();
            productList += productName + "\n";
            finalPrice += getPrice();
            System.out.println("Введи любой символ для продолжения наполнения списка, или введите команду Stop."); //Использую команду Stop потому что на кириллице у меня ничего не работает
        }while(!"stop".equalsIgnoreCase(sc.nextLine().trim()));

        System.out.println("Итоговый список " + productList + " с ценой " + String.format("%.2f", finalPrice) + " " + getRubAddition((int) finalPrice) + " на " +
                peopleNum + " " + getGuestAddition(peopleNum) + "." + "\nИтоговый расчет чека на человека: " + String.format("%.2f", finalPrice / peopleNum) +
                " " + getRubAddition((int) finalPrice / peopleNum));
    }

    public static double getPrice() { //& DONE😀 для double у меня принимается делитель целого от дробного запятая, а не точка, возможно в этом были проблемы
        double price;

        Scanner sc = new Scanner(System.in);
        System.out.println("Укажите стоимость продукта в формате 'рубли.копейки' (например: 10.45 или 11.40).");
        do {
            try {
                price = sc.nextDouble();
                return price;
            } catch (Exception ex) {
                System.out.println("На ввод принимаются только числа в формате 'рубли.копейки' (например: 10.45 или 11.40).");
                sc.next();
            }
        }while(true);
    }

    public static String getRubAddition(int num) { //& DONE😀

        int preLastDigit = num % 100 / 10;

        if (preLastDigit == 1) {
            return "рублей";
        }

        switch (num % 10) {
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

    public static String getGuestAddition(int num) { //& DONE😀

        int preLastDigitGuest = num % 100 / 10;

        if (preLastDigitGuest == 1) {
            return "гостей";
        }

        switch (num % 10) {
            case 1:
                return "гость";
            case 2:
            case 3:
            case 4:
                return "гостя";
            default:
                return "гостей";
        }
    }
}

class PeopleNum {
    public static int getPersonNum() {
        int personNum;

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество гостей (2 и более):\n");
        while (true) {
            try {
                personNum = sc.nextInt();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Неправильный ввод. На ввод принимаются только целые числа\n");
                sc.nextLine();
            }
        }
        while(personNum < 2) {
            System.out.print("Неправильный ввод. Количество людей должно быть больше 1\n");
            personNum = sc.nextInt();
        }
        return personNum;
    }
}