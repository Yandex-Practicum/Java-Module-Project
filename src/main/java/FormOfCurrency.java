import java.util.*;

public class FormOfCurrency {
    public static String defineTheForm(int count) {
        String form;
        if (count%100>4 && count%100<21) {
            form = "рублей";
        }
        else if (count%10==1) {
            form = "рубль";
        }
        else if (count%10>1 && count%10<5) {
            form = "рубля";
        }
        else form = "рублей";
        return form;
    }
}
