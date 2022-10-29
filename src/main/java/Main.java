public class Main {

    public static void main(String[] args) {

        People people = new People();
        //Ввод количества человек, на которых требуется разделить счет
        System.out.println("На скольких человек необходимо разделить счёт?");
        people.numberOfPeople();

        //Добавление продуктов
        Product product = new Product();
        product.addProduct();

        //Вывод суммы, которую должен заплатить каждый человек
        Calculator calculator = new Calculator();
        calculator.cheque(people.number, product.totalPrice);



    }
}
