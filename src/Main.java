import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        race();
    }

    static void race() {
        Queue<Vehicle> road = new LinkedList<>(List.of(new Bus("Bus1"), new Car("Car1"), new Truck("Truck1"),
                new Truck("Truck2"), new Bus("Bus2"), new Car("Car2")
        ));
        ExecutorService executorService = Executors.newFixedThreadPool(road.size());
        for (Vehicle vehicle : road) {
            executorService.execute(vehicle::race);
            executorService.execute(() -> new FuelStation(vehicle).fuel());
        }
        executorService.shutdown();
    }
}