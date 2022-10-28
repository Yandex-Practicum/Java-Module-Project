public class Calculator {


    public void cheque(int number, double totalPrice){
        //Вычисляем, сколько должен заплать каждый человек
        double result = (float) totalPrice / (float) number;
        int money = (int) Math.floor(result);

        String str = String.format("%.2f", result);
        //Вывод суммы, которую должен заплатить каждый поровну
        if ((money % 100) / 10 == 1){
            System.out.println("Сумма, которую должен заплатить каждый человек составляет: " + str + " рублей");
        }else if (money % 100 == 1){
            System.out.println("Сумма, которую должен заплатить каждый человек составляет: " + str + " рубль");
        }else if (money % 10 >= 2 && money % 10 <= 4){
            System.out.println("Сумма, которую должен заплатить каждый человек составляет: " + str + " рубля");
        }else {
            System.out.println("Сумма, которую должен заплатить каждый человек составляет: " + str + " рублей");
        }
    }
}