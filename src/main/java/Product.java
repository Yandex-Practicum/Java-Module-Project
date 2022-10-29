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
        while (true){
            if (scanner.hasNextDouble()){
                double price = scanner.nextDouble();
                totalPrice+=price;
                System.out.println("Товар успешно добавлен");
                anotherProduct();
                break;
            }else {
                System.out.println("Вы ввели некорректное значение. Пожалуйста, введите корректное значение стоимости");
                scanner.nextLine();
            }
        }
    }



    //Спрашиваем у пользователя - хочет ли он добавить еще один товар?
    public void anotherProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите добавить ещё один товар?");
        String fork = scanner.nextLine();

            /*Если пользователь вводит "Да", то повторно вызываем метод addProduct
              Иначе завершаем добавление продуктов и выводим список добавленных продуктов*/
        if (fork.equalsIgnoreCase("Да")){
            addProduct();

        }else {
            addedProducts(productList);
        }

    }

    //Вывод добавленных продуктов
    public void addedProducts (String lists){

        System.out.println(lists);
    }

}