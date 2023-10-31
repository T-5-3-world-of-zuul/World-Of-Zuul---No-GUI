public class ScoreSystem extends EnergySystem {
    private final int score;
    public ScoreSystem(int maxEnergy, int score) {
        super(maxEnergy);
        this.score = score;
    }


    public int getScore() {
        return this.score;
    }

    /**
     * The calculateScore function takes in two PlayerAction objects, the first being the action that was taken by a player
     * and the second being an action that would have been more effective. The function then calculates how much better or worse
     * off a player is for taking their chosen action instead of what would have been more effective. This score is returned as an int.

     *
     * @param PlayerAction playerAction Determine the energy used by the player
     * @param PlayerAction mostEffectiveAction Compare the energy used by the player action to the energy required for most effective action
     *
     * @return The difference between the energy required for the most effective action
     *
     */
    public int calculateScore(PlayerAction playerAction, PlayerAction mostEffectiveAction) {
        int score = 0;
        int energyDifference = mostEffectiveAction.getEnergyRequired(playerAction) - playerAction.getEnergyUsed();
        if (energyDifference > 0) {
            score += energyDifference;
        } else {
            score -= Math.abs(energyDifference);
        }
        return score;
    }
}
