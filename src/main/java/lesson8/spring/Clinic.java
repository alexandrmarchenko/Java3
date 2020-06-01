package lesson8.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("clinic")
@Scope("prototype")
public class Clinic implements IClinic {
    private List<IDoctor> doctors;

//    public void addDoctor(IDoctor doctor) {
//        this.doctors.add(doctor);
//    }

    public void setDoctors(List<IDoctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public void takePatient(IPatient patient) {
        System.out.println("Поступил пациент номер " + patient.getNUmber());
        for (IDoctor doctor : doctors) {
            if (doctor.getType().equals(patient.getType())) {
                doctor.heal(patient);
            }
        }

    }
}
