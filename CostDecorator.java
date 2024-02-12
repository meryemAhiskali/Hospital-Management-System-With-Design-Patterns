// decorator pattern
abstract class Treatment{
    String treatmentMethod = "Unknown";
    public String getTreatmentsMethod(){
        return treatmentMethod;
    }
    public abstract double Cost();
}

class Inspection extends Treatment{
    public Inspection(){
        this.treatmentMethod = this.getClass().getName();
    }

    //inspection cost
    public double Cost() {
        return 200;
    }
}

// condiment decorator
abstract class AdditionalTreatments extends Treatment{
    public abstract String getTreatmentsMethod();
}

