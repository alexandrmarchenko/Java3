package lesson8.spring;

public class Surgeon implements IDoctor {
    private String type = "surgeon";

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void heal(IPatient patient) {
        System.out.println("Хирург вылечил пациента номер " + patient.getNUmber());
    }
}
