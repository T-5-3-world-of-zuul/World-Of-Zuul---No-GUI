public class DisasterHandler {
    private Enum disasterType;
    public DisasterHandler(Enum disasterType) {
        this.disasterType = disasterType;
    }

    public void SummonDrout() {
        this.disasterType = DisasterTypes.DROUT;
        System.out.println("Drout has been summoned! You have 10 minutes to prepare!");
    }

    public void SummonFlood() {
        this.disasterType = DisasterTypes.FLOOD;
        System.out.println("Flood has been summoned! You have 10 minutes to prepare!");
    }

    public void NutritionFailure() {
        this.disasterType = DisasterTypes.NUTRITION_FAILURE;
        System.out.println("You're crops aren't getting enough nutrition!");
    }

    public void SummonDesease() {
        this.disasterType = DisasterTypes.PLANT_DESEASE;
        System.out.println("summoned! You have 10 minutes to prepare!");
    }

    public void SummonGræshopper() {
        this.disasterType = DisasterTypes.locusts;
        System.out.println("summoned! You have 10 minutes to prepare!");
    }

    public void SummonLarver() {
        this.disasterType = DisasterTypes.LARVER;
        System.out.println("summoned! You have 10 minutes to prepare!");
    }

    public void hint() {
        switch (disasterType) {
            case DisasterTypes.DROUT:
                System.out.println("You need to water your crops!");
                break;
            case DisasterTypes.FLOOD:
                System.out.println("You need to build a dam!");
                break;
            case  DisasterTypes.NUTRITION_FAILURE:
                System.out.println("You need to fertilize your crops!");
                break;
            case DisasterTypes.PLANT_DESEASE, DisasterTypes.LARVER, DisasterTypes.locusts:
                System.out.println("You need to use pesticides!");
                break;
            default:
                System.out.println("You need to do something!");
                break;
        }
    }
}
