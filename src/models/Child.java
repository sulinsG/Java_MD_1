package models;

public class Child extends Person implements Comparable<Child>{
    private String allergies;
    private int priorityForSpeechLessons;
    private Nationality nationality;


    public Nationality getNationality() {
        return this.nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }


    public String getAllergies() {
        return this.allergies;
    }

    public void setAllergies(String allergies) {
        if(!allergies.isEmpty() && allergies.matches("[A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]+"))
            this.allergies = allergies;
        else
        this.allergies = "Unknown";
    }

    public int getPriorityForSpeechLessons() {
        return this.priorityForSpeechLessons;
    }

    public void setPriorityForSpeechLessons(int priorityForSpeechLessons) {
        if(priorityForSpeechLessons >= 1 && priorityForSpeechLessons <= 6)
        this.priorityForSpeechLessons = priorityForSpeechLessons;
        else
        this.priorityForSpeechLessons = 0;
    }


    public Child() {
        super();
        setNationality(Nationality.OTHER);
        setAllergies("Unknown");
        setPriorityForSpeechLessons(0);
    }

    public Child(String name, String surname, String personalCode, String allergies, int priorityForSpeechLessons, Nationality nationality) {

        super(name,surname,personalCode);
        setNationality(nationality);
        setAllergies(allergies);
        setPriorityForSpeechLessons(priorityForSpeechLessons);
    }

    @Override
    public String toString() {
        return "{" +
        super.getName() + "_" + super.getSurname() + "_" + super.getPersonalCode()+ "_" +
            " allergies='" + getAllergies() + "'" +
            ", priorityForSpeechLessons='" + getPriorityForSpeechLessons() + "'" +
            "}";
    }

    public int compareTo(Child child)
    {
        return this.getPriorityForSpeechLessons() - child.getPriorityForSpeechLessons();
    }


    
}
