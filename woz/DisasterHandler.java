public class DisasterHandler {
    Enum disasterType;
    private Player player;
    public DisasterHandler(Enum disasterType) {
        this.disasterType = disasterType;
    }


    public void SummonDrought() {
        this.disasterType = DisasterTypes.DROUGHT;
        System.out.println("Drought has been summoned! You have 10 minutes to prepare!");
    }

    public void SummonFlood() {
        this.disasterType = DisasterTypes.FLOOD;
        System.out.println("Flood has been summoned! You have 10 minutes to prepare!");
    }

    public void HailStorm(){
        this.disasterType = DisasterTypes.HAIL;
        System.out.println("Hailstorm is on way. Prepare!!!");
    }


    public void SummonDisease() {
        this.disasterType = DisasterTypes.PLANT_DESEASE;
        System.out.println("");
    }

    public void SummonLocusts() {
        this.disasterType = DisasterTypes.locusts;
        System.out.println("A swarm of locusts appeared around the field. Take precautions immediately.");
    }

    public void SummonLarvae() {
        this.disasterType = DisasterTypes.LARVER;
        System.out.println("Some larvae have been observed on your grains. Get ready");
    }

    public void NutritionFailure() {
        this.disasterType = DisasterTypes.NUTRITION_FAILURE;
        System.out.println("You're crops aren't getting enough nutrition!");
    }


    public void SolveDrought() {
        if(player.getEnergy() < 10) {
            System.out.println("You don't have enough energy to solve this disaster!");
        } else {
            player.removeEnergy(10);
            System.out.println("You solved the disaster!");
        }
    }
    public void SolveFlood() {
        if(player.getEnergy() < 10) {
            System.out.println("You don´t have enough energy to solve this disaster!");
        } else {
            player.removeEnergy(10);
            System.out.println("You solved the disaster!");
        }

    }
    public void SolveNutritionFailiure() {
        if(player.getEnergy() < 10) {
            System.out.println("You don´t have enough energy to solve this disaster!");
        } else {
            player.removeEnergy(10);
            System.out.println("You solved the disaster!");
        }

    }
    public void SolvePlantDisease() {
        if(player.getEnergy() < 10) {
            System.out.println("You don´t have enough energy to solve this disaster!");
        } else {
            player.removeEnergy(10);
            System.out.println("You solved the disaster!");
        }

    }
    public void SolveLocust() {
        if(player.getEnergy() < 10) {
            System.out.println("You don´t have enough energy to solve this disaster!");
        } else {
            player.removeEnergy(10);
            System.out.println("You solved the disaster!");
        }

    }
    public void SolveLarvae() {
        if(player.getEnergy() < 10) {
            System.out.println("You don´t have enough energy to solve this disaster!");
        } else {
            player.removeEnergy(10);
            System.out.println("You solved the disaster!");
        }

    }
    public void SolveHailStorm() {
        if(player.getEnergy() < 10) {
            System.out.println("You don´t have enough energy to solve this disaster!");
        } else {
            player.removeEnergy(10);
            System.out.println("You solved the disaster!");
        }

    }
    

    public void hint() {
        if(disasterType.equals(DisasterTypes.DROUGHT)) {
            System.out.println("You can build a pump for make it possible to raise water quickly. ");

        } else if(disasterType.equals(DisasterTypes.FLOOD)) {
            System.out.println("Building sand barriers around the farm field, may help you to solve the problem. ");

        } else if(disasterType.equals(DisasterTypes.HAIL)) {
            System.out.println("Anti-Hail nets is great idea to preserve your grains");
        } else if (disasterType.equals(DisasterTypes.LARVER)) {
            System.out.println("You can use pesticides to control larvae");

        } else if (disasterType.equals(DisasterTypes.locusts)) {
            System.out.println("Using a drone is great way to stop swarm of locusts");

        } else if (disasterType.equals(DisasterTypes.PLANT_DESEASE)) {
            System.out.println("Reduce the number of larvae that survive the winter by incorporating crop residues into the soil by plowing. " +
                    "This can help to break down the residues and reduce the number of larvae.");

        }else {
            System.out.println("NPK fertilizers may help enrich the soil");
        }

    }
}
