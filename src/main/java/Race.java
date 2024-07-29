import java.util.ArrayList;
import java.util.Collections;

public class Race {

    private static String leader;
    private static int leadersDistance;

    public static void setLeader(){
        ArrayList<Integer> greaterSpeed = new ArrayList<>();
        for(int i = 0; i < Main.park.size(); i++) greaterSpeed.add(Main.park.get(i).getVelocityOfCar());
        if(!greaterSpeed.isEmpty()) greaterSpeed.sort(Collections.reverseOrder());
        leadersDistance = greaterSpeed.get(0)*24;
        for(int i = 0; i < Main.park.size(); i++){
            Car car = Main.park.get(i);
            if(car.getVelocityOfCar()==greaterSpeed.get(0)) leader = car.getNameOfCar();
        }
    }

    public static int getLeadersDistance() {
        return leadersDistance;
    }

    public static String getLeader() {
        return leader;
    }
}
