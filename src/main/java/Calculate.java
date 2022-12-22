public class Calculate {

     private int people;

      static String listProduct = "Добавленные товары: ";
      static double sum = 0;

    Calculate(int people){
        this.people = people;
    }
    void addProduct(Product product) {
        System.out.println(product.name + product.price + " Товар успешно добавлен ");
        sum = sum + product.price;
        listProduct = listProduct + "\n" + product.name + product.price;

        System.out.println(listProduct);
        System.out.println("Общая сумма всех добавленных товаров: " + sum);
    }
        public static double getSum() {
            return sum;
        }
}
