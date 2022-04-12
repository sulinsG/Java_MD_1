package service;

import models.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainService
{

    public static ArrayList<Teacher> teacherList = new ArrayList<>();
    public static ArrayList<SpeechTherapist> speechTeacherList = new ArrayList<>();
    public static ArrayList<Child> childList = new ArrayList<>();
    public static ArrayList<Group> groupList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("All the teachers:");
        addNewTeacher("Viens", "Divi", "010203-10006", new Date(0, 0, 0),TeachingLevel.PRESCHOOL); 
        addNewTeacher("Vārds", "Uzvārds","010203-10007", new Date(0, 0, 0),TeachingLevel.TODDLER);
        addNewTeacher("Tests", "Testiņš", "010203-10008", new Date(0, 0, 0),TeachingLevel.YOUNGCHILD);
        showAllTeachers();
        drawALine();
        
        
        System.out.println("all the speech teachers");
        addNewSpeechTeacher("Viens", "Divi", "010203-10009", new Date(0, 0, 0), "Pēršana");
        addNewSpeechTeacher("Tests", "Tests", "010203-10010", new Date(0, 0, 0), "Ignorēšana");
        addNewSpeechTeacher("Vārds", "Uzvārds", "010203-10011", new Date(0, 0, 0), "Nekāda");
        showAllSpeechTherapists();
        drawALine();

        addNewChild("Viens", "Divi", "010203-10012", "Laktoze",(short) 2, Nationality.ESTONIAN);
        addNewChild("Viens", "Divi", "010203-10013", "Gala",(short) 4, Nationality.LATVIAN);
        addNewChild("Pēteris", "Palaidnis","010203-10014", "Nav",(short) 3,Nationality.LITHUANIAN);
       
        addNewGroup("Palaidņi", (short)2021, teacherList.get(0));
        addNewGroup("Nepalaidņi", (short)2022, teacherList.get(1));
        addNewGroup("Ciems", (short)2023, teacherList.get(2));

        addChildInGroup(childList.get(0), groupList.get(0));
        addChildInGroup(childList.get(1), groupList.get(1));
        addChildInGroup(childList.get(2), groupList.get(2));

        System.out.println("All children by start year:");
        showAllChildrenByGroupByStartYear((short)2022);
        drawALine();

        System.out.println("All children by group:");
        showAllChildrenInGroup(groupList.get(0));
        drawALine();

        System.out.println("all children in speecch lesson by speech therapist personal code:");
        subscribeChildForSpeechLessonsByPersonalCode("010203-10012", speechTeacherList.get(0));
        showAllChildrenInSpeechLessonBySpeechTherapistPersonalCode("010203-10009");
        drawALine();

        addNewChild("Jānis", "Azvārds", "123456-00002", "Zivis",(short) 5, Nationality.LATVIAN);
        addNewChild("Jānis", "Bzvārds", "123456-00003", "Mušas",(short) 5, Nationality.LATVIAN);

        addChildInGroup(childList.get(3),groupList.get(0));
        addChildInGroup(childList.get(4),groupList.get(0));

        System.out.println("Children sorted in group by surnames:");
        sortChildrenInGroupBySurname(groupList.get(0));
        drawALine();
        
        System.out.println("Removing a child by personal code");
        removeChildByPersonalCode("123456-00003");
        showAllChildrenInGroup(groupList.get(0));
        drawALine();

        System.out.println("List of all groups");
        for (Group tmp: groupList) {
            System.out.println(tmp.getTitle());
        }
        drawALine();

        removeGroupByTitleAndYearAndTeacher(groupList.get(0).getTitle(), groupList.get(0).getGroupStartYear(), teacherList.get(0));
        System.out.println("After removing a group");
        for (Group tmp : groupList) {
            System.out.println(tmp.getTitle());
        }
        drawALine();

        System.out.println("all the teachers");
        showAllTeachers();
        drawALine();

        System.out.println("After removing two");
        removeTeacherByEmployeeId(0);
        removeTeacherByPersonalCode("010203-10007");
        showAllTeachers();
        drawALine();
        
        System.out.println("all the speechtherapists");
        showAllSpeechTherapists();
        drawALine();

        System.out.println("after removing two");
        removeSpeechTherapistByEmployeeId(3);
        removeSpeechTherapistByPersonalCode("010203-10010");
        showAllSpeechTherapists();
        drawALine();

        

    }

    public static void drawALine()
    {
        System.out.println("----------------------------------------------------------------");
    }
    public static boolean addNewTeacher(String name, String surname, String personalCode, Date contractDate, TeachingLevel teachingLevel)
    {
        Teacher teacher = new Teacher(name,surname,personalCode,contractDate,teachingLevel);
        if(teacherList.contains(teacher))
        {
            return false;
        }
        else{
            teacherList.add(teacher);
            return true;
        }
    }
    public static boolean addNewSpeechTeacher(String name, String surname, String personalCode, Date contractDate, String workingMethods)
    {
        
        SpeechTherapist speechTherapist = new SpeechTherapist(name,surname,personalCode,contractDate,workingMethods);
        if(speechTeacherList.contains(speechTherapist))
        {
            return false;
        }
        else{
            speechTeacherList.add(speechTherapist);
            return true;
        }
    }
    public static boolean addNewChild(String name, String surname, String personalCode, String allergies, short priorityForSpeechLessons, Nationality nationality)
    {
        Child child = new Child(name, surname, personalCode, allergies, priorityForSpeechLessons, nationality);

        if(childList.contains(child))
        {
            return false;
        }
        else{
            childList.add(child);
            return true;
        }
    }
    public static boolean addNewGroup(String title, short groupStartYear, Teacher teacher)
    {
    
        Group group = new Group(title,groupStartYear, teacher);
        if(groupList.contains(group))
        {
            return false;
        }
        else{
            groupList.add(group);
            return true;
        }
    }
    public static boolean addChildInGroup(Child child, Group group)
    {
        if(child != null && group != null)
        {
            if(groupList.contains(group) && !group.getAllChildrenInGroup().contains(child)) 
            {
                group.addChildInGroup(child);
                return true;
            }
            else
            return false;

        }
        else
        return false;
    }

    public static void showAllTeachers()
    {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }
    public static void showAllSpeechTherapists()
    {
        for (SpeechTherapist teacher : speechTeacherList) {
            System.out.println(teacher);
        }
    }
    public static void showAllChildrenInGroup(Group group)
    {
        for (Child child : group.getAllChildrenInGroup()) {
            System.out.println(child);
        }
    }
    public static void showAllChildrenInSpeechLessonBySpeechTherapistPersonalCode(String personalCode) {
        if(!personalCode.isEmpty() && personalCode.matches("[0-9]{6}[-][0-9]{5}"))
        {
            for (SpeechTherapist speechTherapist : speechTeacherList) {
                if(speechTherapist.getPersonalCode() == personalCode)
                {
                    for (Child child : speechTherapist.getAllChildrenAtSpeechLessons()) {
                        System.out.println(child);
                    }
                    return;
                }
            }
            System.out.println("No speech therapist match with the entered personal code");
        }
        else
        System.out.println("Invalid personal code");     
    }

    public static void showAllChildrenByGroupByStartYear(short groupStartYear)
    {
        if(groupStartYear >= 2021 && groupStartYear <= 2023)
        {
            for (Group group : groupList) {
                if(group.getGroupStartYear() == groupStartYear)
                {
                    for (Child child : group.getAllChildrenInGroup()) {
                        System.out.println(child);                        
                    }
                    return;
                }
            }
            System.out.println("No group started in year " + groupStartYear);
        }
        System.out.println("Invalid start year");
    }

    public static boolean removeTeacherByPersonalCode (String personalCode)
    {
        if(!personalCode.isEmpty() && personalCode.matches("[0-9]{6}[-][0-9]{5}"))
        {
            for (Teacher teacher : teacherList) {
                if(teacher.getPersonalCode() == personalCode)
                {
                    teacherList.remove(teacher);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeTeacherByEmployeeId(int employeeId)
    {
        if(employeeId >= 0)
        {
            for (Teacher teacher :teacherList) {
                if(teacher.getEmployeeId() == employeeId)
                {
                    teacherList.remove(teacher);
                    return true;
                }
                
            }
        }
        return false;
    }
    public static boolean removeSpeechTherapistByEmployeeId(int employeeId) {
        if(employeeId >= 0)
        {
            for (SpeechTherapist teacher :speechTeacherList) {
                if(teacher.getEmployeeId() == employeeId)
                {
                    speechTeacherList.remove(teacher);
                    return true;
                }
                
            }
        }
        return false;
        
    }

    public static boolean removeSpeechTherapistByPersonalCode(String personalCode) {
        if(!personalCode.isEmpty() && personalCode.matches("[0-9]{6}[-][0-9]{5}"))
        {
            for (SpeechTherapist teacher :speechTeacherList) {
                if(teacher.getPersonalCode() == personalCode)
                {
                    speechTeacherList.remove(teacher);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeChildByPersonalCode(String personalCode) {
        if(!personalCode.isEmpty() && personalCode.matches("[0-9]{6}[-][0-9]{5}"))
        {
            for (Child tmp :childList) {
                if(tmp.getPersonalCode() == personalCode)
                {
                    for (Group grp : groupList) {
                        if(grp.getAllChildrenInGroup().contains(tmp))
                        {
                            grp.removeChildFromGroup(tmp);
                            childList.remove(tmp);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
        
    }
    
    public static boolean removeGroupByTitleAndYearAndTeacher(String title, short groupStartYear, Teacher teacher) {
        if(title.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+") && (groupStartYear >= 2021 && groupStartYear <= 2023) && teacher != null)
        {
            for (Group tmp : groupList) {
                if(tmp.getTitle() == title && tmp.getGroupStartYear() == groupStartYear && tmp.getTeacher() == teacher)
                {
                    groupList.remove(tmp);
                    return true;
                }
                
            }
        }
        return false;
        
    }

    public static boolean subscribeChildForSpeechLessonsByPersonalCode(String personalCode, SpeechTherapist speechTherapist) {
        if(!personalCode.isEmpty() && personalCode.matches("[0-9]{6}[-][0-9]{5}") && speechTherapist != null)
        {
            for (Child child : childList) {
                if(child.getPersonalCode() == personalCode)
                {
                    speechTherapist.addChildByPriority(child);
                    return true;
                }
            }
        }

        return false;
        
    }

    public static void sortChildrenInGroupBySurname(Group group)
    {
        // https://www.geeksforgeeks.org/how-to-sort-arraylist-using-comparator/
        if(group != null && group.getAllChildrenInGroup().size() > 0)
        {
           ArrayList<Child> allChildren = group.getAllChildrenInGroup();       
           
           Collections.sort(allChildren,new SurnameComparator());
            for (Child child : allChildren) {
                System.out.println(child);
            }
        }
    }

    
    public static void generateLunch(String products)
    {
        
    }
}
class SurnameComparator implements Comparator<Child> {
    public int compare(Child c1, Child c2)
    {
        return c1.getSurname().compareTo(c2.getSurname());
    }
}