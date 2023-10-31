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
        this.disasterType = DisasterTypes.Græshoppesværme;
        System.out.println("summoned! You have 10 minutes to prepare!");
    }

    public void SummonLarver() {
        this.disasterType = DisasterTypes.Græshoppesværme;
        System.out.println("summoned! You have 10 minutes to prepare!");
    }
}
