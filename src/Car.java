import java.util.concurrent.CountDownLatch;

public class Car extends Vehicle{
    public Car(String id) {
        super(id);
        this.capacity = 20.0;
        this.consumption = 2.5;
    }
}
