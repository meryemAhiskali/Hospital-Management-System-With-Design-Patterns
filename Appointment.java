import java.util.LinkedList;

//singleton pattern

class Appointment{
    //to hold our one instance of appointment class
    private static Appointment uniqueAppointment =new Appointment();
    public LinkedList<AppointmentModel> appointments = new LinkedList<>();
    private Appointment(){}
    public static Appointment getAppointment(){
        return uniqueAppointment;
    }

    //to dispalys all appointments
    public void displayAppointments() {
        System.out.println("Appointments:");
        for (AppointmentModel appointment : appointments) {
            System.out.println(appointment.fullName);
        }
    }
}