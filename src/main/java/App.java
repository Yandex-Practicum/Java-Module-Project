import java.util.Scanner;
import java.lang.Math;
public class App {
    Scanner sc = new Scanner(System.in);
    Calculator calculator = new Calculator();

    public void run() {
        int peopleCount = getPeopleCount();
        readItems();
        double sum = calculator.getSum();
        String info = calculator.getItemsAsStr();
        System.out.println(info);
        double avg = sum / peopleCount;
        double roundedValue = Math.floor(avg);
        String template;
        if (roundedValue % 100 > 9 && roundedValue % 100 < 21){
             template = "%.2f рублей";
        }
        else if (roundedValue % 10 == 1) {
             template = "%.2f рубль";
        }
        else if ( roundedValue % 10 > 1 && roundedValue % 10 < 5 ) {
             template = "%.2f рубля";
        }
        else {
             template = "%.2f рублей";
        }
        System.out.println(String.format(template, avg));


    }
    private int getPeopleCount(){
        while(true){
           try {
               System.out.println("Укажите колличество человек");
               String myString = sc.next();
               int peopleCount = Integer.parseInt(myString);
               if (peopleCount <= 1) {
                   System.out.println("Колличество человек должно быть больше 1");
                   continue;
               }
               else {
                   return peopleCount;
               }
           } catch (NumberFormatException e) {
               System.out.println("Неревный ввод");

           }

        }
    }
    private  void readItems(){
        while (true) {
            System.out.println("Введите название продукта");
            String title = sc.next();
                while (true) {
                    try {
                        System.out.println("Введите цену продукта");
                        String myString1 = sc.next();
                        double price = Double.parseDouble(myString1);
                        if (price > 0) {
                            Item item = new Item(title, price);
                            calculator.addItem(item);
                            System.out.println("Товар успешно добавлен");
                            System.out.println("Если это все продукты, то введите 'exit', иначе введите любой символ");
                            String finish = sc.next();
                            if (finish.equalsIgnoreCase("exit")) {
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            System.out.println("Неревный ввод");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Неревный ввод");

                    }


                }
                break;



        }
    }


}