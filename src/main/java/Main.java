public class Main {
    public static void main(String[] args) {




        inputCalc(inputNumForBill()); // Вызов калькулятора с передачей параметров


    }



    public static int inputNumForBill() { // Метод создания объекта класса для ввода количества пользователей

        InputNumUsers inputnumusers = new InputNumUsers(); // Создание объекта
        return inputnumusers.getNumUsers(); // вызов метода чтения кол-ва участников

    }

    public static void inputCalc(int inputnumfrombill) {    // Метод создания объекта класса для ввода количества пользователей класса дла ввода товаров и цен

        InputProducts inputproducts = new InputProducts(); // Создание объекта
        inputproducts.inputProducts(inputnumfrombill); // вызов метода ввода товаров и цен с передачей количества людей для расчета

    }


}


