import java.util.Scanner;
class Calculate {
        String names;
        float sum;

        Calculate(String names, float sum) {
            this.names = names;
            this.sum = sum;
        }

        public static void calculate(String names, float sum, int number) {
            names = "";
            Scanner scanner = new Scanner(System.in);
            System.out.println("Для завершения программы введите слово \"Завершить\".");
            System.out.println("Пожалуйста, введите название продукта.");
            String name = scanner.next();
            if (name.equalsIgnoreCase("Завершить")) {
                System.out.println("Спасибо, что заглянули! Хорошего дня!");
            } else {
                while (!(name.equalsIgnoreCase("Завершить"))) {
                    names = names + "\n" + name;
                    System.out.println("Введите стоимость товара в формате:\"'рубли.копейки' [10.45, 11.40]\"");
                    float price = scanner.nextFloat();
                    sum = sum + price;
                    System.out.println("Вы успешно добавили " + name + " в корзину.");
                    System.out.println(String.format("Промежуточный итог: %.2f%s.", sum, rightRubles(sum)));
                    System.out.println("Пожалуйста, введите название следущего продукта.");
                    name = scanner.next();
                }
                getResult(names, sum);
                conclude(number, sum);
            }
        }

        public static void conclude(int n, float s){
            float l = n;
            float split = s/l;
            System.out.println(String.format("Каждому надо заплатить по %.2f%s",split, rightRubles(split)));
        }

        public static void getResult(String names,float sum){
            System.out.println("Добавленные товары: " + names);
            System.out.println(String.format("Вы набрали продуктов на сумму: %.2f%s", sum, rightRubles(sum)));
        }

        public static String rightRubles(float sum) {
            String rub;
            int a = (int) sum;
            if (a >= 11 && a <= 14) {
                rub = " рублей";
            } else {
                String str = Integer.toString(a);
                char lastLetter = str.charAt(str.length() - 1);
                switch (lastLetter) {
                    case '1':
                        rub = " рубль";
                        break;
                    case '2':
                        rub = " рубля";
                        break;
                    case '3':
                        rub = " рубля";
                        break;
                    case '4':
                        rub = " рубля";
                        break;
                    default:
                        rub = " рублей";
                        break;
                }
            }    return rub;
        }


}
