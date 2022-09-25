
public class Calculator {
    double sum = 0;
    String name1 = "";
    public void nameOfProduct(String name,double cost) {
        if (cost < 1) {
            System.out.println("Товар не добавлен.");
            System.out.println("Товар не может быть бесплатным.Повторите ввод.");
        } else {
            sum += cost;
            name1 = name1 + name + "\n";
            System.out.println("Товар успешно добалвен.");
        }
    }
    public void finalAccount(int quantity){
        System.out.println("Добавленные товары:");
        System.out.println(name1);
        sum = sum / quantity;
        System.out.println("Каждый человек должен заплатить:");
        System.out.print(String.format("%.2f",sum));

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


