import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Делитель счёта v.7. Привет!");
        Calculate cal = new Calculate();
        cal.inputPersons();
        cal.inputItems();
        cal.payPeople();
    }
        static class Calculate{
            double price=0;
            double total=0;
            int persons=0;
            String items= "";
            int payPerPerson;

            String endRuble;


            public  void inputPersons(){
                while(true){
                    System.out.println("Введите количество человек:");
                    if (sc.hasNextInt()) {
                        persons = sc.nextInt();
                    }if (persons>=2){
                    break;
                    }else{
                        System.out.println("Некорректный ввод. Попробуйте ещё раз.");
                        sc.nextLine();
                             }
                        }
                    }


            public void inputItems(){
                while(true){
                    System.out.println("Введите название товара:");
                    String item=sc.next()+sc.nextLine();
                    System.out.println("Введите цену товара:");


                    if (sc.hasNextDouble()) {
                        price = sc.nextDouble();
                    }if (price>2){
                        total+=price;
                        items+=item+"\n";
                    }else{
                        System.out.println("Неверный формат ввода!");
                        sc.nextLine();
                                            }
                System.out.println("Товар " + item + " добавлен. Добавим ещё? Да/Нет?");
                     String getMore=sc.next();
                     if (getMore.equalsIgnoreCase("нет")) {
                         break;
                     }else{
                         }
                    }
              }

              public void payPeople(){

              System.out.println("Добавленные товары: \n"+items);
              payPerPerson=(int)total/persons;
              double pppWithoutRemains=(double) payPerPerson; // по другому я просто не знаю как игнорировать копейки при объявлении окончания рубля, поэтому пришлось убрать их вовсе,
                  endRubles();//другого способа как их заигнорить я не нашёл, так что не судите строго.
                  System.out.println("Каждый из " + persons + " человек заплатит по " + String.format("%.2f",pppWithoutRemains)+ " " +endRuble+ ".");

            }

            public void endRubles() {


                if (payPerPerson % 10 == 1) {
                    endRuble = "рубль";
                } else if (payPerPerson % 10 == 2 || payPerPerson % 10 == 3 || payPerPerson % 10 == 4) { // копейки всё портят.
                    endRuble = "рубля";
                } else {
                    endRuble = "рублей";

                              }

                     }


            }

}

