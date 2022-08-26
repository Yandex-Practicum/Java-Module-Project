import java.util.Scanner;

public class Calculator {
    String addedGoods ="";// Строка, хранящая перечень всех товаров
    double sumAllAddedGoods = 0.00;// Строка, хранящая сумму всех товаров


    public void getTheName(String position) {// Добавить товар
        addedGoods = addedGoods+position+"\n";
    }// функция добавления товара
    public void addition (double cost) {// Добавить стоимость
        sumAllAddedGoods += cost;
    }// функция прибавки цены товара
    public void addedGoods(){// функция вывода перечня товаров
        System.out.println("Добавленные товары:\n");
        System.out.println(addedGoods);
    }
    public void totalSum (int persons){// функция вычисления, сколько должен каждый
        double sumRound = 0.00;// Вводим переменную для округления суммы товаров
        String message = "Сумма которую должен заплатить каждый: %.2f ";
        String message0 = "";
        String message1 ="рубль";
        String message2 ="рубля";
        String message3 ="рублей";
        sumRound = Math.floor(sumAllAddedGoods/persons);// Округление числа в меньшую сторону для определения окончания
        double checkNumber = sumRound%10;
        if (checkNumber>=2&&checkNumber<=4) {
            message0 = message2; // окончание"рубля"
        }
        else if (checkNumber ==1){
            message0 = message1;
        }
        else {
            message0 = message3;
        }
        System.out.println(String.format(message,sumAllAddedGoods/persons) + message0);
        }
}
