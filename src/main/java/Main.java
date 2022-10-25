import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Scanner scan1 = new Scanner(System.in);
    static Scanner scan2 = new Scanner(System.in);
    static Scanner scan3 = new Scanner(System.in);
    static int people;
    static Double productPrice;


    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("Привет Мир");
        people();

        while(true){
            addProduct();
            System.out.println("You want add another product? Input 'finish' if - No, else any symbol");
            String finish = scan3.nextLine();
            if(finish.equalsIgnoreCase("finish")){
                break;
            }
        }
        System.out.println("You order: " + calculation.calculationNameProduct());
        System.out.println("Your price per guest: " + calculation.calculationPriceProduct() / people + " ' " + makeEnding(productPrice) + ".penni'");

    }
    public static int people(){

        while (true) {
            System.out.println("How guest?");
            if (scan.hasNextInt()) {
                people = scan.nextInt();
                if (people > 1) {
                    break;
                } else if (people == 1) {
                    System.out.println("nothing to share");
                } else {
                    System.out.println("invalid input");
                    scan.nextInt();
                }
            }else{
                System.out.println("invalid input");
                scan.nextInt();
            }
        }
        return people;
    }
    public static Product addProduct(){
        Product product = new Product();

        String productName;
        System.out.println("Input name product");
        productName = scan1.nextLine();
        product.setNameProduct(productName);
        System.out.println("you added " + productName);
        while(true){
            System.out.println("Input price product into format: 'rubles.penni' [10,45]");
            if(scan2.hasNextDouble()){
                productPrice = scan2.nextDouble();

                if(productPrice > 0){
                    System.out.println("Price product: " + productPrice);
                    product.setPriceProduct(productPrice);
                    break;
                }else {
                    System.out.println("invalid input");
                    scan2.next();
                }
            }else {
                System.out.println("invalid input");
                scan2.next();
            }

        }return product;

    }
    public static String makeEnding(Double productPrice){

        if(Math.round(productPrice)%10 == 1 && Math.round(productPrice)%100 != 11){
            return "ruble";
        }else if((Math.round(productPrice)%10) <= 4 &&  (Math.round(productPrice)%100 >= 2) && (Math.round(productPrice)%100)/10 != 2){
            return "rubles";
        } else return "rubles";
    }
}
