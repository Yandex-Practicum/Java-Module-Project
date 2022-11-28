public class InputValueController {
        public static boolean IsNumberOfPeopleCorrect(int countPeople) {
            return countPeople > 1;
        }

        public static boolean IsPriceCorrect(double price) {
            return price >= 0;
        }
}

