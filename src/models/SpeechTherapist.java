package models;

import java.sql.Date;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
//https://www.callicoder.com/java-priority-queue/
public class SpeechTherapist extends Employee {
    private String workingMethods;
    PriorityQueue<Child> allChildrenAtSpeechLessons = new PriorityQueue<Child>(); // maximum 5 members


    public String getWorkingMethods() {
        return this.workingMethods;
    }

    public void setWorkingMethods(String workingMethods) {
        if(!workingMethods.isEmpty() && workingMethods.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+"))
        this.workingMethods = workingMethods;
        else
        this.workingMethods = "Unknown";
    }

    public PriorityQueue<Child> getAllChildrenAtSpeechLessons() {
        return this.allChildrenAtSpeechLessons;
    }

    public void setAllChildrenAtSpeechLessons(PriorityQueue<Child> allChildrenAtSpeechLessons) {
        if(allChildrenAtSpeechLessons != null && allChildrenAtSpeechLessons.size() <= 5)
        this.allChildrenAtSpeechLessons = allChildrenAtSpeechLessons;
        else
        this.allChildrenAtSpeechLessons = new PriorityQueue<>();
    }


    public SpeechTherapist() {
        super();
        setWorkingMethods("Unknown");
    }

    public SpeechTherapist(String name, String surname, String personalCode, Date contractDate, String workingMethods) {
        super(name, surname, personalCode, contractDate);
        setWorkingMethods(workingMethods);
    }



    @Override
    public String toString() {
        return "{" +
        super.getName() + "_" + super.getSurname() + "_" + super.getPersonalCode()+ "_" +
            " workingMethods='" + getWorkingMethods() + "'" +
            ", allChildrenAtSpeechLessons='" + getAllChildrenAtSpeechLessons() + "'" + getEmployeeId() + "_" +
            "}";
    }

    public int addChildByPriority(Child child)
    {
        if(child != null && allChildrenAtSpeechLessons.size() < 5 && (child.getPriorityForSpeechLessons() < 5 && child.getPriorityForSpeechLessons() >= 1))
        {
            allChildrenAtSpeechLessons.add(child);
            return 0;
        }

        else
        return 100;
    }

    

}
