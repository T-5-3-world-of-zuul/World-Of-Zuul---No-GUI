public class RundeSystemBuilder {
    private World world;
    private int round;
    private boolean isAwake;

    public RundeSystemBuilder setWorld(World world) {
        this.world = world;
        return this;
    }

    public RundeSystemBuilder setRound(int round) {
        this.round = round;
        return this;
    }

    public RundeSystemBuilder setIsAwake(boolean isAwake) {
        this.isAwake = isAwake;
        return this;
    }

    public RundeSystem createRundeSystem() {
        return new RundeSystem(world, round, isAwake);
    }
}