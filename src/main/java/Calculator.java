public class Calculator {

    public void calculator() {
        List list = new List();
        double sumPrice = list.sumPrice();
        People People = new People();
        int numbOfPeople = People.numbOfPeople();

        double score = sumPrice / numbOfPeople;
        String finalMessagePrise = "Общая сумма составила %.2f ";
        String finalMessageScore = "\nКаждый человек должен заплатить %.2f ";
        System.out.println(String.format(finalMessagePrise, sumPrice) + endOfWord(sumPrice) + "." + String.format(finalMessageScore, score) + endOfWord(score) + ".");
    }

    public String endOfWord(double a){
        int tseloeA=(int)Math.floor(a);
        if (tseloeA % 100 >5 && tseloeA<=20){return "рублей";}
        else if (tseloeA % 10==1){ return "рубль";}
        else if (tseloeA % 10>1 && tseloeA % 10<5){return "рубля";}
        return "рублей";
    }
}