package src.game;

public class PlayerEnergy {
    private String name;
    private int maxEnergy;
    private int energy;
    static PlayerEnergy player = new PlayerEnergy(100, "Player 1");


    public PlayerEnergy(int maxEnergy, String name) {
        this.maxEnergy = maxEnergy;
        this.energy = maxEnergy;
        this.name = name;
    }

    public int getEnergy() {
        return this.energy;
    }

    public int getMaxEnergy() {
        return this.maxEnergy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public void addEnergy(int energy) {
        this.energy += energy;
        if (this.energy > this.maxEnergy) {
            this.energy = this.maxEnergy;
        }
    }

    public void removeEnergy(int energy) {
        this.energy -= energy;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }

    public boolean isOutOfEnergy() {
        return this.energy == 0;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PlayerEnergy getPlayer(){
        return player;
    }
}
