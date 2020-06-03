package lesson8.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IPatient surgeonPatient = context.getBean("surgeonPatient", IPatient.class);
        IPatient therapistPatient = context.getBean("therapistPatient", IPatient.class);

        IClinic clinic = context.getBean("clinic", IClinic.class);
        clinic.takePatient(surgeonPatient);
        clinic.takePatient(therapistPatient);
    }
}
