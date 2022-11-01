import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Purchases item = new Purchases();
            item.friends();
            item.allItem();
            System.out.println(Purchases.allName);
            item.result();
    }

    public static class Purchases {
        Scanner scanner = new Scanner(System.in);
        static String name; 				// наименование одного блюда
        static double cost; 			// стоимость одного блюда float
        static String costString;				// стоимость одного блюда String
        static String allName = "\nВаш список блюд:\n"; 		// список всех блюд
        static double allCost;				// общая сумма
        String friendsString;						// количество друзей
        static int friends;							// количество друзей
        boolean a=true;
        static String rubString;
        static String kopeckString;
        static int rub;
        static int kopeck;
        static String money;

        public void friends() {				//* метод для получения количества друзей
            System.out.println("Привет! Я программа, которая помогает делить счёт между друзьями поровну. \nНапишите, пожалуйста, сколько вас.");
            while (a) {
                friendsString = scanner.nextLine();
                try {
                    friends = Integer.parseInt(friendsString.trim());
                    if (friends<=1) {
                        System.out.println("Вы хотите разделить счёт на " + friends + "? Это странно. Напишите, пожалуйста, настоящее количество друзей.");
                        a=true;
                    }
                    else if ((friends%100==11) || (friends%100==12) || (friends%100==13)) {
                        System.out.println("Ок, счёт будет разделён на " + friends + " друзей.");
                        a=false;
                    }
                    else if ((friends%10==1) || (friends%10==2) || (friends%10==3)) {
                        System.out.println("Ок, счёт будет разделён на " + friends + " друга.");
                        a=false;
                    }
                    else {
                        System.out.println("Ок, счёт будет разделён на " + friends + " друзей.");
                        a=false;
                    }
                }
                catch (NumberFormatException nfe) {
                    System.out.println("Напишите, пожалуйста, число, используя только арабские цифры.");
                }
            }
        }

        public void nameItem() {	//* метод для получения наименования одного товара
            System.out.println("\nНапишите название блюда, которое вы хотите добавить. \nЕсли блюд больше нет, то напишите \"завершить\".");
            name = scanner.nextLine();
        }

        public void costItem() {	//* метод для получения стоимости одного товара с проверкой
            System.out.println("Введите стоимость товара в формате 'рубли.копейки' (00.00)");
            while (((scanner.hasNextDouble()))||((scanner.hasNextInt()))) {
                System.out.println("Пострайтесь писать строго по формату: 'рубли.копейки' (00.00), иначе программа не будет работать. /n Н.п., 15 рублей и 26 копеек надо писать как '15.26'");
                costString = scanner.nextLine();
            }
            costString = scanner.nextLine();
            cost = Double.valueOf(costString);
        }

        public void money() {		//* метод для красивого вывода стоимости каждого товара
            Purchases item = new Purchases();
            item.costItem();
            rub = (int)cost;
            kopeck =(int) Math.round((cost - rub)*100);
            item.beauty();
            money = rubString + kopeckString;
        }


        public void allItem() {		//* метод для получения списка всех блюд и общей суммы
            Purchases item = new Purchases();
            item.nameItem();
            while (!(name.equalsIgnoreCase("завершить"))) {
                item.money();
                allName = allName + "  🥣  " + name + " - " + money + "\n";
                allCost+=cost;
                rub = (int) allCost;
                kopeck =(int) Math.round((allCost - rub)*100);
                item.beauty();
                System.out.println("Блюдо \"" + name + "\" успешно добавлено. \nТекущая стоимость: " + rubString + kopeckString);
                item.nameItem();
            }
        }

        public void result() {
            rub = (int) allCost;
            kopeck =(int) Math.round((allCost - rub)*100);
            Purchases item = new Purchases();
            item.beauty();
            System.out.println("Общая сумма - " + rubString + kopeckString);
            allCost/=friends;
            rub = (int) allCost;
            kopeck =(int) Math.round((allCost - rub)*100);
            item.beauty();
            System.out.println("Сумма на каждого - " + rubString + kopeckString);
        }

        public void beauty() {
            if ((rub%100>=11)&&(rub%100<=19)) {
                rubString = rub + " рублей ";
            }
            else if (rub%10==1) {
                rubString = rub + " рубль ";
            }
            else if ((rub%10>=2)&&(rub%10<=4)) {
                rubString = rub + " рубля ";
            }
            else {
                rubString = rub + " рублей ";
            }
            if ((kopeck%100>=11)&&(kopeck%100<=19)) {
                kopeckString = kopeck + " копеек ";
            }
            else if (kopeck%10==1) {
                kopeckString = kopeck + " копейка ";
            }
            else if ((kopeck%10>=2)&&(kopeck%10<=4)) {
                kopeckString = kopeck + " копейки ";
            }
            else {
                kopeckString = kopeck + " копеек ";
            }
        }
    }
}

