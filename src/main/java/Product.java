public class Product {
    /* На основе этого класса будут созданы объекты Product, которые будут служить
    исходным материалом для расчета общей стоимости заказа
     */

    // наименование товара
    private final String name;
    // стоимость товара
    private final double value;

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Наименование: " + this.name + ", Стоимость: " + this.value;
    }
}
