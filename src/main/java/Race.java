public class Race {
    String leader = "";
    int distance = 0;

    public void newLeader(Car car) {
        int distanceNewCar = 24 * car.speed;
        if (distanceNewCar > this.distance) {
            this.leader = car.name;
            this.distance = distanceNewCar;
        }
    }
}
