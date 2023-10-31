public class EnergySystem {
    private int energy;
    private int maxEnergy;
    public EnergySystem(int maxEnergy) {
        this.maxEnergy = maxEnergy;
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

    public  boolean isOutOfEnergy() {
        return this.energy == 0;
    }
}
