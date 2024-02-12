import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentModel {
    public String patientId;
    public String fullName;
    public LocalDate date;
    public LocalTime time;
    public Doctor doctor;

    public AppointmentModel(String patientId, String fullName, LocalDate date,
                            LocalTime time, Doctor doctor){
        this.patientId = patientId;
        this.fullName = fullName;
        this.date=date;
        this.time = time;
        this.doctor = doctor;
    }
}
