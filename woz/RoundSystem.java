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

        builder = new RoundSystemBuilder();
        player = Player.getPlayer();
        disasterHandler = new DisasterHandler();

    }

    public void newRound() {
        if(round != 0){
            QuizRegistry.quiz.get(0).startQuiz();
            disasterHandler.solveDisaster();
            if (disasterHandler.getCurrentIssueSolved()){

                System.out.println("You've completed round " + round + " with a score of "+ScoreSystem.calculateScore(Game.context)+ ", moving on to round : "+(round+1));
                builder.setRound(round++);
                builder.createRoundSystem();
                builder.setWorld(this.world);
                player.setEnergy(player.getMaxEnergy());
                System.out.println("Welcome to round " + round + " You have + " + player.getEnergy() + " Energy ,and the disaster for this round is: " + disasterHandler.getDisaster(round));
            } else{
                System.out.println("You haven't completed your preparation for the upcoming disaster");
                Game.context.done = true;
            }
        } else{
            System.out.println("You've completed round " + round + ". Moving on to "+ (round+1));
            builder.setRound(round++);
            builder.createRoundSystem();
            builder.setWorld(this.world);
            player.setEnergy(player.getMaxEnergy());
            System.out.println("Welcome to round " + round + " You have " + player.getEnergy() + " Energy,and the disaster for this round is: " + disasterHandler.getDisaster(round));
        }


    }
}
