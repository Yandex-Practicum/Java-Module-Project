import java.util.Scanner;
public class Calculator {
    public static void calc(int people){
        String dish;
        String allDishes = "";
        float price;
        float sumOfOrder = 0.0f;
        String close;
        while(true){
            System.out.println("Введите название блюда!");
            Scanner scSecond = new Scanner(System.in);
            dish = scSecond.nextLine();
            allDishes = allDishes + dish + "\n";
            System.out.println("Введите стоимость этого блюда в формате 'руб.коп'");
            Scanner scThird = new Scanner(System.in);
            if(scThird.hasNextFloat()){
                price = scThird.nextFloat();
                if(price > 0 ){
                    sumOfOrder = sumOfOrder + price;
                    String sufForOne = Finish.finish(price);
                    System.out.println("Вы добавили " + dish + " за " + price + sufForOne );
                    System.out.println("Хотите добавить блюдо? Введите любую букву или напишите:'Завершить', если блюд больше не осталось");
                    Scanner scFourth = new Scanner(System.in);
                    close = scFourth.next();
                    if (close.equalsIgnoreCase("Завершить")){
                        break;
                    }
                }
                else{
                    System.out.println("Сумма указана неверно");
                }
            }
            else{
                System.out.println("Сумма указана неверно, попробуйте внести блюдо снова");
            }

        }
        String suf = Finish.finish(sumOfOrder);
        float forThePerson = sumOfOrder / people;
        String lastSuf = Finish.finish(forThePerson);

        System.out.println("Вы купили:\n" + allDishes + "За " + String.format("%.2f", sumOfOrder) + suf);
        System.out.println("Каждый должен заплатить по: " + String.format("%.2f",forThePerson) + lastSuf);



    }
}
