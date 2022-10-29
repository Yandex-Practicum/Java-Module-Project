public class Calculator {

    public static void calculator() {
        List list = new List();
        double sumPrice = list.sumPrice();

        People people = new People();
        double numbOfPeople = people.numbOfPeople();

        double score = sumPrice / numbOfPeople;
        System.out.println("Общая сумма составила " + sumPrice + "рублей\nКаждый человек должен заплатить " + score + "рублей");
        }


}
