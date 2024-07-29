public class Car extends Main{
    private String nameOfCar;
    private int velocityOfCar;

    public Car(String nameOfCar, int velocityOfCar) {
        this.nameOfCar = nameOfCar;
        this.velocityOfCar = velocityOfCar;
    }

    // Getter for nameOfCar
    public String getNameOfCar() {
        return nameOfCar;
    }

    // Setter for nameOfCar
    public void setNameOfCar(String nameOfCar) {
        this.nameOfCar = nameOfCar;
    }

    // Getter for velocityOfCar
    public int getVelocityOfCar() {
        return velocityOfCar;
    }

    // Setter for velocityOfCar
    public void setVelocityOfCar(int velocityOfCar) {
        this.velocityOfCar = velocityOfCar;
    }
}
