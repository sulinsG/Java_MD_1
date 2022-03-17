package models;

public class Person {
    //1.mainigie
    private String name;
    private String surname;
    private String personalCode;


    //2.1 get funckijas


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    //2.2. set funkcijas


    public void setName(String name) {
        if(name != null && name.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+"))//\p{L}+
        {
            this.name = name;
        }
        else
            this.name = "notknown";
    }

    public void setSurname(String surname) {
        if(surname != null && surname.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+"))//\p{L}+
        {
            this.surname = surname;
        }
        else
            this.surname = "notknown";
    }

    public void setPersonalCode(String personalCode) {
        if(personalCode != null && personalCode.matches("[0-9]{6}[-][0-9]{5}"))
        {
            this.personalCode = personalCode;
        }
        else
            this.personalCode = "000000-00000";
    }


    //3. konstruktori
    public Person()
    {
        setName("Test");
        setSurname("Mctesty");
        setPersonalCode("000000-00000");
    }
    public Person(String name, String surname, String personalCode)
    {
        setName(name);
        setSurname(surname);
        setPersonalCode(personalCode);
    }

    //4. tostring funckija


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personalCode='" + personalCode + '\'' +
                '}';
    }
}
