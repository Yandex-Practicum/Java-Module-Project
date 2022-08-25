import java.util.Scanner;

public class Calculator {
    String goods ="";// Строка, хранящая перечень всех товаров
    double sum = 0.00;// Строка, хранящая сумму всех товаров


    public void getTheName(String position) {// Добавить товар
        goods = goods+position+"\n";
    }// функция добавления товара
    public void addition (double cost) {// Добавить стоимость
        sum += cost;
    }// функция прибавки цены товара
    public void addedGoods(){// функция вывода перечня товаров
        System.out.println("Добавленные товары:\n");
        System.out.println(goods);
    }
    public void totalSum (int persons){// функция вычисления, сколько должен каждый
        double sum1 = 0.00;
        String message = "Сумма которую должен заплатить каждый: %.2f ";
        String message0 = "";
        String message1 ="рубль";
        String message2 ="рубля";
        String message3 ="рублей";
        sum1 = Math.floor(sum/persons);// Округление числа в меньшую сторону для определения окончания
        double checkNumber = sum1%10;
        if (checkNumber>=2&&checkNumber<=4) {
            message0 = message2; // окончание"рубля"
        }
        else if (checkNumber ==1){
            message0 = message1;
        }
        else {
            message0 = message3;
        }
        System.out.println(String.format(message,sum/persons) + message0);
        }
}
