public class Product {

    public String name;
    public double coast;

    Product(String name, double coast) {
        this.name = name;
        this.coast = coast;
    }

    public String toString() {
        return String.format("%s:\t%.2f", name, coast);

    }
}
