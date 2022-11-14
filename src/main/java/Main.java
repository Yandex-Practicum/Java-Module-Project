public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        //System.out.println("Привет Мир");

        //static short numberOfPeople;
            String list="";
            Double result=0.00;

            //вводим количество участников и сохраняем в переменной  people

            People.countPeople();// все поля и методы класса помечены static, это означает, что для
                                // работы с ними не нужно создавать экземпляр класса, а можно
                                // вызвать его напрямую из класса, например People.countPeople()
                                // (а не объявлять эекземпляр People people=new People();)

            // вызываем метод для ввода наименования и стоимости товаров в цикле
            //выход из цикла: команда 'завершить'. В результате в строке list перечень товаров и
            // их стоимость
            while(Products.finishOfList) {
                    list = list + Products.inputOfProducts()+"\n";
                    Products.exitOfList();
            }


            //вывод данных
            System.out.print("Всего добавлено в список: "+(Products.count-1)+" поз."+"\n");
            System.out.println(list);
            //System.out.println(String.format("Итого: "+"%.2f"+" руб.",Products.total));
            System.out.printf("Итого: "+"%.2f"+ "руб.%n",Products.total);
            System.out.println("Делим на: "+People.numberOfPeople+" участников");
            result=Products.total/People.numberOfPeople;
            System.out.println("Каждый участник должен заплатить: ");
            //вызываем метод правильного окончания слова 'рубли'
            EndofRUB.endOfWord(result);

    }
}
