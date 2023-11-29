package src.game;

public class ScoreSystem {
    static int score;
    private int bestEnergyUsedCurrentRound;
    static PlayerEnergy player = PlayerEnergy.getPlayer();


    public int getScore() {
        return score;
    }

    /**
     * The calculateScore function takes in two src.game.PlayerAction objects, the first being the action that was taken by a player
     * and the second being an action that would have been more effective. The function then calculates how much better or worse
     * off a player is for taking their chosen action instead of what would have been more effective. This score is returned as an int.
     *
     *
     */
    public int calculateScore(Context context) {
        switch (context.getRoundSystem().round){
            case 0:
                bestEnergyUsedCurrentRound = 0;
                break;
            case 1:
                bestEnergyUsedCurrentRound = 10;
                break;
            case 2,3,4,5,6:
                bestEnergyUsedCurrentRound = 20;
                break;
        }

        int energyDifference =  bestEnergyUsedCurrentRound - (player.getMaxEnergy() - player.getEnergy());

        score += energyDifference + 100;
        return score;
    }
}
