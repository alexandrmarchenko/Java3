package lesson8.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("patient")
@Scope("prototype")
public class Patient implements IPatient {
    static int count = 0;
    private int number;
    private String type;

    public Patient() {
        this.number = ++count;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getNUmber() {
        return this.number;
    }
}
