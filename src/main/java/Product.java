import java.util.Scanner;

public class Product {

    String productList = "";
    String spacing = "\n";
    String str = "Добавленные товары: ";
    double totalPrice;

    //Добавление товаров и их стоимости
    public void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название товара");
        String name = scanner.nextLine();
        productList += str + name + spacing;
        System.out.println("Введите стоимость товара");
        double price = scanner.nextDouble();
        totalPrice+=price;
        System.out.println("Товар успешно добавлен");
        anotherProduct();

    }

    //Спрашиваем у пользователя - хочет ли он добавить еще один товар?
    public void anotherProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите добавить ещё один товар?");
        String fork = scanner.nextLine();

            /*Если пользователь вводит "Да", то повторно вызываем метод addProduct
              Иначе зввершаем добавление товаров */
        if (fork.equalsIgnoreCase("Да")){
            addProduct();

        }

    }

    public void addedProducts (String lists){

        System.out.println(lists);
    }

}