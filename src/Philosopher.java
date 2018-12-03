
public class Philosopher extends Thread {

    private int philosopherNumber;
    private Chopstick[] knives;
    private Chopstick[] forks;

    private Checker checker;

    public Philosopher(int philosopherNumber, Chopstick[] forks, Chopstick[] knives, Checker checker) {
        this.philosopherNumber = philosopherNumber;
        this.knives = knives;
        this.forks = forks;
        this.checker = checker;
    }


    public void run() {

        while (true) {

            System.out.println("Philosopher " + (philosopherNumber + 1) + " Is thinking...");
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
            }
            //P - opuszczanie
            //V - podnoszenie

            int forkNumber = checker.getNumberOfFreeFork();
            int kniveNumber = checker.getNumberOfFreeKnive();

            if (checker.checkSafety(forkNumber, kniveNumber, true)) {

                knives[forkNumber].P();
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking a knive " + (kniveNumber + 1) + " up");
                checker.setKnivesPickedUp(kniveNumber, true);
                forks[kniveNumber].P();
                try {
                    Thread.sleep((int) (Math.random() + 100));
                } catch (InterruptedException e) {
                }

                System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking up a fork " + (forkNumber + 1) + " up");
                checker.setForksPickedUp(forkNumber, true);

                checker.setEating(philosopherNumber, true);
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is eating...");

                try {
                    Thread.sleep((int) (Math.random() + 100));
                } catch (InterruptedException e) {
                }

                System.out.println("Philosopher " + (philosopherNumber + 1) + " is putting a knive " + (kniveNumber + 1) + " down");
                checker.setKnivesPickedUp(kniveNumber, false);
                checker.setEating(philosopherNumber, false);
                knives[kniveNumber].V();

                System.out.println("Philosopher " + (philosopherNumber + 1) + " is putting a fork " + (forkNumber + 1) + " down");
                forks[forkNumber].V();
                checker.setForksPickedUp(forkNumber, false);

            }

        }


    }


}
