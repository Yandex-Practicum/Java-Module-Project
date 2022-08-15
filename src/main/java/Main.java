import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Начало программы
        int amountMan = inputAmountMan(); // Получение количества человек для расчета из метода
        System.out.println("Количество человек для расчета - " + amountMan + ".");
        float sumProductPrice = requestProduct(); // Получение общей суммы всех товаров из метода
        float everyonePays = sumProductPrice / amountMan; // Получение расчета на каждого человека
        String rublesEveryonePays = nameRubles(everyonePays); // Получение падежа слова "рубль" из метода
        String messageTemplate = "Каждому счет обойдется в %.2f %s.";
        String finalOutputText = String.format(messageTemplate, everyonePays, rublesEveryonePays);
        finalOutputText = finalOutputText.replace(',', '.'); // Вывод точки вместо запятой (как указано в задании)
        System.out.println(finalOutputText);
    }

    private static int inputAmountMan() {   // Метод ввода количества человек для разделения счета
        // Объявление метода, возвращеющего значение типа int
        System.out.println("Введите количество человек, на которое будет разделен счет");
        Scanner scanner = new Scanner(System.in);  // Создание объекта "сканер"

        int inputMan; // Объявление переменной "количество человек"
        while (true) { // Запускаем бесконечный цикл

            if (scanner.hasNextInt()) {  // Условие, если введено значение типа int
                inputMan = scanner.nextInt(); // Ввод с клавиатуры количества человек для разделения счета

                if (inputMan > 1) { // Если введено корректное значение больше 1
                    break; // Выходим из бесконечного цикла
                } else if (inputMan == 1) {   // Если пользователь вводит 1
                    System.out.println("Программа производит расчеты при количестве человек от 2-х и больше, попробуйте еще раз.");
                }
                else {
                    System.out.println("Некорректное значение, попробуйте еще раз.");
                }
            } else {  // Если пользователь ввел с клавиатуры символ или значение типа отличного от int
                System.out.println("Не балуйтесь с вводом значений. Вводите целое неотрицательное число, большое или равное 2");
                System.out.println("\nВведите количество человек, на которое будет разделен счет");
                scanner.nextLine(); // переход на следующую строку считывания для того, чтобы избежать бесконечного вывода
            }
        }
        return inputMan;
    }
    public static float calcPrice () {  // Метод ввода стоимости товара
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);  // Создание объекта "сканер"
        float priceProduct; // Переменная стоимости продукта
        System.out.println("Введите стоимость продукта в формате 'рубли.копейки' [10.45, 11.40]:");
        while (true) { // Запускаем бесконечный цикл
            if (scanner.hasNextFloat()) {  // Условие, если введено значение типа float
                priceProduct = scanner.nextFloat(); // Ввод с клавиатуры стоимости товара
                if (priceProduct > 0.00) { // Если введено корректное значение больше 0.00
                    break; // Выходим из бесконечного цикла
                } else if (priceProduct <= 0.00) {   // Если пользователь вводит 0.00
                    System.out.println("Некорректное значение, стоимость должна быть больше 0.00");
                }
            } else {  // Если пользователь ввел с клавиатуры некоректные значения
                System.out.println("Не балуйтесь с вводом значений. Вводите дробное неотрицательное число, большое или равное 1 копейке (0.01).");
                scanner.nextLine(); // переход на следующую строку считывания для того, чтобы избежать бесконечного вывода
            }
        }
        return priceProduct;
    }

    public static float requestProduct() { // Метод подсчета общей стоимости товаров

        Scanner scanner = new Scanner(System.in);// Создание объекта "сканер"
        String addedProduct = ""; // Объявление переменной "Добавленные товары" и присваивание ""
        float priceProductOne; // Объявление переменной стоимости одного продукта
        float sumPrice = 0.00F; // Объявление переменной "Общая сумма всех товаров" и присваивание "0.00"
        String continueProgram; // Объявление переменной продолжения или завершения расчетов
        while (true) {  // Бесконечный цикл
            System.out.println("Введите название товара");
            String nameProduct = scanner.nextLine(); // Ввод имени товара
            priceProductOne = calcPrice(); // Вызов функции и получение стоимости товара
            Product newProduct = new Product(nameProduct, priceProductOne); // Создание экземпляра класса product c атрибутами "Имя товара", "Стоимость"
            System.out.println("Товар " + newProduct.productName + " успешно добавлен.");
            addedProduct = addedProduct + "\n" + newProduct.productName + ";"; // Перечень всех добавленных продуктов
            sumPrice = sumPrice + newProduct.productPrice; // Общая стоимость всех продуктов
            System.out.println("Добавленные товары:" + addedProduct);
            System.out.println("Общая сумма: " + sumPrice);
            System.out.println("Хотите ли добавить еще один товар? (введите 'завершить' для расчета стоимости или любой другой символ для продолжения)");
            continueProgram = scanner.nextLine(); // Считываем желание пользователя завершить или не завершать программу
            if (continueProgram.equalsIgnoreCase("Завершить")) { // Условие выхода из бесконечного цикла
                break; // Выходим из бесконечного цикла
            }
            System.out.println("Продолжаем добавлять товары");
        }
        return sumPrice;  // Возвращение общей стоимости всех товаров
    }

    public static String nameRubles (float sum) {  // Метод определения падежа для слова "рубль"

        float finalNumberSum = (float) Math.floor(sum); // Округление в меньшую сторону
        String nameRublesOut; // Объявление строки конечного падежа
        // Вывод полученного падежа слова "рубль"
        if (finalNumberSum >= 10.0 && finalNumberSum <= 20.0) { // Если на каждого человека от от 10 до 20 рублей
            nameRublesOut = "рублей";
        }
        else { // Иначе в зависимости от последней цифры в числе
            finalNumberSum = finalNumberSum % 10;
            if (finalNumberSum == 1.0) {
                nameRublesOut = "рубль";
            }
            else if (finalNumberSum >= 2.0 && finalNumberSum <= 4.0)
                nameRublesOut = "рубля";
            else {
                nameRublesOut = "рублей";
            }
        }
        return nameRublesOut; // То возвращяем "рублей"
    }
}
