
public class Philosopher extends Thread {

    private int philosopherNumber;
    private Chopstick[] chopstick;
    private Checker checker;

    public Philosopher(int philosopherNumber, Chopstick[] chopstick, Checker checker) {
        this.philosopherNumber = philosopherNumber;
        this.chopstick = chopstick;
        this.checker = checker;
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


            if(!checker.checkSafety(philosopherNumber, true)){
                chopstick[philosopherNumber].P();
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking a chopstick " + (philosopherNumber + 1) + " up");
                checker.setPickedUp(philosopherNumber, true);
            }else{
                checker.setPickedUp(philosopherNumber, false);

            }

            try {
                Thread.sleep((int) (Math.random() + 100));
            } catch (InterruptedException e) {
            }

            chopstick[numberOfSecondChopstick].P();
            System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking up a chopstick " + (numberOfSecondChopstick + 1) + " up");
            System.out.println("Philosopher " + (philosopherNumber + 1) + " is eating...");
            checker.setPickedUp(numberOfSecondChopstick, true);
            checker.setEating(philosopherNumber, true);

            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
            System.out.println("Philosopher " + (philosopherNumber + 1) + " is putting a chopstick " + (numberOfSecondChopstick + 1) + " down");
            checker.setPickedUp(numberOfSecondChopstick,false);
            checker.setEating(philosopherNumber, false);
            chopstick[numberOfSecondChopstick].V();
            System.out.println("Philosopher " + (philosopherNumber + 1) + " is putting a chopstick " + (philosopherNumber + 1) + " down");
            chopstick[philosopherNumber].V();
            checker.setPickedUp(philosopherNumber,false);
        }


    }


}
