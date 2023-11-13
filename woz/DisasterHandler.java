public class DisasterHandler {
    private DisasterType type;
    public enum DisasterType {
        DROUGHT, FLOOD, HAIL, LARVAE, LOCUST_SWARMS, PLANT_DISEASE, NUTRITION_FAILURE
    }

    public DisasterHandler() {
        this.type = null;
    }

    public boolean currentDisasterSolved = false;

    public boolean isCurrentDisasterSolved() {
        return currentDisasterSolved;
    }

    public void summonDisaster(DisasterType t, String disasterName) {
        this.type = t;
        System.out.println(disasterName + " has been summoned");
    }

    public void solveDisaster() {
        switch (type) {
            case DROUGHT:
                if(World.getSpace("Well").itemsUsedInRoom.CheckForItem("water_pump") != null){
                    currentDisasterSolved = true;
                }
                break;
            case FLOOD:
                Item sandbagField1 = World.getSpace("Field 1").itemsUsedInRoom.CheckForItem("sandbag");
                Item sandbagField2 = World.getSpace("Field 2").itemsUsedInRoom.CheckForItem("sandbag");
                Item sandbagField3 = World.getSpace("Field 3").itemsUsedInRoom.CheckForItem("sandbag");
                if(sandbagField1 != null && sandbagField2 != null && sandbagField3 != null){
                    currentDisasterSolved = true;
                }
                break;
            case HAIL:

                break;
            case LARVAE:

                break;
            case LOCUST_SWARMS:

                break;
            case PLANT_DISEASE:
                break;
        }
    }

    public String getDisaster(int round) {
        switch (round) {
            case 1:
                this.type = DisasterType.DROUGHT;
                summonDisaster(DisasterType.DROUGHT, "DROUGHT");
                return "DROUGHT";
            case 2:
                this.type = DisasterType.FLOOD;
                summonDisaster(DisasterType.FLOOD, "Flood");
                return "FLOOD";
            case 3:
                this.type = DisasterType.HAIL;
                summonDisaster(DisasterType.HAIL, "Hail");
                return "HAIL";
            case 4:
                this.type = DisasterType.DROUGHT;
                summonDisaster(DisasterType.PLANT_DISEASE, "Plant Disease");
                return "PLANT DISEASE";
            case 5:
                this.type = DisasterType.LOCUST_SWARMS;
                summonDisaster(DisasterType.LOCUST_SWARMS, "Locust Swarms");
                return "LOCUST SWARMS";
            case 6:
                this.type = DisasterType.LARVAE;
                summonDisaster(DisasterType.LARVAE, "Larvae");
                return "LARVAE";
            case 7:
                this.type = DisasterType.NUTRITION_FAILURE;
                summonDisaster(DisasterType.NUTRITION_FAILURE, "Nutrition Failure");
                return "NUTRITION FAILURE";
            default:
                return "Failed to summon disaster";
        }
    }
    public void hint(int round) {
        String hints = switch (type) {
            case DROUGHT -> "You need to install a water pump in the well";
            case FLOOD -> "You need to place sandbags in all fields";
            case HAIL -> "You need to install a hail net";
            case LARVAE -> "You can use pesticides to control larvae.";
            case LOCUST_SWARMS -> "Using a drone is a great way to stop a swarm of locusts.";
            case PLANT_DISEASE -> "Reduce the number of larvae that survive the winter by incorporating crop residues into the soil by plowing. This can help break down the residues and reduce the number of larvae.";
            default -> "NPK fertilizers may help enrich the soil.";
        };

        // Check if the round is within the valid range of hints
        if (round >= 0 && round < hints.length()) {
            System.out.println(hints);
        } else {
            System.out.println("No specific hint available for this round.");
        }
    }
}
