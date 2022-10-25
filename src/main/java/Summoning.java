import java.util.Scanner;

public class Summoning {
        public static Goods Calculate (Goods fullList, Goods product) {
            Goods list = fullList;
            list.name = list.name +'\n' + product.name;
            list.price = list.price+ product.price;
            return list;

        }
    }
