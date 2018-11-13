
public class Philosopher extends Thread {

    private int philosopherNumber;
    private Chopstick[] chopstick;

    public Philosopher(int philosopherNumber, Chopstick[] chopstick) {
        this.philosopherNumber = philosopherNumber;
        this.chopstick = chopstick;
    }


    public void run() {
        int numberOfSecondChopstick = (philosopherNumber + 1) % 5;

        while (true) {

            System.out.println("Philosopher " + (philosopherNumber + 1) + " Is thinking...");
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
            }
            //P - opuszczanie
            //V - podnoszenie
            chopstick[philosopherNumber].P();
            System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking a chopstick " + (philosopherNumber + 1) + " up");


            try {
                Thread.sleep((int) (Math.random() + 100));
            } catch (InterruptedException e) {
            }

            chopstick[numberOfSecondChopstick].P();
            System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking up a chopstick " + (numberOfSecondChopstick + 1) + " up");
            System.out.println("Philosopher" + (philosopherNumber + 1) + " is eating...");


            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }

            chopstick[numberOfSecondChopstick].V();
            System.out.println("Philosopher " + (philosopherNumber + 1) + " is putting a chopstick " + (philosopherNumber + 1) + " down");
            chopstick[philosopherNumber].V();

        }


    }


}
