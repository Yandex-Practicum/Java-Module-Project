import java.util.Locale;
import java.util.Scanner;

public class Calculator { //класс для хранения и подсчёта
    String listOfProducts; //список товаров
    double productPrice; //общая стоимость товаров

    public Calculator() { //конструктор
        listOfProducts = ""; //задаём значения по умолчанию для списка товаров
        productPrice = 0.0; //задаём значения по умолчанию для общей стоимости товаров
    }

    public void addProduct() { //метод добавления товаров
        while (true) {
            Scanner in = new Scanner(System.in).useLocale(Locale.US);
            System.out.println("Введите название товара: ");
            String productName = in.nextLine(); //сохраняем название товара
            if (productName.equalsIgnoreCase("Завершить")) { //пользователь завершает ввод списка товаров
                break;
            }
            listOfProducts += productName + "\n"; //в список продуктов добавляем название товаров

            System.out.println("Введите стоимость в формате: 'рубли.копейки' [10.45, 11.40]");
            double price = inputPrice(); //вызываем метод ввода стоимости
            productPrice += price; //в общую стоимость добавляем стоимость введёного товара
            System.out.println("Товар успешно добавлен! Хотите добавить ещё один товар? Если да, то продолжайте писать ваш список. Если нет, то напишите \"Завершить\"");
        }
    }

    public double inputPrice() { //метод ввода стоимости товара
        while (true) {
            Scanner in = new Scanner(System.in).useLocale(Locale.US);

            if (in.hasNextDouble()) { //проверка на число
                double price = in.nextDouble(); //считываем стоимость, которую ввёл пользователь

                if (price > 0) { //проверка на то, что пользователь вводит стоимость больше 0
                    return price;
                } else {
                    System.out.println("Стоимость товара должна быть больше 0!");
                }
            } else {
                System.out.println("Извините, но это явно не число!");
            }
        }
    }

    public static String getRubleAddition(double price) //метод, который склоняет рубль
    {
        int num = (int)Math.floor(price); //округляем стоимость товара к наименьшему целому числу
        int preLastDigit = num % 100 / 10; //нахожу предпоследнюю цифру
        if (preLastDigit == 1) //предпоследняя цифра равна 1
        {
            return "рублей";
        }

        switch (num % 10) //смотрим последнюю цифру
        {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

    public void printInfo(int persona) { //метод вывода информации
        System.out.println("Добавленные товары: \n" + listOfProducts);
        System.out.printf("Стоимость товаров для каждого по отдельности: %.2f %s \n", productPrice / persona, getRubleAddition(productPrice / persona));
        System.out.printf("Общая стоимость товаров: %.2f %s \n" , productPrice, getRubleAddition(productPrice));
    }
}
