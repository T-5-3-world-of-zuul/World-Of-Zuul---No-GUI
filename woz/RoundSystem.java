public class RoundSystem extends World {
    World world;
    RoundSystemBuilder builder;
    DisasterHandler disasterHandler;
    Player player;
    int round;
    boolean isAwake;
    public RoundSystem(int round, World world, boolean isAwake) {
        this.round = round;
        this.world = world;
        this.isAwake = isAwake;
    }

    public void newRound() {
        System.out.println("You've completed round " + round + ". Moving on to "+ round++);
        builder.setRound(round++);
        builder.createRoundSystem();
        builder.setWorld(this.world);
        System.out.println("Welcome to round " + round + " You have + " + player.getEnergy() + " Left, and the disaster for this round is: " + disasterHandler.getDisaster(round));
    }
}
