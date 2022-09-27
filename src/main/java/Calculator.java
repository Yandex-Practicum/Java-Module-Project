import java.util.Scanner;

public class Calculator {
    double sum = 0;
    String name = "";
    int quantity;
    Scanner scanner = new Scanner(System.in);
    public int quantityOfGuest(){
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true) {
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                if (quantity<=1){
                    System.out.println("Введено отрицательное значение или 1.Повторите ввод.");
                }else {
                    return quantity;
                }
            } else {
                System.out.println("Введено не корректное значение.Повторите ввод.");
            }
            scanner.nextLine();
        }
    }
    public void cheque(String name, double cost) {
        if (cost < 1) {
            System.out.println("Товар не добавлен.\nТовар не может быть бесплатным.Повторите ввод.");
        } else {
            sum += cost;
            this.name = this.name + name + "\n";
            System.out.println("Товар успешно добалвен.");
        }
    }
    public void finalAccount(int quantity){
        System.out.println("Добавленные товары: \n" + name );
        sum = sum / quantity;
        System.out.println("Каждый человек должен заплатить: \n" + String.format("%.2f",sum) + price());
    }
    public String price(){
        if ((int)(sum % 100 / 10) == 1){
          return " рублей.";
        }
        switch ((int) (sum % 10)){
            case 1:
                return " рубль.";
            case 2:
            case 3:
            case 4:
                return " рубля.";
            default:
                return " рублей.";
        }
    }
}


