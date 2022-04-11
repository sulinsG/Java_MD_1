package models;

import java.sql.Date;

public class Teacher extends Employee {

    private TeachingLevel teachingLevel;


    public TeachingLevel getTeachingLevel() {
        return this.teachingLevel;
    }

    public void setTeachingLevel(TeachingLevel teachingLevel) {
        this.teachingLevel = teachingLevel;
    }

    public Teacher(Date contractDate,TeachingLevel teachingLevel) {
        super();
        setTeachingLevel(teachingLevel);
    }
    
    public Teacher(String name, String surname, String personalCode, Date contractDate, TeachingLevel teachingLevel)
    {
        super(name,surname,personalCode, contractDate);
        setTeachingLevel(teachingLevel);


    }

    @Override
    public String toString() {
        return "{" +
            " teachingLevel='" + getTeachingLevel() + "'" +
            "}";
    }

}
