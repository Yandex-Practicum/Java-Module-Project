public class RubSumToSring {

// Класс для расчетов

    public String getSumBuyString(float fsum) { // метод возвращает наименование в зависимости от последней цифры


        int sum = (int)fsum;

        //System.out.print("У Вас ");
        switch (sum % 10) {
            case 1:
                return (" рубль");

            case 2:
                return ("рубля");

            case 3:
                return ("рубля");

            case 4:
                return ("рубля");

            case 5:
                return ("рублей");

            case 6:
                return ("рублей");

            case 7:
                return ("рублей");

            case 8:
                return ("рублей");

            case 9:
                return ("рублей");

            case 0:
                return("рублей");

        }

        return "-1";
    }
}


