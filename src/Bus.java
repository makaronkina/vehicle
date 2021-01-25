import java.util.concurrent.CountDownLatch;

public class Bus extends Vehicle {

    public Bus(String id) {
        super(id);
        this.capacity = 40.0;
        this.consumption = 7.5;
    }
}
