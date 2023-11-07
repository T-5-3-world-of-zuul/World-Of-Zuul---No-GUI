public class Player extends EnergySystem {
    String name;

    static Player player = new Player(100, "Player 1");

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

    @Override
    public int getEnergy() {
        return super.getEnergy();
    }

    @Override
    public int getMaxEnergy() {
        return super.getMaxEnergy();
    }

    public static Player getPlayer(){
        return player;
    }
}
