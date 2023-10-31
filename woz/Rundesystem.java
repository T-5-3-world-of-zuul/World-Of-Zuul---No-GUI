public class Rundesystem {
    boolean isSleeping = false;

    public Rundesystem(boolean isSleeping) {
        this.isSleeping = isSleeping;


    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean sleeping) {
        isSleeping = sleeping;
    }
    public  void nextRound() {
        System.out.println("Next round called");
    }
}
