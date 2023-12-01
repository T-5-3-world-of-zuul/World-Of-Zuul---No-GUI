package src.game;

public class RoundSystem {
    public int round;
    private World world;
    public final boolean isAwake;
    public final DisasterHandler disasterHandler;
    public final PlayerEnergy player;

    public RoundSystem(int round, World world, boolean isAwake) {
        this.round = round;
        this.world = world;
        this.isAwake = isAwake;
        this.disasterHandler = new DisasterHandler();
        this.player = PlayerEnergy.getPlayer();
    }

    public void newRound() {
        if (round != 0) {
            //QuizRegistry.quiz.get(0).startQuiz();
            disasterHandler.solveDisaster();
            if (disasterHandler.isCurrentDisasterSolved()) {
                String outText = "You've completed round " + round + " with a score of " +
                        ScoreSystem.calculateScore(Game.context) + ", moving on to round: " + (round + 1);
                Game.getRegistry().setOutput(outText);
            } else {
                String outText = "You haven't completed your preparation for the upcoming disaster";
                Game.getRegistry().setOutput(outText);

                Game.context.makeDone();
            }
        } else {
            String outText = "You've completed round " + round + ". Moving on to " + (round + 1);
            Game.getRegistry().setOutput(outText);

        }

        setRound(++this.round);
        createRoundSystem();
        setWorld(this.world);
        player.setEnergy(player.getMaxEnergy());
        System.out.println("Welcome to round " + round + " You have " + player.getMaxEnergy() +
                " Energy, and the disaster for this round is: " + disasterHandler.getDisaster(round));
    }

    private void setRound(int round) {
        this.round = round;
    }


    public int getRound() {
        return this.round;
    }

    private void setWorld(World world) {
        this.world = world;
    }

    private void createRoundSystem() {
        new RoundSystem(round, world, isAwake);
    }
}