import java.util.concurrent.CountDownLatch;

public class Truck extends Vehicle{
    public Truck(String id) {
        super(id);
        this.capacity = 60.0;
        this.consumption = 15;
    }
}
