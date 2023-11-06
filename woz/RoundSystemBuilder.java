public class RoundSystemBuilder {
    private int round;
    private World world;
    private boolean isAwake;

    public void setRound(int round) {
        this.round = round;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public RoundSystemBuilder setIsAwake(boolean isAwake) {
        this.isAwake = isAwake;
        return this;
    }

    public void createRoundSystem() {
        new RoundSystem(round, world, isAwake);
    }
}


