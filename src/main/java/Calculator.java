public class Calculator {
    double _amount;
    String _listOfProducts = "Добавленные товаровы:";
    private int _countProd = 0;
    public void addProduct(String nameProd)
    {
        _listOfProducts = _listOfProducts + ("\n" + String.format("%d) ", _countProd) + nameProd);
    }

    public void riseAmount(double priceProd)
    {
        _amount += priceProd;
        _countProd++;
    }
}
