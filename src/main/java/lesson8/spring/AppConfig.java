package lesson8.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("spring")
public class AppConfig {
//    @Bean(name = "therapist")
//    public IDoctor therapist() {
//        return new Therapist();
//    }
//
//    @Bean(name = "surgeon")
//    public IDoctor surgeon() {
//        return new Surgeon();
//    }

    @Bean(name = "doctors")
    public List<IDoctor> doctors() {
        List<IDoctor> doctors = new ArrayList<>();
        doctors.add(new Therapist());
        doctors.add(new Surgeon());
        return doctors;
    }

    @Bean(name = "clinic")
    public IClinic clinic(List<IDoctor> doctors) {
        Clinic clinic = new Clinic();
        //clinic.addDoctors(doctors);
        clinic.setDoctors(doctors);
        return clinic;
    }

    @Bean(name = "therapistPatient")
    public IPatient therapistPatient() {
        Patient patient = new Patient();
        patient.setType("therapist");
        return patient;
    }

    @Bean(name = "surgeonPatient")
    public IPatient surgeonPatient() {
        Patient patient = new Patient();
        patient.setType("surgeon");
        return patient;
    }
}
