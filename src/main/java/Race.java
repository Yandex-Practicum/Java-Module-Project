import java.util.*;

public class Race {
    Car[] racers;

    Race(Car[] racers) {
        this.racers = racers;
    }

    public void start() {
        ArrayList<Integer> distances = calculateDistances(racers);

        String winner = calculateWinner(distances);

        System.out.printf("The winner is %s", winner);
    }

    private ArrayList<Integer> calculateDistances(Car[] racers) {
        ArrayList<Integer> distances = new ArrayList<>();

        for (Car racer : racers) {
            distances.add(racer.speed * 24);
        }

        return distances;
    }

    private String calculateWinner(ArrayList<Integer> distances) {
        int maxDistance = 0;

        for (int distance: distances) {
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        int indexOfWinner = distances.indexOf(maxDistance);

        return racers[indexOfWinner].name;
    }
}
