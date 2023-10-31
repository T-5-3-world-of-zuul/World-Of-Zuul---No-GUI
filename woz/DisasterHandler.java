public class DisasterHandler {
    private DisasterTypes disasterType;
    Player player;

    public DisasterHandler() {
        this.disasterType = null;
    }

    public void summonDisaster(DisasterTypes type, String message) {
        disasterType = type;
        System.out.println(message);
    }

    public void solveDisaster(int energyRequired) {
        if (player.getEnergy() < energyRequired) {
            System.out.println("You don't have enough energy to solve this disaster!");
        } else {
            player.removeEnergy(energyRequired);
            System.out.println("You solved the disaster!");
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
                summonDisaster(DisasterTypes.DROUGHT, "Drought has been summoned! You have 10 minutes to prepare!");
                break;
            case 2:
                summonDisaster(DisasterTypes.FLOOD, "Flood has been summoned! You have 10 minutes to prepare!");
                break;
            case 3:
                summonDisaster(DisasterTypes.HAIL, "Hailstorm is on the way. Prepare!");
                break;
            case 4:
                summonDisaster(DisasterTypes.PLANT_DESEASE, "A plant disease has been detected in your crops.");
                break;
            case 5:
                summonDisaster(DisasterTypes.locusts, "A swarm of locusts appeared around the field. Take precautions immediately.");
                break;
            case 6:
                summonDisaster(DisasterTypes.LARVER, "Some larvae have been observed on your grains. Get ready.");
                break;
            case 7:
                summonDisaster(DisasterTypes.NUTRITION_FAILURE, "Your crops aren't getting enough nutrition!");
                break;
            default:
                return "No disaster for this round";
        }
        return "Disaster type set for this round.";
    }
}
