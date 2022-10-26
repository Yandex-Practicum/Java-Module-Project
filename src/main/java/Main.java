import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Делитель счёта v.100500. Привет!");
        Calculate cal = new Calculate();
        cal.inputPersons();
        cal.inputItems();
        cal.payPeople();
        cal.endRubles();


    }
        public static class Calculate{
            double total=0;
            int persons=1;
            String items= "";



            public void inputPersons(){
                while(true){
                    System.out.println("Введите количество человек:");
                    persons= sc.nextInt();
                    if (persons<=1){
                        System.out.println("Людей не может быть меньше двух! Попробуйте ещё раз!");
                        continue;
                    }else{
                        break;}
                    }
                }

            public void inputItems(){
                while(true){
                    System.out.println("Введите название товара:");
                    String item=sc.next()+sc.nextLine();
                    System.out.println("Введите цену товара:");
                    if (sc.hasNextDouble()){
                        double price=sc.nextDouble();
                        total+=price;
                        items+=item+"\n";
                    }else{
                        System.out.println("Неверный формат ввода!");
                        sc.nextLine();
                        continue;
                    }
                System.out.println("Товар " + item + " добавлен. Добавим ещё? Да/Нет?");
                     String getMore=sc.next();
                     if (getMore.equalsIgnoreCase("нет")) {
                         break;
                     }else{
                         continue;}
                }
              }

              public void payPeople(){

              System.out.println("Добавленные товары: \n"+items);
              double payPerPerson=total/persons;
                  System.out.println("Каждый из " + persons + " человек заплатит по " + String.format("%.2f",total/persons));
            }

            public void endRubles() {

                String endRuble;
                if (total/persons == 1) {
                    endRuble = "Рубль";
                } else if (total/persons <= 4) {
                    endRuble = "Рубля";
                } else {
                    endRuble = "Рублей";

                }
                System.out.println(endRuble); // это шок
                //Я не понимаю как иначе вывести переменную endRuble. Её нельзя добавить в верхний метод.
            }   //Если поменять параметры метода, то потом он просто не встанет в Main.
             }


            }

