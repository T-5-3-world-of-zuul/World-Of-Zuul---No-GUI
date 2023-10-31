public enum PlayerAction {
    PLANT("Plant", 10, 1),
    WATER("Water", 5, 0),
    HARVEST("Harvest", 15, 0);

    private String actionName;
    private int energyUsed;
    private int resourceConsumed;

    PlayerAction(String actionName, int energyUsed, int resourceConsumed) {
        this.actionName = actionName;
        this.energyUsed = energyUsed;
        this.resourceConsumed = resourceConsumed;
    }

    public String getActionName() {
        return actionName;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }

    public int getResourceConsumed() {
        return resourceConsumed;
    }

    public int getEnergyRequired(PlayerAction playerAction) {
        int energyRequired = 0;

        switch (playerAction) {
            case PLANT:
                energyRequired = 10;
                break;
            case WATER:
                energyRequired = 5;
                break;
            case HARVEST:
                energyRequired = 15;
                break;
            default:
                System.out.println("Unknown action Please use " + PlayerAction.values().toString());
                break;
        }

        return energyRequired;
    }
}
