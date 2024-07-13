import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();

    public Race() {
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car getWinner() {
        if (cars.isEmpty()) return null;
        Car winner = cars.get(0);
        for (Car car : cars) {
            if (car.getDistance() > winner.getDistance())
                winner = car;
        }
        return winner;
    }
}