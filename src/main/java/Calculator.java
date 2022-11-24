import java.util.Scanner;
public class Calculator {
    public void productsLists( Scanner scanner) {
        String answer = "Добавленные товары:";
        String productName;
        float price = 0;
        float sum=0.00f;
        System.out.println("Введите наименование товара");
        productName = scanner.next();
        System.out.println("Введите стоимость товара в формате 'рубли.копейки'");
        while(price<=0){
            if (scanner.hasNextFloat()) price = scanner.nextFloat();
            else System.out.println("Введите корректное значение больше 0.0");
        }
        answer+="\n" + productName;
        sum += price;
        System.out.println("Товар успешно добавлен!\nХотите добавить ещё?");
        switch(scanner.next()) {
            case "Да":
                productsLists(scanner);
            case "Завершить":
                System.out.println(answer);
                System.out.println("Общая сумма"+sum);
        }
    }
}
