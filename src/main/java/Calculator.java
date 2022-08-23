import java.util.Scanner;

public class Calculator {
    String goods ="";
    double sum = 0.00;
    double sum1 = 0.00;

    public void getTheName(String position) {// Добавить товар
        goods = goods+position+"\n";
    }
    public void addition (double cost) {// Добавить стоимость
        sum += cost;
    }
    public void addedGoods(){
        System.out.println("Добавленные товары:\n");
        System.out.println(goods);
    }
    public void totalSum (int persons){
        String message = "Сумма которую должен заплатить каждый: %.2f ";
        String message1 ="рубль";
        String message2 ="рубля";
        String message3 ="рублей";
        sum1 = Math.floor(sum/persons);

        if (sum1%10>=2||sum1%10<=4) {
            System.out.println(String.format(message,sum/persons) + message2); // окончание"рубля"
        }
        else if (sum1%10 ==1){
            System.out.println(String.format(message,sum/persons) + message1);
        }
        else {
            System.out.println(String.format(message,sum/persons) + message3);
        }
        }
}
