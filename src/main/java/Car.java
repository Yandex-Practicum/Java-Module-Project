public class Car {

    private String name;
    private double speed;

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
        if (!isCorrectSpeed()) this.speed = -1;
    }

    public boolean isCorrectSpeed() {
        if (speed <= 0 || speed > 250) return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return 24 * speed;
    }
}