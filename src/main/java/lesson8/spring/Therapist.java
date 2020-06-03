package lesson8.spring;

public class Therapist implements IDoctor {
    private String type = "therapist";

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void heal(IPatient patient) {
        System.out.println("Терапевт вылечил пациента номер " + patient.getNUmber());
    }
}
