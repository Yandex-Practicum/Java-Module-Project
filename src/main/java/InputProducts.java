
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputProducts {// Класс для ввода данных по товару


    float productPriceSum ;
    String product;


    public  void inputProducts(int inputnumfrombill) {// Метод для ввода данных в калькулятор (в качестве параметра ему передается количество людей)

        RubSumToSring rubsumtostring = new RubSumToSring(); //для рублей
        List<String> SubArrayProd = new ArrayList<>(); //создание объекта массива для названия товара
        List<Float> SubArrayPrice = new ArrayList<>(); //создание объекта массива для цены

        Float number;


        Scanner inputprod = new Scanner(System.in);    // создание сканнера



        System.out.println("Введите название товара: ");

        while (true){ // цикл для ввода данных



            product = inputprod.next(); // чтение из сканера


            if (product.equalsIgnoreCase("Завершить")){
                System.out.println("Работа завершена. ");
                break;

            }
            else {
                SubArrayProd.add(product); //Ввод названия товарав массив
            }



            //System.out.println("Input price: ");
            //SubArrayPrice.add(inputprod.nextFloat()); // Ввод цены


            // Вставка для контроля вводимых значений (цены)
            do {
                System.out.println("Введите цену товара: ");

                while (!inputprod.hasNextFloat()) {
                    System.out.println("Цена введенане корректно, пожалуйста попробуйте еще раз.");
                    inputprod.next(); // this is important!
                }
                number = inputprod.nextFloat(); // Ввод цены в массив

            } while (number <= 0);

            // Конец проверки


            SubArrayPrice.add(number); // запись в массив
            System.out.println("Товар успешно добавлен! ");

            System.out.println("Для продолжения ведите название товара, для завершения работы наберите команду 'Завершить' ");

        }


        //String template0;
         int j = 1;
        for(int i = 0; i< SubArrayPrice.size(); i++) { // Чтение данных из двух массивов с выводом
            // System.out.println("Товар: " + SubArrayProd.get(i) + "  Цена: " + SubArrayPrice.get(i));
            String template0 = "%d  Товар -  %s  Цена %.2f %s "  ; // Цена: -  шаблон для промежуточных
            System.out.println(String.format(template0, j++, SubArrayProd.get(i), SubArrayPrice.get(i), rubsumtostring.getSumBuyString(SubArrayPrice.get(i)))); // вывод

            this.productPriceSum = this.productPriceSum+SubArrayPrice.get(i);
        }





        String template = "Общая сумма : - %.2f %s | Количество человек: - %d"; // шаблон для вывда финаьлных результатов
        System.out.println(String.format(template, this.productPriceSum, rubsumtostring.getSumBuyString(this.productPriceSum),inputnumfrombill));


        String template1 = "Каждый должен заплатить: - %.2f %s" ; // шаблон для вывда финаьлных результатов
        System.out.println(String.format(template1, this.productPriceSum/inputnumfrombill,rubsumtostring.getSumBuyString(this.productPriceSum/inputnumfrombill)));




    }


}
