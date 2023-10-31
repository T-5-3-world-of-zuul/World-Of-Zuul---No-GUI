public class Player extends EnergySystem {
    String name;
    public Player(int maxEnergy, String name) {
        super(maxEnergy);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
