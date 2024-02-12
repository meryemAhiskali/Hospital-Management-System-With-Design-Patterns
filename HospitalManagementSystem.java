import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) throws Exception {

        Doctor doctorDeniz = new Doctor("Deniz","Lale",Department.RADIOLOGY);
        Doctor doctorElif = new Doctor("Elif","Kaya",Department.ORTHOPEDICS);
        Doctor doctorCan = new Doctor("Can","Demir",Department.INTERNAL_MEDICINE);
        Patient patientToprak = new Patient("Toprak","Korkmaz");
        Patient patientEmre = new Patient("Emre","Polat");
        Patient patientSıla = new Patient("Sıla","Korkmaz");
        Patient patientBuse = new Patient("Buse","Can");
        Patient patientCeren = new Patient("Ceren","Ayna");
        Patient patientAlp = new Patient("Alp","Best");
        Nurse nurse = new Nurse("Aylin","Aksu",Department.RADIOLOGY);
        Radiologist radiologist = new Radiologist("Furkan","Kaan");
        Technician technician = new Technician("Saygı","Atmaca");
        Laborant laborant = new Laborant("Feride","Ekici");
        Treatment treatment = new Inspection();

        //patient of Dr Deniz
        patientEmre.addAppointment(LocalDate.of(2023, 12, 28), LocalTime.of(14, 00), doctorDeniz);
        patientToprak.addAppointment(LocalDate.of(2023, 12, 20), LocalTime.of(14, 30), doctorDeniz);

        //patient of Dr Elif
        patientSıla.addAppointment(LocalDate.of(2023, 12, 22), LocalTime.of(14, 00), doctorElif);
        patientBuse.addAppointment(LocalDate.of(2023, 12, 21), LocalTime.of(14, 00), doctorElif);


        //patient of Dr Can
        patientCeren.addAppointment(LocalDate.of(2023, 12, 25), LocalTime.of(14, 00), doctorCan);
        patientAlp.addAppointment(LocalDate.of(2023, 12, 27), LocalTime.of(14, 00), doctorCan);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("*********************************");
            System.out.println("Welcome to the system");
            System.out.println("*********************************");
            System.out.println("* 1 - Doctor's Login             *");
            System.out.println("* 2 - View Customer's Invoice    *");
            System.out.println("* 3 - Display All Appointments   *");
            System.out.println("* 0 - Quit                       *");
            System.out.println("*********************************");
            System.out.println("Please make a selection: ");

            int firstChoice = scanner.nextInt();
            if (firstChoice==1)
            {
                System.out.println("*********************************");
                System.out.println("Doctor's Login");
                System.out.println("*********************************");
                System.out.println("* 1 - Doctor Deniz               *");
                System.out.println("* 2 - Doctor Elif                *");
                System.out.println("* 3 - Doctor Can                 *");
                System.out.println("* 0 - Quit                       *");
                System.out.println("*********************************");
                System.out.println("Please make a selection: ");

                int doctorSelection = scanner.nextInt();

                if (doctorSelection == 1) { //Dr Deniz
                    System.out.println("*********************************");
                    System.out.println("* 1 - Request Test              *");
                    System.out.println("* 2 - Cancel Appointment        *");
                    System.out.println("*********************************");
                    System.out.println("Please make a selection: ");

                    int doctorChoice = scanner.nextInt();

                    if (doctorChoice==1)
                    {
                        System.out.println("*********************************");
                        System.out.println("**      Medical Test Options   **");
                        System.out.println("*********************************");
                        System.out.println("** 1 - Cholesterol Test        **");
                        System.out.println("** 2 - EyeRadio Test           **");
                        System.out.println("** 3 - Hemogram Test           **");
                        System.out.println("** 4 - Hormone Test            **");
                        System.out.println("** 5 - MRI Test                **");
                        System.out.println("** 6 - X-ray Test              **");
                        System.out.println("** Choose the test you want:   **");
                        System.out.println("*********************************");


                        int choice = scanner.nextInt();
                        if (choice == 1) { //cholesterol
                            for (Patient p : doctorDeniz.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");
                            String name = scanner.next();
                            if (name.equals("Emre")) {
                                CholesterolTest cholesterolTest = new CholesterolTest(laborant, treatment, patientEmre, doctorDeniz);
                                doctorDeniz.addTreatment(patientEmre, cholesterolTest);
                                nurse.setTests(cholesterolTest);
                                nurse.sendTest();
                            } else if (name.equals("Toprak")) {
                                CholesterolTest cholesterolTest = new CholesterolTest(laborant, treatment, patientToprak, doctorDeniz);
                                doctorDeniz.addTreatment(patientToprak, cholesterolTest);
                                nurse.setTests(cholesterolTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else if (choice == 2) {//eye radio
                            for (Patient p : doctorDeniz.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Emre")) {
                                EyeRadioTest eyeRadioTest = new EyeRadioTest(radiologist, treatment, patientEmre, doctorDeniz);
                                doctorDeniz.addTreatment(patientEmre, eyeRadioTest);
                                nurse.setTests(eyeRadioTest);
                                nurse.sendTest();
                            } else if (name.equals("Toprak")) {
                                EyeRadioTest eyeRadioTest = new EyeRadioTest(radiologist, treatment, patientToprak, doctorDeniz);
                                doctorDeniz.addTreatment(patientToprak, eyeRadioTest);
                                nurse.setTests(eyeRadioTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }


                        } else if (choice == 3) {//hemogram
                            for (Patient p : doctorDeniz.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Emre")) {
                                HemogramTest hemogramTest = new HemogramTest(laborant, treatment, patientEmre, doctorDeniz);
                                doctorDeniz.addTreatment(patientEmre, hemogramTest);
                                nurse.setTests(hemogramTest);
                                nurse.sendTest();
                            } else if (name.equals("Toprak")) {
                                HemogramTest hemogramTest = new HemogramTest(laborant, treatment, patientToprak, doctorDeniz);
                                doctorDeniz.addTreatment(patientToprak, hemogramTest);
                                nurse.setTests(hemogramTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else if (choice == 4) {//hormone
                            for (Patient p : doctorDeniz.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Emre")) {
                                HormoneTest hormoneTest = new HormoneTest(laborant, treatment, patientEmre, doctorDeniz);
                                doctorDeniz.addTreatment(patientEmre, hormoneTest);
                                nurse.setTests(hormoneTest);
                                nurse.sendTest();
                            } else if (name.equals("Toprak")) {
                                HormoneTest hormoneTest = new HormoneTest(laborant, treatment, patientToprak, doctorDeniz);
                                doctorDeniz.addTreatment(patientToprak, hormoneTest);
                                nurse.setTests(hormoneTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else if (choice == 5) {//MRI
                            for (Patient p : doctorDeniz.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Emre")) {
                                MRITest mriTest = new MRITest(technician, treatment, patientEmre, doctorDeniz);
                                doctorDeniz.addTreatment(patientEmre, mriTest);
                                nurse.setTests(mriTest);
                                nurse.sendTest();
                            } else if (name.equals("Toprak")) {
                                MRITest mriTest = new MRITest(technician, treatment, patientToprak, doctorDeniz);
                                doctorDeniz.addTreatment(patientToprak, mriTest);
                                nurse.setTests(mriTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }
                        } else if (choice == 6) {//Xray
                            for (Patient p : doctorDeniz.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Emre")) {
                                XrayTest xrayTest = new XrayTest(technician, treatment, patientEmre, doctorDeniz);
                                doctorDeniz.addTreatment(patientEmre, xrayTest);
                                nurse.setTests(xrayTest);
                                nurse.sendTest();
                            } else if (name.equals("Toprak")) {
                                XrayTest xrayTest = new XrayTest(technician, treatment, patientToprak, doctorDeniz);
                                doctorDeniz.addTreatment(patientToprak, xrayTest);
                                nurse.setTests(xrayTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else {
                            System.out.println("Invalid choice");
                        }
                    }
                    else if(doctorChoice==2)
                    {
                        System.out.println("Enter your message: ");
                        String message= scanner.next();
                        doctorDeniz.CancelAppointments(message);

                    }
                    else{
                        System.out.println("Invalid choice");
                    }


                }
                else if (doctorSelection == 2)
                {//elif doktor
                    System.out.println("*********************************");
                    System.out.println("* 1 - Request Test              *");
                    System.out.println("* 2 - Cancel Appointment        *");
                    System.out.println("*********************************");
                    System.out.println("Please make a selection: ");
                    int doctorChoice = scanner.nextInt();
                    if (doctorChoice==1)
                    {

                        System.out.println("*********************************");
                        System.out.println("**     Medical Test Options    **");
                        System.out.println("*********************************");
                        System.out.println("** 1 - Cholesterol Test       **");
                        System.out.println("** 2 - EyeRadio Test          **");
                        System.out.println("** 3 - Hemogram Test          **");
                        System.out.println("** 4 - Hormone Test           **");
                        System.out.println("** 5 - MRI Test               **");
                        System.out.println("** 6 - X-ray Test             **");
                        System.out.println("*********************************");
                        System.out.println("Choose the test you want: ");

                        int choice = scanner.nextInt();
                        if (choice == 1) { //cholesterol
                            for (Patient p : doctorElif.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Sıla")) {
                                CholesterolTest cholesterolTest = new CholesterolTest(laborant, treatment, patientSıla, doctorElif);
                                doctorElif.addTreatment(patientSıla, cholesterolTest);
                                nurse.setTests(cholesterolTest);
                                nurse.sendTest();
                            } else if (name.equals("Buse")) {
                                CholesterolTest cholesterolTest = new CholesterolTest(laborant, treatment, patientBuse, doctorElif);
                                doctorElif.addTreatment(patientBuse, cholesterolTest);
                                nurse.setTests(cholesterolTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else if (choice == 2) {//eye radio
                            for (Patient p : doctorElif.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Sıla")) {
                                EyeRadioTest eyeRadioTest = new EyeRadioTest(radiologist, treatment, patientSıla, doctorElif);
                                doctorElif.addTreatment(patientSıla, eyeRadioTest);
                                nurse.setTests(eyeRadioTest);
                                nurse.sendTest();
                            } else if (name.equals("Buse")) {
                                EyeRadioTest eyeRadioTest = new EyeRadioTest(radiologist, treatment, patientBuse, doctorElif);
                                doctorElif.addTreatment(patientBuse, eyeRadioTest);
                                nurse.setTests(eyeRadioTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }


                        } else if (choice == 3) {//hemogram
                            for (Patient p : doctorElif.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Sıla")) {
                                HemogramTest hemogramTest = new HemogramTest(laborant, treatment, patientSıla, doctorElif);
                                doctorElif.addTreatment(patientSıla, hemogramTest);
                                nurse.setTests(hemogramTest);
                                nurse.sendTest();
                            } else if (name.equals("Buse")) {
                                HemogramTest hemogramTest = new HemogramTest(laborant, treatment, patientBuse, doctorElif);
                                doctorElif.addTreatment(patientBuse, hemogramTest);
                                nurse.setTests(hemogramTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else if (choice == 4) {//hormone
                            for (Patient p : doctorElif.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Sıla")) {
                                HormoneTest hormoneTest = new HormoneTest(laborant, treatment, patientSıla, doctorElif);
                                doctorElif.addTreatment(patientSıla, hormoneTest);
                                nurse.setTests(hormoneTest);
                                nurse.sendTest();
                            } else if (name.equals("Buse")) {
                                HormoneTest hormoneTest = new HormoneTest(laborant, treatment, patientBuse, doctorElif);
                                doctorElif.addTreatment(patientBuse, hormoneTest);
                                nurse.setTests(hormoneTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else if (choice == 5) {//MRI
                            for (Patient p : doctorDeniz.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Sıla")) {
                                MRITest mriTest = new MRITest(technician, treatment, patientSıla, doctorElif);
                                doctorElif.addTreatment(patientSıla, mriTest);
                                nurse.setTests(mriTest);
                                nurse.sendTest();
                            } else if (name.equals("Buse")) {
                                MRITest mriTest = new MRITest(technician, treatment, patientBuse, doctorElif);
                                doctorElif.addTreatment(patientBuse, mriTest);
                                nurse.setTests(mriTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }
                        } else if (choice == 6) {//Xray
                            for (Patient p : doctorDeniz.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Sıla")) {
                                XrayTest xrayTest = new XrayTest(technician, treatment, patientSıla, doctorElif);
                                doctorElif.addTreatment(patientSıla, xrayTest);
                                nurse.setTests(xrayTest);
                                nurse.sendTest();
                            } else if (name.equals("Buse")) {
                                XrayTest xrayTest = new XrayTest(technician, treatment, patientBuse, doctorElif);
                                doctorElif.addTreatment(patientBuse, xrayTest);
                                nurse.setTests(xrayTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else {
                            System.out.println("Invalid choice");
                        }

                    }
                    else if(doctorChoice==2)
                    {

                        System.out.println("Enter your message: ");
                        String message= scanner.next();

                        doctorElif.CancelAppointments(message);
                    }
                }
                else if (doctorSelection == 3)
                { //Dr Can
                    System.out.println("*********************************");
                    System.out.println("* 1 - Request Test              *");
                    System.out.println("* 2 - Cancel Appointment        *");
                    System.out.println("*********************************");
                    System.out.println("Please make a selection: ");

                    int doctorChoice = scanner.nextInt();

                    if (doctorChoice==1)
                    {

                        System.out.println("*********************************");
                        System.out.println("**     Medical Test Options    **");
                        System.out.println("*********************************");
                        System.out.println("** 1 - Cholesterol Test       **");
                        System.out.println("** 2 - EyeRadio Test          **");
                        System.out.println("** 3 - Hemogram Test          **");
                        System.out.println("** 4 - Hormone Test           **");
                        System.out.println("** 5 - MRI Test               **");
                        System.out.println("** 6 - X-ray Test             **");
                        System.out.println("*********************************");
                        System.out.println("Choose the test you want: ");


                        int choice = scanner.nextInt();
                        if (choice == 1) { //cholesterol
                            for (Patient p : doctorCan.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Alp")) {
                                CholesterolTest cholesterolTest = new CholesterolTest(laborant, treatment, patientAlp, doctorCan);
                                doctorCan.addTreatment(patientAlp, cholesterolTest);
                                nurse.setTests(cholesterolTest);
                                nurse.sendTest();
                            } else if (name.equals("Ceren")) {
                                CholesterolTest cholesterolTest = new CholesterolTest(laborant, treatment, patientCeren, doctorCan);
                                doctorCan.addTreatment(patientCeren, cholesterolTest);
                                nurse.setTests(cholesterolTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else if (choice == 2) {//eye radio
                            for (Patient p : doctorCan.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Alp")) {
                                EyeRadioTest eyeRadioTest = new EyeRadioTest(radiologist, treatment, patientAlp, doctorCan);
                                doctorCan.addTreatment(patientAlp, eyeRadioTest);
                                nurse.setTests(eyeRadioTest);
                                nurse.sendTest();
                            } else if (name.equals("Ceren")) {
                                EyeRadioTest eyeRadioTest = new EyeRadioTest(radiologist, treatment, patientCeren, doctorCan);
                                doctorCan.addTreatment(patientCeren, eyeRadioTest);
                                nurse.setTests(eyeRadioTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }


                        } else if (choice == 3) {//hemogram
                            for (Patient p : doctorCan.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Alp")) {
                                HemogramTest hemogramTest = new HemogramTest(laborant, treatment, patientAlp, doctorCan);
                                doctorCan.addTreatment(patientAlp, hemogramTest);
                                nurse.setTests(hemogramTest);
                                nurse.sendTest();
                            } else if (name.equals("Ceren")) {
                                HemogramTest hemogramTest = new HemogramTest(laborant, treatment, patientCeren, doctorCan);
                                doctorCan.addTreatment(patientCeren, hemogramTest);
                                nurse.setTests(hemogramTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else if (choice == 4) {//hormone
                            for (Patient p : doctorCan.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Alp")) {
                                HormoneTest hormoneTest = new HormoneTest(laborant, treatment, patientAlp, doctorCan);
                                doctorCan.addTreatment(patientAlp, hormoneTest);
                                nurse.setTests(hormoneTest);
                                nurse.sendTest();
                            } else if (name.equals("Ceren")) {
                                HormoneTest hormoneTest = new HormoneTest(laborant, treatment, patientCeren, doctorCan);
                                doctorCan.addTreatment(patientCeren, hormoneTest);
                                nurse.setTests(hormoneTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else if (choice == 5) {//MRI
                            for (Patient p : doctorCan.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Alp")) {
                                MRITest mriTest = new MRITest(technician, treatment, patientAlp, doctorCan);
                                doctorCan.addTreatment(patientAlp, mriTest);
                                nurse.setTests(mriTest);
                                nurse.sendTest();
                            } else if (name.equals("Ceren")) {
                                MRITest mriTest = new MRITest(technician, treatment, patientCeren, doctorCan);
                                doctorCan.addTreatment(patientCeren, mriTest);
                                nurse.setTests(mriTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }
                        } else if (choice == 6) {//Xray
                            for (Patient p : doctorCan.patients) {
                                System.out.println(p.toString());
                            }
                            System.out.println("Select the patient: ");

                            String name = scanner.next();
                            if (name.equals("Alp")) {
                                XrayTest xrayTest = new XrayTest(technician, treatment, patientAlp, doctorCan);
                                doctorCan.addTreatment(patientAlp, xrayTest);
                                nurse.setTests(xrayTest);
                                nurse.sendTest();
                            } else if (name.equals("Ceren")) {
                                XrayTest xrayTest = new XrayTest(technician, treatment, patientCeren, doctorCan);
                                doctorCan.addTreatment(patientCeren, xrayTest);
                                nurse.setTests(xrayTest);
                                nurse.sendTest();
                            } else {
                                System.out.println("Such a patient does not exist in the system");
                            }

                        } else {
                            System.out.println("Invalid choice");
                        }

                    }
                    else if(doctorChoice==2)
                    {
                        System.out.println("Enter your message: ");
                        String message= scanner.next();

                        doctorCan.CancelAppointments(message);

                    }
                    else
                    {
                        System.out.println("Invalid choice");
                    }
                }
                else if (doctorSelection == 0)
                {
                    System.out.println("Logging out of the system.Have a nice day.");
                    break;
                }
                else {
                    System.out.println("Invalid choice");
                }

            }
            else if(firstChoice==2)
            {
                System.out.println("*************************************");
                System.out.println("For which patient do you want to calculate the invoice?");
                System.out.println("*************************************");
                System.out.println("1 - Emre");
                System.out.println("2 - Toprak");
                System.out.println("3 - Sıla");
                System.out.println("4 - Buse");
                System.out.println("5 - Ceren");
                System.out.println("6 - Alp");
                System.out.println("*************************************");
                System.out.println("Please make a selection:");

                int patientChoice = scanner.nextInt();
                if (patientChoice == 1)
                {
                    System.out.println(CalculateCost(patientEmre));
                }
                else if(patientChoice == 2)
                {
                    System.out.println(CalculateCost(patientToprak));

                }
                else if(patientChoice == 3)
                {
                    System.out.println(CalculateCost(patientSıla));

                }
                else if(patientChoice == 4)
                {
                    System.out.println(CalculateCost(patientBuse));

                }
                else if(patientChoice == 5)
                {
                    System.out.println(CalculateCost(patientCeren));
                }
                else if(patientChoice == 6)
                {
                    System.out.println(CalculateCost(patientAlp));
                }
            }
            else if(firstChoice == 3)
            {
                Appointment appointment = Appointment.getAppointment();
                appointment.displayAppointments();
            }
            else if(firstChoice == 0)
            {
                System.out.println("Logging out of the system");

                break;
            }
            else
            {
                System.out.println("Invalid choice");

            }



        }


    }
    public static String CalculateCost(Patient patient){
        Treatment treatment = new Inspection();
        Laborant laborant = new Laborant("default", "default");
        Technician technician = new Technician("default", "default");
        Radiologist radiologist = new Radiologist("default", "default");
        Doctor doctor = new Doctor("default", "default", null);
        for (Treatment patientTreatment: patient.treatmentServices) {
            if (patientTreatment.getClass().getName().equals("CholesterolTest")){
                treatment = new CholesterolTest(laborant, treatment,patient,doctor);
            }
            else if (patientTreatment.getClass().getName().equals("HormoneTest")) {
                treatment = new HormoneTest(laborant, treatment,patient,doctor);
            }
            else if (patientTreatment.getClass().getName().equals("HemogramTest")) {
                treatment = new HemogramTest(laborant, treatment,patient,doctor);
            }
            else if (patientTreatment.getClass().getName().equals("MRITest")) {
                treatment = new MRITest(technician, treatment,patient,doctor);
            }
            else if (patientTreatment.getClass().getName().equals("XrayTest")) {
                treatment = new XrayTest(technician, treatment,patient,doctor);
            }
            else if (patientTreatment.getClass().getName().equals("EyeRadioTest")) {
                treatment = new EyeRadioTest(radiologist,treatment,patient,doctor);
            }

        }
        return treatment.getTreatmentsMethod() +"\n"+treatment.Cost();
    }

}
