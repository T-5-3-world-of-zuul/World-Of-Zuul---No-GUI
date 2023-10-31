public class RundeSystemBuilder {
    private World world;
    private int round;
    private boolean isAwake;

    public RundeSystemBuilder setWorld(World world) {
        this.world = world;
        return this;
    }

    public void setRound(int round) {
        this.round = round;
    }


    public RundeSystemBuilder setIsAwake(boolean isAwake) {
        this.isAwake = isAwake;
        return this;
    }

    public void createRundeSystem() {
        new RundeSystem(world, round, isAwake);
    }
}