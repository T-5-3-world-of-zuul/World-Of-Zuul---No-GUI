public class RundeSystem extends World {
    World world;
    RundeSystemBuilder builder;
    int round = 0;

    boolean isAwake;
    public RundeSystem(World world, int round, boolean isAwake) {
        this.isAwake = isAwake;
        this.world = world;
        this.round = round;
    }


    public World getWorld() {
        return world;
    }


    public void setIsAwake(boolean isAwake) {
        this.isAwake = isAwake;
    }

    public boolean getIsAwake() {
        return isAwake;
    }

    public int getRound() {
        return round;
    }
    public void setWorld(World world) {
        this.world = world;
    }
    public void setRound(int round) {
        this.round = round;
    }

    public void NextRound() {
        System.out.println("You've completed round " + round + ". Moving you to round " + round++);
        builder.setRound(round++);
        builder.createRundeSystem();
    }
}
