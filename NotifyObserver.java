interface Observer {
    public void updateAppointmentState(String messages);
}

interface Subject{
    public void notifyPatient(String message);
}