import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.UUID;

class Person{
    public final String id;
    public String name;
    public String surname;
    private UUID uuid = UUID.randomUUID();
    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.id = uuid.toString();
    }
    public String getFullName(){
        return this.name+" "+this.surname;
    }
    @Override
    public String toString() {
        return getClass().getName()+" : "+this.name+"\t"+this.surname;
    }
}
class Patient extends Person implements Observer{
    LinkedList<Treatment> treatmentServices = new LinkedList<>();
    private Appointment appointment = Appointment.getAppointment();
    public Patient(String name, String surname){
        super(name,surname);
        this.treatmentServices = new LinkedList<>();
    }

    public void addAppointment(LocalDate date, LocalTime time, Doctor doctor) {
        AppointmentModel appointmentModel = new AppointmentModel(this.id,this.getFullName(),date,time,doctor);
            this.appointment.appointments.add(appointmentModel);
            doctor.addPatient(this);
    }
    public void removeAppointment(AppointmentModel appointment) {
            if (this.appointment.appointments.remove(appointment)) {
                System.out.println("Appointment removed: " + appointment.fullName);
            } else {
                System.out.println("Appointment not found!");
            }
            appointment.doctor.removePatient(this);
        }

    @Override //from Observer interface
    public void updateAppointmentState(String message) {
        System.out.println("Appointment " +  message +" for "+this.getFullName());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
class Doctor extends Person implements Subject{
    public Department department;
    public LinkedList<Patient> patients = new LinkedList<>();
    public Doctor(String name, String surname, Department department){
        super(name, surname);
        this.department = department;
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }
    public void removePatient(Patient patient){
        patients.remove(patient);
    }

    public void addTreatment(Patient patient, Treatment treatment){
        patient.treatmentServices.add(treatment);
    }
    public void CancelAppointments(String message){
        notifyPatient(message);
        patients.clear();
    }
    //from Observer interface to notify patient when the appointments are cancelled.
    @Override
    public void notifyPatient(String message) {
        for (Patient patient : patients) {
            patient.updateAppointmentState(message);
        }
    }
    @Override
    public String toString() {
        String patients = "";
        for (Patient patient : this.patients)
        {
            patients += "Patient : " + patient.name+" "+patient.surname;
        }
        return super.toString()+"\n"+
                "The\t"+getClass().getName()+"'s department is\t"+this.department.toString()+"\n"
                +patients;
    }
}
// invoker for TestCommand
class Nurse extends Person{
    public Department department;
    private LinkedList<ITestRequest> testRequests = new LinkedList<>();
    private ITestRequest testRequest;

    public Nurse(String name, String surname, Department department){
        super(name,surname);
        this.department = department;
    }

    // nurse is invoker for command pattern implementation
    void setTests(ITestRequest testRequest){
        this.testRequest = testRequest;
        testRequests.add(testRequest);
    }

    void sendTest(){
        this.testRequest.makeTest();
    }

    @Override
    public String toString() {
        String tests = "";
        for (ITestRequest testRequest : testRequests)
        {
            tests += testRequest.getClass().getName() + "\trequest is done\n";
        }
        return super.toString()+"\n"+
                "The\t"+getClass().getName()+"'s department is\t"+this.department+"\n"
                +tests;
    }
}
// reciever for TestCommand
class Laborant extends Person{

    public Laborant(String name, String surname) {
        super(name, surname);
    }

    public void makeCholesterol(Patient patient,Doctor doctor) {
        System.out.println("Cholesterol test requested by " +doctor.getFullName()+ "taken for "+ patient.getFullName()+ " and reported.");
    }
    public void makeHormoneTest(Patient patient,Doctor doctor) {
        System.out.println("Hormone test requested by "+doctor.getFullName()+ " taken for" +patient.getFullName()+" and reported.");
    }
    public void makeHemogram(Patient patient,Doctor doctor) {
        System.out.println("Hemogram test requested by "+doctor.getFullName()+ " taken for" +patient.getFullName()+" and reported.");
    }
}
// reciever for TestCommand
class Technician extends Person{

    public Technician(String name, String surname) {
        super(name, surname);
    }

     public void takeMRITest(Patient patient,Doctor doctor){
        System.out.println("MRI request by "+doctor.getFullName()+" taken for" +patient.getFullName()+" and reported.");
    }
    public void takeAnXrayTest(Patient patient,Doctor doctor){
        System.out.println("X-Ray request by "+doctor.getFullName()+" taken for "+patient.getFullName()+" and reported.");
    }

}
// reciever for TestCommand
class Radiologist extends Person{

    public Radiologist(String name, String surname) {
        super(name, surname);
    }

    public void takeEyeRadio(Patient patient, Doctor doctor) {
        System.out.println("Eye radio requested by "+doctor.getFullName()+" taken for "+patient.getFullName()+" and reported");
    }
}
