import java.util.ArrayList;
public class Calculator{
    ArrayList<Item> items = new ArrayList<Item>();
    public double getSum(){
        double sum = 0;
        for (Item item: items){
            sum += item.price;
        }
        return sum;
    }
    public void addItem(Item item){
        items.add(item);
    }
    public String getItemsAsStr(){
        String info = "Добавленные товары: \n";
        for (Item item: items){
            info += item.toString() + "\n";
        }
        return info;
    }

}