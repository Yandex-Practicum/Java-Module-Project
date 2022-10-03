public class Product {
    String name;
    double cost;
    static String one = "хуй!";
    static double two = 1.3;

    // конструктор
    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public static void main(String args[]) {
        Product person = new Product(one, two);
        System.out.println(person.name + " " + person.cost);
    }
}
