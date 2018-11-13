
public class Main {
    public static void main(String[] args) {
        Chopstick[] chopsticks = new Chopstick[5];
        Checker detector = new Checker();
        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Chopstick(1);
            Thread p = new Philosopher(i, chopsticks, detector);
            p.start();
        }
    }

}
