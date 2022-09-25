public class Calculator {

    String allProduct = "";
    double allPrice;

    void addProduct(Product product){
        allProduct = allProduct + "!" + product.nameProduct;
        allPrice += product.price;
    }

    void returnNameProduct(){
        int i = 0;
        StringBuilder nameProduct = new StringBuilder();
        System.out.print("Добавленные товары:");
        while (i < allProduct.length()){
            if (allProduct.charAt(i) != '!'){
                nameProduct.append(allProduct.charAt(i));
            }
            else {
                System.out.println(nameProduct);
                nameProduct = new StringBuilder();
            }
            i++;
        }
        System.out.println(nameProduct);
    }

    void returnDebtForOne(int quantityPeople){
        double debtForOne = allPrice / quantityPeople;
        int ruble = (int)Math.floor(debtForOne);
        String endingRuble;

        if (ruble % 10 == 1){
            endingRuble = "рубль";
        }
        else if (ruble % 10 == 2 || ruble % 10 == 3 || ruble % 10 == 4){
            endingRuble = "рубля";
        }
        else endingRuble = "рублей";

        System.out.println("Каждый из гостей должен заплатить:\n" + String.format("%.2f", debtForOne) + " " + endingRuble);
    }
}
