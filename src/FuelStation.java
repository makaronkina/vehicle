import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class FuelStation {
    private Vehicle vehicle;
    private double capacity;
    private CountDownLatch downLatch;

    private Semaphore semaphore;

    public FuelStation(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.semaphore = new Semaphore(3, true);
        this.downLatch = vehicle.countDownLatch;
    }

    public void fuel() {
        capacity = vehicle.getCountCapasity();
        try {
            semaphore.acquire();
            downLatch.await();
            System.out.printf("Is time to refuel %s!\n", vehicle.getId());
            double remainder = vehicle.capacity;
            double refueling = capacity - remainder;
            Thread.sleep(5000);
            System.out.printf("%s refueled by %sl\n", vehicle.getId(), refueling);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }
}
