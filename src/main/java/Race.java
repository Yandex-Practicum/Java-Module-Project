public class Race {

    String leaderName = "";
    int leaderDictance = 0;

    public void newLeaderDefining(Car newCar){
        if (newCar.velocity*24 > leaderDictance){
            leaderDictance = newCar.velocity*24;
            leaderName = newCar.name;
        }
    }
}
