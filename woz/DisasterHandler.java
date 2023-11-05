public class DisasterHandler {
    private DisasterTypes disasterType;
    Player player = Player.getPlayer();

    boolean currentIssueSolved = false;

    public boolean getCurrentIssueSolved(){
        return currentIssueSolved;
    }
    public DisasterHandler() {
        this.disasterType = null;
    }

    public void summonDisaster(DisasterTypes type) {
        disasterType = type;

    }

    public void solveDisaster() {
        switch (disasterType) {
            case DROUGHT:
                //water pump installed if true
                if(World.getSpace("Well").itemsUsedInRoom.CheckForItem("water_pump") != null){
                    currentIssueSolved = true;
                }

                break;
            case FLOOD:

                break;
            case HAIL:

                break;
            case LARVER:

                break;
            case locusts:

                break;
            case PLANT_DESEASE:
                break;
        }
    }

    public void hint() {
        if (disasterType != null) {
            switch (disasterType) {
                case DROUGHT:
                    System.out.println("You can build a pump to raise water quickly.");
                    break;
                case FLOOD:
                    System.out.println("Building sand barriers around the farm field may help you solve the problem.");
                    break;
                case HAIL:
                    System.out.println("Using anti-Hail nets is a great idea to preserve your grains.");
                    break;
                case LARVER:
                    System.out.println("You can use pesticides to control larvae.");
                    break;
                case locusts:
                    System.out.println("Using a drone is a great way to stop a swarm of locusts.");
                    break;
                case PLANT_DESEASE:
                    System.out.println("Reduce the number of larvae that survive the winter by incorporating crop residues into the soil by plowing. This can help break down the residues and reduce the number of larvae.");
                    break;
                default:
                    System.out.println("NPK fertilizers may help enrich the soil.");
                    break;
            }
        } else {
            System.out.println("No disaster is currently active.");
        }
    }

    public String getDisaster(int round) {
        switch (round) {
            case 1:
                summonDisaster(DisasterTypes.DROUGHT);
                return "DROUGHT";
            case 2:
                summonDisaster(DisasterTypes.FLOOD);
                return "FLOOD";
            case 3:
                summonDisaster(DisasterTypes.HAIL);
                return "HAIL";
            case 4:
                summonDisaster(DisasterTypes.PLANT_DESEASE);
                return "PLANT DISEASE";
            case 5:
                summonDisaster(DisasterTypes.locusts);
                return "LOCUST SWARMS";
            case 6:
                summonDisaster(DisasterTypes.LARVER);
                return "LARVAE";
            case 7:
                summonDisaster(DisasterTypes.NUTRITION_FAILURE);
                return "NUTRITION FAILURE";
            default:
                return "No disaster for this round";
        }


    }
}
