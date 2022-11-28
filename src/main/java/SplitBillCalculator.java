public class SplitBillCalculator {

    int countPeople;

    public String ListOfGoods = "";
    public double TotalAmount = 0;

    public SplitBillCalculator(int countPeople) {
        this.countPeople = countPeople;
    }

    public void AddGoods(Good good) {
        ListOfGoods = ListOfGoods +"\n"+ good.Name;
        TotalAmount = TotalAmount + good.Price;
    }

    public double SplitTotalAmount() {
        return TotalAmount / countPeople;
    }
}
