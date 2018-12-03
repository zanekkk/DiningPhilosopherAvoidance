public class Checker {
    //Banker's Algorithm

    private boolean forks[];
    private boolean knives[];
    private int serviceNumber; // this is number of forks and knives

    private boolean eating[] = new boolean[5];


    public Checker(int knivesNumber, int forkNumber) {
        this.forks = new boolean[knivesNumber];
        this.knives = new boolean[forkNumber];
        this.serviceNumber = knivesNumber + forkNumber;
        for(boolean knive : knives){
            knive = false;
        }
        for(boolean fork : forks){
            fork = false;
        }

        for(boolean eat: eating){
            eat = false;
        }

    }


    public void setForksPickedUp(int number, boolean pickedUp) {
        this.forks[number] = pickedUp;
    }
    public void setKnivesPickedUp(int number, boolean pickedUp) {
        this.knives[number] = pickedUp;
    }

    public int getNumberOfFreeFork() {
        int number = -1;
        for (int i = 0; i < forks.length; i++) {
            if (forks[i] == false ) {
                number = i;
                return number;
            }
        }
        return number;
    }

    public int getNumberOfFreeKnives() {
        int number = -1;
        for (int i = 0; i < knives.length; i++) {
            if (knives[i] == false) {
                number = i;
                return number;
            }
        }
        return number;
    }


    public void setEating(int number, boolean eating) {
        this.eating[number] = eating;
    }

    public boolean checkSafety(int forkNumber,int kniveNumber, boolean pick) {
        int i = 0;
        if (kniveNumber > -1 && forkNumber > -1) {
            this.forks[forkNumber] = pick;

        this.knives[kniveNumber] = pick;
        }else {return false;}

        for (boolean picked : forks) {
            if (picked) {
                i++;
            }
        }
        for (boolean picked : knives) {
            if (picked) {
                i++;
            }
        }
        for (boolean eat : eating) {
            if (!eat) {
                i++;
            }
        }

        if (i == serviceNumber + 5) {
            return false;
        }

        return true;

    }
}




