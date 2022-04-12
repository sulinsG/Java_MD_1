package models;

import java.util.Date;

public class Employee extends Person {
    //1. mainigie
    private int employeeId;
    private static int employeeCounter = 0;
    private Date contractDate;
    private String contractNumber;
    private Person person;
    //2.1 get funckijas


    public int getEmployeeId() {
        return employeeId;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    //2.2 set funkcijas


    public void setEmployeeId() {
        this.employeeId = employeeCounter++;
    }

    Date checkingDate= new Date(2022,3,22); // izmantoju novecojušu funkciju, saglabāju "references" datumu mainīgajā
    public void setContractDate(Date contractDate) {
        if(contractDate.after(checkingDate))
        {
            this.contractDate = contractDate;
        }
        else
        this.contractDate = new Date();
    }


    public void setContractNumber() {

        //substring funkcija pienem 2 argumentus - sakuma indeksu un beigu indeksu, atgriez attiecigos String elementus
        //https://reactgo.com/java-get-first-character-of-string/
        this.contractNumber = (checkingDate.
        getYear() +
                "_" + employeeId +
                "_" + super.getName().substring(0,1) +
                "_" + super.getSurname().substring(0,1));

    }

    public Employee()
    {
        super();
        setEmployeeId();
        setContractNumber();
        setContractDate(new Date(2022,3,23));
    }

    public Employee(String name, String surname, String personalCode, Date contractDate)
    {
        super(name,surname,personalCode);
        setEmployeeId();
        setContractNumber();
        setContractDate(contractDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", contractDate=" + contractDate +
                ", contractNumber='" + contractNumber + '\'' +
                ", person=" + person +
                ", checkingDate=" + checkingDate +
                '}';
    }
}

