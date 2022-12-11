public class Calculation {
    double finishPrice = 0;
    String listOfProducts = "Добавленные товары:";
    double productPrice = 0;
    String productName;

    double calcPrice (double productPrice) {
        this.productPrice = productPrice;
        finishPrice = finishPrice + productPrice;
        return finishPrice;
    }

    String calcName (String productNameOne){
        this.productName = productNameOne;
        listOfProducts = listOfProducts + "\n" + productName;
        return listOfProducts;
    }

    String RubEnding(double PriceInRub){
        int roundingPrice = (int) (Math.floor(PriceInRub));

        if ((roundingPrice%100 >= 10) && (roundingPrice%100 <= 20)){
            return " рублей.";
        }else{
            switch(roundingPrice%10){
                case 1:
                    return " рубль.";
                case 2:
                case 3:
                case 4:
                    return " рубля.";
                default:
                    return " рублей.";
            }
        }
    }

}
