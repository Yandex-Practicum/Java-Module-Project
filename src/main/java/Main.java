import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости!

        int numberOfFriends;//количество друзей в баре
        String stopInput;//завершение ввода

        String foodName;//название товара
        float foodPrice=0f;//цена товара

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Калькулятор приветствует вас! Введите количество друзей!");

        while(true)
        {
            if(scanner.hasNextInt())
            {
                numberOfFriends=scanner.nextInt();
                if(numberOfFriends>1)
                {
                    break;
                }
                else
                {
                    System.out.println("Друзей должно быть больше 1! Введите количество друзей!");
                }
            }
            else
            {
                System.out.println("Друзей должно быть больше 1!Введите количество друзей!");
                scanner.next();
            }

        }
        for(int i=1;i<=numberOfFriends;i++)
        {
            while(true)
            {
                System.out.println("Друг номер "+i+"! Введите название купленного товара!"); //название может быть любым в том числе и числовым
                foodName=scanner.next();
                calculator.AddTovarName(foodName);

                while(true)
                {
                    System.out.println("Друг номер "+i+"! Введите цену за "+foodName+"!");//цена может быть только числом больше 0

                    if(scanner.hasNextFloat())//это число
                    {
                        foodPrice=scanner.nextFloat();
                        if(foodPrice>0) //это число больше нуля
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Цена должна быть любым числом больше 0!");
                        }
                    }

                    else
                    {
                        System.out.println("Цена должна быть любым числом больше 0!");
                        scanner.next();
                    }

                }
                calculator.AddTovarPrice(foodPrice);

                System.out.println("Друг номер "+i+"! Введите что угодно если хотите продолжить или \"завершить\" если вы добавили все товары!");
                stopInput=scanner.next();

                if(stopInput.equalsIgnoreCase("завершить"))
                {
                    calculator.totalOutput(numberOfFriends);
                    break;
                }


            }
        }


}}

