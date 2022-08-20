public class Product {
    private String name;
    private double price;
    Product (String name,double price){
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public int getLengthIntPart(){
        return Double.toString(this.price).indexOf('.')+1;
    }

}
