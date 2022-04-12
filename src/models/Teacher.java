package models;

import java.sql.Date;

public class Teacher extends Employee {

    private TeachingLevel teachingLevel;


    public TeachingLevel getTeachingLevel() {
        return this.teachingLevel;
    }

    public void setTeachingLevel(TeachingLevel teachingLevel) {
        if(teachingLevel != null)
        this.teachingLevel = teachingLevel;
        else
        this.teachingLevel = TeachingLevel.PRESCHOOL;
    }

    public Teacher() {
        super();
        setTeachingLevel(TeachingLevel.PRESCHOOL);
    }
    
    public Teacher(String name, String surname, String personalCode, Date contractDate, TeachingLevel teachingLevel)
    {
        super(name,surname,personalCode, contractDate);
        setTeachingLevel(teachingLevel);
    }



    @Override
    public String toString() {
        return "{" +
        super.getName() + "_" + super.getSurname() + "_" + super.getPersonalCode()+ "_" +
            " teachingLevel='" + getTeachingLevel() + "'" + getEmployeeId() + "_" +
            "}";
    }

}
