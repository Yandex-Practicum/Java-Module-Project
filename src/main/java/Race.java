public class Race {
    private Car leader;

    public Race() {
        this.leader = null;
    }

    public void calculateDistance(Car car) {
        int distance = car.getSpeed() * 24;
        System.out.println("Автомобиль " + car.getName() + " проедет " + distance + " км за 24 часа.");

        if (leader == null || car.getSpeed() > leader.getSpeed()) {
            leader = car;
        }
    }

    public Car getLeader() {
        return leader;
    }
}