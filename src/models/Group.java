package models;

import java.util.ArrayList;

public class Group extends Child {
    private short groupStartYear;
    private String title;
    private ArrayList<Child> allChildrenInGroup = new ArrayList<>();
    private Teacher teacher;

    public ArrayList<Child> getAllChildrenInGroup() {
        return this.allChildrenInGroup;
    }

    public void setAllChildrenInGroup(ArrayList<Child> allChildrenInGroup) {
        if(allChildrenInGroup != null)
        this.allChildrenInGroup = allChildrenInGroup;
        else
        this.allChildrenInGroup = new ArrayList<>();
    }


    public short getGroupStartYear() {
        return this.groupStartYear;
    }

    public void setGroupStartYear(short groupStartYear) {
        if(groupStartYear >= 2022 && groupStartYear <= 2023)
        this.groupStartYear = groupStartYear;
        else
        this.groupStartYear = 0;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if(!title.isEmpty() && title.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+"))
        this.title = title;
        else
        this.title = "Nezinīši";
    }

    public void setTeacher(Teacher teacher)
    {
        if(teacher != null)
        this.teacher = teacher;
        else
        this.teacher = new Teacher();
    }
    public Teacher getTeacher()
    {
        return this.teacher;
    }

    public Group() {
        super();
        setTitle("Nezinīši");
        setGroupStartYear((short)0);
    }

    public Group(short groupStartYear, String title) {
        super();
        setTitle("Nezinīši");
        setGroupStartYear((short)0);
    }


    public boolean addChildInGroup(Child child)
    {
        if(child != null && !allChildrenInGroup.contains(child))
        {
            allChildrenInGroup.add(child);
            return true;
        }
        else
        return false;
    }   
     
    public boolean removeChildFromGroup(Child child)
    {
        if(child != null && allChildrenInGroup.contains(child))
        {
            allChildrenInGroup.remove(child);
            return true;
        }
        else
        return false;
    }
    
    @Override
    public String toString() {
        return "{" +
            " groupStartYear='" + getGroupStartYear() + "'" +
            ", title='" + getTitle() + "'" +
            "}";
    }

    
    
}
