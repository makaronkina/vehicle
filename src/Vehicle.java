import java.util.concurrent.CountDownLatch;

public abstract class Vehicle {
    private String id;
    protected double capacity;
    private double countCapasity;
    protected double consumption;
    protected CountDownLatch countDownLatch;


    public Vehicle(String id) {
        this.id = id;
    }

    public void race() {
        int count = ((int) (this.capacity / this.consumption));
        countDownLatch = new CountDownLatch(count);
        countCapasity = capacity;
        System.out.printf("Full tank in %s, let's go!!!\n", id);
        for (int i = 0; i < count; i++) {
            try {
                capacity = capacity - consumption;
                System.out.printf("%s driving, driving, driving... Remainder %sl\n", id, capacity);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    public String getId() {
        return id;
    }

    public double getCountCapasity() {
        return countCapasity;
    }
}

