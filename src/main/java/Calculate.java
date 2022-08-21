import java.util.Scanner;
class Calculate {
        String names;
        float sum;
        Scanner scanner = new Scanner(System.in);

        public void calculate(int number) {
            if (number == 1) {
                System.out.println("Расслабьтесь, Вам не нужен калькулятор! Мой коллега просто принесет Вам счёт.");
            } else {
                names = "";
                System.out.println("Для завершения программы введите слово \"Завершить\".\nПожалуйста, введите название продукта.");
                String name = scanner.next();
                if (name.equalsIgnoreCase("Завершить")) {
                    System.out.println("Простая прогулка с хорошей компаней всегда полезна для здоровья :)");
                } else {
                    countAndCalculate(name);
                    getResult();
                    getResultForEach(number);
                }
                System.out.println("Спасибо, что заглянули! Приходите ещё!");
            }
        }

        public void getResultForEach (int n){
            float split = sum/(float) n;
            System.out.println(String.format("Каждому надо заплатить: %.2f%s.",split, rightRubles(split)));
        }

        public void getResult(){
            System.out.println("Добавленные товары: " + names);
            System.out.println(String.format("Вы набрали продуктов на сумму: %.2f%s", sum, rightRubles(sum)));
        }

        public void countAndCalculate(String name){
            while (!(name.equalsIgnoreCase("Завершить"))) {
                names = names + "\n" + name;
                System.out.println("Введите стоимость товара в формате:\"'рубли.копейки' [10.45, 11.40]\".");
                while (true) {
                    if (scanner.hasNextDouble()) {
                        float price = scanner.nextFloat();
                        sum = sum + price;
                        System.out.println("Вы успешно добавили " + name + " в корзину.");
                        System.out.println(String.format("Промежуточный итог: %.2f%s.", sum, rightRubles(sum)));
                        System.out.println("Пожалуйста, введите название следущего продукта.\n*если Вы уже взяли всё что хотели, то введите \"Завершить\"");
                        name = scanner.next();
                        break;
                    } else {
                        System.out.println("Стоимость товара принимается только в формате:\"'рубли.копейки' [10.45, 11.40]\".\nПопробуйте еще раз.");
                        scanner.next();
                    }
                }
            }
        }

        public String rightRubles(float a) {
            String rub;
            int theLastTwoNumbers = (int) Math.floor(a)%100;
            int theLastNumber = (int) Math.floor(a)%10;
            if (theLastTwoNumbers >= 11 && theLastTwoNumbers <= 20){
                rub = " рублей";
            } else {
                switch (theLastNumber){
                case 1:
                    rub = " рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rub = " рубля";
                    break;
                default:
                    rub = " рублей";
                    break;
            }}
            return rub;
        }

}
