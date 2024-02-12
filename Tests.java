// Concrete command classes, they all implement ITestRequest command interface
// and also concrete decorator classes, they all extend AdditionalTreatments condiments decorator class


class CholesterolTest extends AdditionalTreatments implements ITestRequest {
    private Laborant laborant;
    private Treatment treatment;
    private Patient patient;
    private Doctor doctor;
    CholesterolTest(Laborant laborant, Treatment treatment,Patient patient,Doctor doctor) {
        this.laborant = laborant;
        this.treatment = treatment;
        this.patient=patient;
        this.doctor=doctor;
    }

    // implementation ITestRequest
    public void makeTest() {
        laborant.makeCholesterol(patient,doctor);
    }

    // overload from AdditionalTreatments
    public String getTreatmentsMethod(){
        return treatment.getTreatmentsMethod() + ", "+ this.getClass().getName();
    }

    public double Cost() {
        return 100 + treatment.Cost();
    }

}
class HormoneTest extends AdditionalTreatments implements ITestRequest {
    private Laborant laborant;
    private Treatment treatment;
    private Patient patient;
    private Doctor doctor;
    HormoneTest(Laborant laborant, Treatment treatment,Patient patient,Doctor doctor) {
        this.laborant = laborant;
        this.treatment = treatment;
        this.patient=patient;
        this.doctor=doctor;
    }

    // implementation ITestRequest
    public void makeTest() {
        laborant.makeHormoneTest(patient,doctor);
    }

    public double Cost() {
        return 160 + treatment.Cost();
    }
    // overload from AdditionalTreatments
    public String getTreatmentsMethod() {
        return treatment.getTreatmentsMethod() + ", "+ this.getClass().getName();
    }
}
class HemogramTest extends AdditionalTreatments implements ITestRequest {
    private Laborant laborant;
    private Treatment treatment;
    private Patient patient;
    private Doctor doctor;
    HemogramTest(Laborant laborant, Treatment treatment,Patient patient,Doctor doctor) {
        this.laborant = laborant;
        this.treatment = treatment;
        this.patient=patient;
        this.doctor=doctor;
    }

    // implementation ITestRequest
    public void makeTest() {
        laborant.makeHemogram(patient,doctor);
    }


    public double Cost() {
        return 170 + treatment.Cost();
    }
    // overload from AdditionalTreatments
    public String getTreatmentsMethod() {
        return treatment.getTreatmentsMethod() + ", "+ this.getClass().getName();
    }
}
class MRITest extends AdditionalTreatments implements ITestRequest {
    private Technician technician;
    private Treatment treatment;
    private Patient patient;
    private Doctor doctor;

    MRITest(Technician technician, Treatment treatment,Patient patient,Doctor doctor) {
        this.technician = technician;
        this.treatment = treatment;
        this.patient=patient;
        this.doctor=doctor;
    }


    // implementation ITestRequest
    public void makeTest() {
        this.technician.takeMRITest(patient,doctor);
    }

    public double Cost() {
        return 300 + treatment.Cost();
    }
    // overload from AdditionalTreatments
    public String getTreatmentsMethod() {
        return treatment.getTreatmentsMethod() + ", "+ this.getClass().getName();
    }
}
class XrayTest extends AdditionalTreatments implements ITestRequest {
     private Technician technician;
     private Treatment treatment;
     private Patient patient;
     private Doctor doctor;
    XrayTest(Technician technician, Treatment treatment,Patient patient,Doctor doctor) {
        this.technician = technician;
        this.treatment = treatment;
        this.patient=patient;
        this.doctor=doctor;
    }

    // implementation ITestRequest
    public void makeTest() {
        this.technician.takeAnXrayTest(patient,doctor);
    }

    public double Cost() {
        return 350 + treatment.Cost();
    }
    // overload from AdditionalTreatments
    public String getTreatmentsMethod() {
        return treatment.getTreatmentsMethod() + ", "+ this.getClass().getName();
    }
}
class EyeRadioTest extends AdditionalTreatments implements ITestRequest{
    private Radiologist radiologist;
    private Treatment treatment;
    private Patient patient;
    private Doctor doctor;
    public EyeRadioTest(Radiologist radiologist, Treatment treatment,Patient patient,Doctor doctor){
        this.radiologist = radiologist;
        this.treatment = treatment;
        this.patient=patient;
        this.doctor=doctor;
    }

    // implementation ITestRequest
    public void makeTest() {
        this.radiologist.takeEyeRadio(patient,doctor);
    }

    public double Cost() {
        return 75 + treatment.Cost();
    }
    // overload from AdditionalTreatments
    public String getTreatmentsMethod() {
        return treatment.getTreatmentsMethod() + ", "+ this.getClass().getName();
    }
}
