public class TotalAmountOutput {
    public String GetCorrectRubString(double totalAmount) {
        int lastDigit = GetLastIntDigit(totalAmount);

        switch (lastDigit) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

    //получить последнюю цифру из числа для определения падежа слова рубль
    private int GetLastIntDigit (double totalAmount) {
        int intTotalAmount = (int) totalAmount;
        String stringTotalAmount = String.valueOf(intTotalAmount);
        int length = stringTotalAmount.length();
        char lastDigit = stringTotalAmount.charAt(length-1);
        return Character.getNumericValue(lastDigit);
    }
}

