public class Product {
    double price;
    String name;

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }
    String getName (){
        return this.name;
    }
    double getPrice (){
        return this.price;
    }
}

