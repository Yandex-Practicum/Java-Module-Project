public class Calculator //получает на вход название и цену товара, сохраняет названия и общую сумму товаров, выводит в нужном формате

{

    private String tovarName="Добавленные товары:";
    private float totalPrice=0f;

    public void AddTovarName(String foodName)//добавить товар
    {
        tovarName="\n"+tovarName+"\n"+foodName;
    }

    public void AddTovarPrice(float foodPrice)//добавить цену на товар
    {
        totalPrice=totalPrice+foodPrice;
    }

    public void totalOutput(int numberOfFriends)//вывод результата
    {
        String formattedTotalPrice=String.format("%.2f", totalPrice);// приводим общую сумму к нужному виду

        System.out.println(tovarName+"\n"); //выводим список всех товаров

        System.out.println("Общая сумма к оплате: "+String.format("%.2f", totalPrice));

        if(Math.floor(totalPrice/numberOfFriends)>1)
        {
            System.out.println("Каждый друг должен "+ String.format("%.2f",(totalPrice/numberOfFriends))+" рубля!"+"\n");
        }
        else
        {
            System.out.println("Каждый друг должен "+ String.format("%.2f",(totalPrice/numberOfFriends))+" рубль!"+"\n");
        }

    }

}
