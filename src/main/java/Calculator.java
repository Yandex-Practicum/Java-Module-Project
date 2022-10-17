public class Calculator {

    private Product[] array = new Product[20];
    private int size = 0;
    double sum;
    double sumForEach;
    int nuberOfPpl;


    public void addProduct(Product p) {
        array[size] = p;
        size++;
        if (size == array.length) {
            Product[] newArray = new Product[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public void count() {
        for (int i = 0; i < size; i++) {
            sum = sum + array[i].productPrice;
            sumForEach = sum / nuberOfPpl;
            //System.out.println("Добавленные товары: ");
            System.out.println("\n" + array[i].productName);
        }
    }

    public void getNumberOfPpl(int a) {
        nuberOfPpl = a;
    }

    public void nameOfCurrency() {
        int rounded = (int) Math.floor(sumForEach);
        rounded = rounded % 100;
        if (rounded > 20) {
            rounded = rounded % 10;
        }

        if (rounded == 1) {
            System.out.println("\nСумма для каждого составляет: " + sumForEach + " рубль.");
        } else if (rounded >= 5) {
            System.out.println("\nСумма для каждого составляет: " + sumForEach + " рублей.");
        } else if (rounded > 1) {
            System.out.println("\nСумма для каждого составляет: " + sumForEach + " рубля.");
        } else if (rounded == 0)
            System.out.println("\nСумма для каждого составляет: " + sumForEach + " рублей.");
    }
}







